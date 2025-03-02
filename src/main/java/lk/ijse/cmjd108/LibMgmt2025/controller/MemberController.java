package lk.ijse.cmjd108.LibMgmt2025.controller;

import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.exception.MemberNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addMember(@RequestBody MemberDTO memberDTO){
        if (memberDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        memberService.saveMember(memberDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteMember(@RequestParam("memberId") String memberId) {
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            memberService.deleteMember(memberId);
            return ResponseEntity.noContent().build();
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateMember(@RequestParam String memberId, @RequestBody MemberDTO memberDTO){
        if (memberId == null || memberDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            memberService.updateMember(memberId, memberDTO);
            return ResponseEntity.noContent().build();
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<MemberDTO> getSelectedMember(@RequestParam String memberId) {
        if (memberId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            return ResponseEntity.ok(memberService.getSelectedMember(memberId));
        } catch (MemberNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("getallmembers")
    public ResponseEntity<List<MemberDTO>> getAllMembers() {
        return ResponseEntity.ok(memberService.getAllMembers());
    }
}
