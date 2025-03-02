package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import jakarta.transaction.Transactional;
import lk.ijse.cmjd108.LibMgmt2025.dao.StaffDao;
import lk.ijse.cmjd108.LibMgmt2025.dto.Role;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.exception.StaffNotFoundException;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lk.ijse.cmjd108.LibMgmt2025.util.EntityDTOConvert;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

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
        staffDao.save(entityDTOConvert.convertStaffDTOToStaffEntity(staffDTO));
    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffMemberDTO) {

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
        return null;
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        return null;
    }
}
