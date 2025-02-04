package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookServiceIMPL implements BookService {
    @Override
    public void addBook(BookDTO bookDTO) {
        System.out.println("Add Book from service layer "+bookDTO);
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
        return List.of();
    }
}
