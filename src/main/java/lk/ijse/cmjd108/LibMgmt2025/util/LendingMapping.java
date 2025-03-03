package lk.ijse.cmjd108.LibMgmt2025.util;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<LendingDTO> getLendingDTOList(List<LendingEntity> lendingEntities) {
        return lendingEntities.stream().map(entity -> {
            LendingDTO lendingDTO = new LendingDTO();
            lendingDTO.setLendingId(entity.getLendingId());

            if (entity.getMember() != null) {
                lendingDTO.setMember(entity.getMember().getMemberId());
            }

            if (entity.getBook() != null) {
                lendingDTO.setBook(entity.getBook().getBookId());
            }

            lendingDTO.setLendingDate(entity.getLendingDate());
            lendingDTO.setReturnDate(entity.getReturnDate());
            lendingDTO.setIsActiveLending(entity.getIsActiveLending());
            lendingDTO.setOverDueDays(entity.getOverDueDays());
            lendingDTO.setFineAmount(entity.getFineAmount());

            return lendingDTO;
        }).collect(Collectors.toList());
    }
}
