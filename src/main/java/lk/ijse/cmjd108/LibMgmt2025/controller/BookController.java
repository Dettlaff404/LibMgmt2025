package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
