package lk.ijse.cmjd108.LibMgmt2025.service;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;

import java.util.List;

public interface BookService {
    void addBook(BookDTO bookDTO);
    void deleteBook(String bookId);
    void updateBook(String bookId, BookDTO bookDTO);
    BookDTO getSelectedBook(String bookId);
    List<BookDTO> getAllBooks();
}
