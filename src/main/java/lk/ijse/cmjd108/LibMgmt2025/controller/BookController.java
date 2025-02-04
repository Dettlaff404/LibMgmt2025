package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @GetMapping("health")
    public String healthCheck(){
        return "Book Controller is Working";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam ("bookIdKey") String bookIdValue){
        System.out.println(bookIdValue);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO){
        System.out.println(bookId);
        System.out.println(bookDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId) {
        System.out.println("Get Selected Book for " + bookId);
        return ResponseEntity.ok(new BookDTO("B005",
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

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
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

        return ResponseEntity.ok(bookDTOList);
    }

}
