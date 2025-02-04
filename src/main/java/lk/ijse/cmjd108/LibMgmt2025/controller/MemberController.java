package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
public class MemberController {

    @GetMapping("health")
    public String healthCheck(){
        return "Member Controller is Working";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam ("memberId") String memberId){
        System.out.println(memberId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{memberId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@PathVariable String memberId, @RequestBody MemberDTO memberDTO){
        System.out.println(memberId);
        System.out.println(memberDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<MemberDTO> getSelectedMember(@PathVariable String memberId) {
        System.out.println("Get Selected Book for " + memberId);
        return ResponseEntity.ok(new MemberDTO());
    }

    @GetMapping
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        return ResponseEntity.ok(new ArrayList<>());
    }
}
