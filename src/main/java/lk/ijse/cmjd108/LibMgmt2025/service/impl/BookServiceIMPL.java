package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dao.BookDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.BookEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.BookNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookServiceIMPL implements BookService {

    private final BookDao bookDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addBook(BookDTO bookDTO) {
        //Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(UtilData.generateTodayDate());
        bookDTO.setLastUpdateTime(UtilData.genrateCurrentTime());
        //Pass to Dao
        bookDao.save(entityDTOConvert.convertBookDTOToBookEntity(bookDTO));
    }

    @Override
    public void deleteBook(String bookId) {
        //Check Availability
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Book Not Found");
        }
        bookDao.deleteById(bookId);
    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Book Not Found");
        }
        foundBook.get().setBookName(bookDTO.getBookName());
        foundBook.get().setAuthor(bookDTO.getAuthor());
        foundBook.get().setTotalQty(bookDTO.getTotalQty());
        foundBook.get().setAvailableQty(bookDTO.getAvailableQty());
        foundBook.get().setEdition(bookDTO.getEdition());
        foundBook.get().setPublisher(bookDTO.getPublisher());
        foundBook.get().setIsbn(bookDTO.getIsbn());
        foundBook.get().setPrice(bookDTO.getPrice());
        foundBook.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundBook.get().setLastUpdateTime(UtilData.genrateCurrentTime());
    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        Optional<BookEntity> foundBook = bookDao.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("SelectedBook Not Found");
        }
        return entityDTOConvert.convertBookEntityToBookDTO(bookDao.getReferenceById(bookId));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return null;
    }
}
