package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class  BookController {

    private final BookService bookService;

    @GetMapping("health")
    public String healthCheck(){
        return "Book Controller is Working";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO){
        bookService.addBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam ("bookIdKey") String bookIdValue){
        bookService.deleteBook(bookIdValue);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO){
        bookService.updateBook(bookId, bookDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getSelectedBook(@PathVariable String bookId) {
        return ResponseEntity.ok(bookService.getSelectedBook(bookId));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

}
