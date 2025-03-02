package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Override
    public void addBook(BookDTO bookDTO) {
        //Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(UtilData.generateTodayDate());
        bookDTO.setLastUpdateTime(UtilData.genrateCurrentTime());
        //Pass to Dao
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {

    }

    @Override
    public BookDTO getSelectedBook(String bookId) {
        return null;
    }

    @Override
    public List<BookDTO> getAllBooks() {
        return null;
    }
}
