package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberServiceIMPL implements MemberService {


    @Override
    public void saveMember(MemberDTO memberDTO) {
        memberDTO.setMemberId(UtilData.generateMemberId());
        memberDTO.setMembershipDate(String.valueOf(UtilData.generateTodayDate()));
        System.out.println(memberDTO);
    }

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        return new MemberDTO(
                memberId,
                "New Member",
                "new.member@gmail.com",
                "2021-01-01");
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        List<MemberDTO> memberDTOS = new ArrayList<>();

        memberDTOS.add(new MemberDTO(
                "M001",
                "John",
                "john@gmail.com",
                "2021-01-01"
        ));
        memberDTOS.add(new MemberDTO(
                "M002",
                "Jane",
                "jane@gmail.com",
                "2021-02-01"
        ));
        memberDTOS.add(new MemberDTO(
                "M003",
                "Kamal",
                "kamal@gmail.com",
                "2021-03-01"
        ));
        memberDTOS.add(new MemberDTO(
                "M004",
                "Nimal",
                "nimal@gmail.com",
                "2021-04-01"
        ));
        memberDTOS.add(new MemberDTO(
                "M005",
                "Saman",
                "saman@gmail.com",
                "2021-05-01"
        ));

        return memberDTOS;
    }
}
