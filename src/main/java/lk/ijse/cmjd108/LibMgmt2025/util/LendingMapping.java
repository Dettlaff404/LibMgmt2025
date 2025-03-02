package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import org.springframework.stereotype.Component;

@Component
public class LendingMapping {
    public static LendingDTO toLendingDTO(LendingEntity lendingEntity) {
        LendingDTO lendingDTO = new LendingDTO();
        lendingDTO.setLendingId(lendingEntity.getLendingId());
        lendingDTO.setMember(lendingEntity.getMember().getMemberId());
        lendingDTO.setBook(lendingEntity.getBook().getBookId());
        lendingDTO.setLendingDate(lendingEntity.getLendingDate());
        lendingDTO.setReturnDate(lendingEntity.getReturnDate());
        lendingDTO.setIsActiveLending(lendingEntity.getIsActiveLending());
        lendingDTO.setOverDueDays(lendingEntity.getOverDueDays());
        lendingDTO.setFineAmount(lendingEntity.getFineAmount());
        return lendingDTO;
    }

    public static LendingEntity toLendingEntity(LendingDTO lendingDTO, BookEntity bookEntity, MemberEntity memberEntity) {
        LendingEntity lendingEntity = new LendingEntity();
        lendingEntity.setLendingId(lendingDTO.getLendingId());
        lendingEntity.setMember(memberEntity);
        lendingEntity.setBook(bookEntity);
        lendingEntity.setLendingDate(lendingDTO.getLendingDate());
        lendingEntity.setReturnDate(lendingDTO.getReturnDate());
        lendingEntity.setIsActiveLending(lendingDTO.getIsActiveLending());
        lendingEntity.setOverDueDays(lendingDTO.getOverDueDays());
        lendingEntity.setFineAmount(lendingDTO.getFineAmount());
        return lendingEntity;
    }
}
