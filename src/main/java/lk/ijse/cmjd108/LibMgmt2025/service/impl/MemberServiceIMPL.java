package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dao.MemberDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.MemberDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.MemberService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceIMPL implements MemberService {

    private final MemberDao memberDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void saveMember(MemberDTO memberDTO) {
        memberDTO.setMemberId(UtilData.generateMemberId());
        memberDTO.setMembershipDate(UtilData.generateTodayDate());
        memberDao.save(entityDTOConvert.convertMemberDTOToMemberEntity(memberDTO));
    }

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {

    }

    @Override
    public void deleteMember(String memberId) {

    }

    @Override
    public MemberDTO getSelectedMember(String memberId) {
        return null;
    }

    @Override
    public List<MemberDTO> getAllMembers() {
        return null;
    }
}
