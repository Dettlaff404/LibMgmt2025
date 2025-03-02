package lk.ijse.cmjd108.LibMgmt2025.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LendingDTO implements Serializable {
    private String lendingId;
    private String member;
    private String book;
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private Boolean isActiveLending;
    private Long overDueDays;
    private Double fineAmount;
}
