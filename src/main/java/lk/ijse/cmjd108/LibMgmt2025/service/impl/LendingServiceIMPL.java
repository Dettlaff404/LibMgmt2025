package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.LendingDao;
import lk.ijse.cmjd108.LibMgmt2025.dao.MemberDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.*;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.LendingMapping;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LendingServiceIMPL implements LendingService {

    @Value("${perDayFine}")     //Value Injection
    private Double perDayAmount;

    private final LendingMapping lendingMapping;
    private final LendingDao lendingDao;
    private final BookDao bookDao;
    private final MemberDao memberDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        //relevant book
        //relevant member
        String bookId = lendingDTO.getBook();
        String memberId = lendingDTO.getMember();
        BookEntity bookEntity = bookDao.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book Not Found"));
        MemberEntity memberEntity = memberDao.findById(memberId).orElseThrow(() -> new MemberNotFoundException("Member Not Found"));

        //check the availability
        if (bookDao.availQty(bookId) > 0) {
            //books are available
            if (bookDao.deductBasedOnLending(bookId) > 0) {
                //process the lending
                lendingDTO.setLendingId(UtilData.generateLendingId());
                lendingDTO.setLendingDate(UtilData.generateTodayDate());
                lendingDTO.setReturnDate(UtilData.generateBookReturnDate());
                lendingDTO.setIsActiveLending(true);
                lendingDTO.setOverDueDays(0L);
                lendingDTO.setFineAmount(0.0);
                lendingDao.save(LendingMapping.toLendingEntity(lendingDTO, bookEntity, memberEntity));
            }else {
                throw new DataPersistException("Cannot Update book data with 0 available count");
            }

        } else {
            throw new EnoughBooksNotFoundException("Not Enough Books to Process");
        }


        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(UtilData.generateTodayDate());
        lendingDTO.setReturnDate(UtilData.generateBookReturnDate());
        lendingDTO.setIsActiveLending(true);
        lendingDTO.setOverDueDays(0L);
        lendingDTO.setFineAmount(0.0);
        System.out.println(lendingDTO);
    }

    @Override
    public void handOverBook(String lendingId) {
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending Record Not Found"));
        LocalDate returnDate = foundLending.getReturnDate();
        Long overDue = calcOverDue(returnDate); //overdue date count
        Double fineAmount = calcFine(overDue);        //fine amount

        foundLending.setOverDueDays(overDue);
        foundLending.setFineAmount(fineAmount);
        foundLending.setIsActiveLending(false);
        //Update the book qty against the bookId
        bookDao.addBookBasedBookHandOver(foundLending.getBook().getBookId());

    }

    @Override
    public void deleteLendingData(String lendingId) {
        //validating the id
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending Record Not Found"));
        lendingDao.deleteById(lendingId);
        //add the book when deleting the record
        if (foundLending.getIsActiveLending()){
            bookDao.addBookBasedBookHandOver(foundLending.getBook().getBookId());
        }

    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
        LendingEntity foundLending = lendingDao.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending Record Not Found"));
        return LendingMapping.toLendingDTO(foundLending);
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
        return null;
    }

    private Long calcOverDue(LocalDate returnDate){
        LocalDate today = UtilData.generateTodayDate();
        if (returnDate.isBefore(today)){
            return ChronoUnit.DAYS.between(today,returnDate);
        }
        return 0L;
    }

    private Double calcFine(Long datCount){
        return datCount * perDayAmount;
    }
}

