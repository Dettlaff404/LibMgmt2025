package lk.ijse.cmjd108.LibMgmt2025.dao;

import lk.ijse.cmjd108.LibMgmt2025.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDao extends JpaRepository<MemberEntity, String> {
}
