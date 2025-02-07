package lk.ijse.cmjd108.LibMgmt2025.service;

import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    void saveMember(MemberDTO memberDTO);
    void updateMember(String memberId, MemberDTO memberDTO);
    void deleteMember(String memberId);
    MemberDTO getSelectedMember(String memberId);
    List<MemberDTO> getAllMembers();
}
