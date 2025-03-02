package lk.ijse.cmjd108.LibMgmt2025.dao;

import lk.ijse.cmjd108.LibMgmt2025.entities.LendingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LendingDao extends JpaRepository<LendingEntity, String> {
}
