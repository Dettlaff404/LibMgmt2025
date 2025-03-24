package lk.ijse.cmjd108.LibMgmt2025.dao.secure;

import lk.ijse.cmjd108.LibMgmt2025.entities.secure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail(String email);
}
