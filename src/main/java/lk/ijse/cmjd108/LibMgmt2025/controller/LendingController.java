package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
public class LendingController {

    @GetMapping("health")
    public String healthCheck(){
        return "Lending Controller is Working";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO){
        System.out.println(lendingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam ("lendingId") String lendingId){
        System.out.println(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> handOverBook(@PathVariable String lendingId, @RequestBody LendingDTO lendingDTO){
        System.out.println(lendingId);
        System.out.println(lendingDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{lendingId}")
    public ResponseEntity<LendingDTO> getSelectedLending(@PathVariable String lendingId) {
        System.out.println("Get Selected Book for " + lendingId);
        return ResponseEntity.ok(new LendingDTO());
    }

    @GetMapping
    public ResponseEntity<List<LendingDTO>> getAllLendings() {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
