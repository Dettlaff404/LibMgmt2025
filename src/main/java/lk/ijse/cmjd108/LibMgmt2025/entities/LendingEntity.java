package lk.ijse.cmjd108.LibMgmt2025.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lending")
public class LendingEntity {
    @Id
    private String lendingId;
    @ManyToOne
    @JoinColumn(name = "bookId", nullable = false)
    private BookEntity book;
    @ManyToOne
    @JoinColumn(name = "memberId", nullable = false)
    private MemberEntity member;
    private String lendingDate;
    private String returnDate;
    private Boolean isActiveLending;
    private Long overDueDays;
    private Double fineAmount;
}
