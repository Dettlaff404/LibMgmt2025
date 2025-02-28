package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.Role;
import lk.ijse.cmjd108.LibMgmt2025.dto.StaffDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.StaffService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class StaffServiceIMPL implements StaffService {
    @Override
    public void saveStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(UtilData.generateStaffId());
        System.out.println(staffDTO);
    }

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffMemberDTO) {

    }

    @Override
    public void deleteStaffMember(String staffId) {

    }

    @Override
    public StaffDTO getSelectedStaffMember(String staffId) {
        return new StaffDTO(
                staffId,
                "John",
                "Doe",
                "john.doe@gmail.com",
                "2022-01-01",
                "0712345678",
                Role.LIBRARIAN
        );
    }

    @Override
    public List<StaffDTO> getAllStaffMembers() {
        List<StaffDTO> staffDTOS = new ArrayList<>();
        staffDTOS.add(new StaffDTO(
                "S001",
                "John",
                "Doe",
                "john.doe@gmail.com",
                "2022-01-01",
                "0712345678",
                Role.LIBRARIAN
        ));
        staffDTOS.add(new StaffDTO(
                "S002",
                "Jane",
                "Doe",
                "jane.doe@gmail.com",
                "2022-02-01",
                "0712345679",
                Role.OFFICER
        ));
        staffDTOS.add(new StaffDTO(
                "S003",
                "Kamal",
                "Perera",
                "kamal.perera@gmail.com",
                "2022-03-01",
                "0712345680",
                Role.OFFICER
        ));
        staffDTOS.add(new StaffDTO(
                "S004",
                "Nimal",
                "Ranasinghe",
                "nimal.ranasinghe@gmail.com",
                "2022-04-01",
                "0712345681",
                Role.OFFICER
        ));
        staffDTOS.add(new StaffDTO(
                "S005",
                "Saman",
                "Kumara",
                "saman.kumara@gmail.com",
                "2022-05-01",
                "0712345682",
                Role.LIBRARIAN
        ));
        return staffDTOS;
    }
}
