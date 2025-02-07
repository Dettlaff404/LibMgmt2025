package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return (new BookDTO("B005",
                "Spring Boot - 2025",
                "Kamal Perera",
                "2nd Edition",
                "Tech Publications",
                "978-1234567890",
                3500.00,
                10,
                5,
                "2025-10-10",
                "15:30:00"
        ));
    }

    @Override
    public List<BookDTO> getAllBooks() {

        List<BookDTO> bookDTOList = new ArrayList<>();

        bookDTOList.add(new BookDTO(
                "B001",
                "Java Basics",
                "John Doe",
                "1st Edition",
                "Tech Press",
                "978-1111111111",
                1500.00,
                50,
                30,
                "2025-01-15",
                "10:00:00"
        ));

        bookDTOList.add(new BookDTO(
                "B002",
                "Advanced Java",
                "Jane Smith",
                "3rd Edition",
                "Code House",
                "978-2222222222",
                2500.00,
                40,
                35,
                "2025-02-20",
                "09:30:00"
        ));

        bookDTOList.add(new BookDTO(
                "B003",
                "Spring Framework",
                "Alan Walker",
                "2nd Edition",
                "Springer Publications",
                "978-3333333333",
                3000.00, 30,
                25,
                "2025-03-10",
                "11:45:00"
        ));

        bookDTOList.add(new BookDTO(
                "B004",
                "Microservices Design",
                "Clara Adams",
                "1st Edition",
                "Microtech Press",
                "978-4444444444",
                4000.00, 20,
                15,
                "2025-04-05",
                "14:20:00"
        ));

        bookDTOList.add(new BookDTO("B005",
                "Database Management",
                "Chris Martin",
                "4th Edition",
                "DB Books",
                "978-5555555555",
                3500.00,
                25,
                20,
                "2025-05-15",
                "16:10:00"
        ));

        return bookDTOList;
    }
}
