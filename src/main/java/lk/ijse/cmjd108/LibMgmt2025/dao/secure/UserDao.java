package lk.ijse.cmjd108.LibMgmt2025.dao.secure;

import lk.ijse.cmjd108.LibMgmt2025.entities.secure.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<UserEntity,String> {
    Optional <UserEntity> findByEmail(String email);
}
