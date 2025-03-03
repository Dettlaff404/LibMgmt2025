package lk.ijse.cmjd108.LibMgmt2025.controller;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.exception.*;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/lendings")
@RequiredArgsConstructor
@Transactional
public class LendingController {

    private final LendingService lendingService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO){
        if (lendingDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            lendingService.addLendingData(lendingDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (BookNotFoundException | MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (DataPersistException | EnoughBooksNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam ("lendingId") String lendingId){
        lendingService.deleteLendingData(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping
    public ResponseEntity<Void> handOverBook(@RequestParam("lendingId") String lendingId){
        if (lendingId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            lendingService.handOverBook(lendingId);
            return ResponseEntity.noContent().build();
        } catch (LendingDataNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/{lendingId}")
    public ResponseEntity<LendingDTO> getSelectedLending(@PathVariable String lendingId) {
        return ResponseEntity.ok(lendingService.getSelectedLendingData(lendingId));
    }

    @GetMapping
    public ResponseEntity<List<LendingDTO>> getAllLendings() {
        return ResponseEntity.ok(lendingService.getAllLendingData());
    }
}
