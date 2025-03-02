package lk.ijse.cmjd108.LibMgmt2025.dao;

import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends JpaRepository<BookEntity, String> {
    //JPQL query
    @Query("SELECT SUM(b.availableQty) FROM BookEntity b WHERE b.bookId= :bookId")
    int availQty(@Param("bookId") String bookId);
}
