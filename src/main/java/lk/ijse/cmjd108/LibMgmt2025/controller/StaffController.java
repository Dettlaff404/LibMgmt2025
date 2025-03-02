package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.exception.StaffNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/staff")
@RequiredArgsConstructor
public class StaffController {

    private final StaffService staffService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO){
        if (staffDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            staffService.saveStaffMember(staffDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam ("staffId") String staffId){
        if (staffId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            staffService.deleteStaffMember(staffId);
            return ResponseEntity.noContent().build();
        } catch (StaffNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody StaffDTO staffMemberDTO){
        staffService.updateStaffMember(staffId, staffMemberDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDTO> getSelectedStaffMember(@PathVariable String staffId) {
        return ResponseEntity.ok(staffService.getSelectedStaffMember(staffId));
    }

    @GetMapping
    public ResponseEntity<List<StaffDTO>> getAllStaffMembers() {
        return ResponseEntity.ok(staffService.getAllStaffMembers());
    }
}
