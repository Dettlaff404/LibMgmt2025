package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dao.StaffDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.Role;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.entities.StaffEntity;
import lk.ijse.cmjd108.LibMgmt2025.exception.StaffNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StaffServiceIMPL implements StaffService {

    private final StaffDao staffDao;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void saveStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(UtilData.generateStaffId());
        staffDTO.setLastUpdate(UtilData.generateTodayDate());
        staffDTO.setLastUpdateTime(UtilData.genrateCurrentTime());
        staffDao.save(entityDTOConvert.convertStaffDTOToStaffEntity(staffDTO));
    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffMemberDTO) {
        Optional<StaffEntity> selectedStaff = staffDao.findById(staffId);
        if (!selectedStaff.isPresent()){
            throw new StaffNotFoundException("Staff member not found");
        }
        selectedStaff.get().setFirstName(staffMemberDTO.getFirstName());
        selectedStaff.get().setLastName(staffMemberDTO.getLastName());
        selectedStaff.get().setEmail(staffMemberDTO.getEmail());
        selectedStaff.get().setLastUpdate(UtilData.generateTodayDate());
        selectedStaff.get().setLastUpdateTime(UtilData.genrateCurrentTime());
        selectedStaff.get().setJoinDate(staffMemberDTO.getJoinDate());
        selectedStaff.get().setPhone(staffMemberDTO.getPhone());
        selectedStaff.get().setRole(staffMemberDTO.getRole());
    }

    @Override
    public void deleteStaffMember(String staffId) {
        if (!staffDao.findById(staffId).isPresent()){
            throw new StaffNotFoundException("Staff member not found");
        }
        staffDao.deleteById(staffId);
    }

    @Override
    public StaffDTO getSelectedStaffMember(String staffId) {
        if (!staffDao.findById(staffId).isPresent()){
            throw new StaffNotFoundException("Staff member not found");
        }
        return entityDTOConvert.convertStaffEntityToStaffDTO(staffDao.getReferenceById(staffId));
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        return entityDTOConvert.toStaffDTOList(staffDao.findAll());
    }
}
