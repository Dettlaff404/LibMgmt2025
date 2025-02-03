package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.BookDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @GetMapping("health")
    public String healthCheck(){
        return "Book Controller is Working";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookDTO addBook(@RequestBody BookDTO bookDTO){
        System.out.println(bookDTO);
        return bookDTO;
    }

}
