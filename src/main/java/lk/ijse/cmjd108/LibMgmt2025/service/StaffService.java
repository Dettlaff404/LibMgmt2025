package lk.ijse.cmjd108.LibMgmt2025.service;

import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaffMember(StaffDTO staffDTO);
    void updateStaffMember(String staffId, StaffDTO staffMemberDTO);
    void deleteStaffMember(String staffId);
    StaffDTO getSelectedStaffMember(String staffId);
    List<StaffDTO> getAllStaffMembers();
}
