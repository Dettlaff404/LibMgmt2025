package lk.ijse.cmjd108.LibMgmt2025.dao;

import lk.ijse.cmjd108.LibMgmt2025.entities.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffDao extends JpaRepository<StaffEntity, String> {
}
