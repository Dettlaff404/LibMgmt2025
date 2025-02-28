package lk.ijse.cmjd108.LibMgmt2025.service.impl;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;
import lk.ijse.cmjd108.LibMgmt2025.service.LendingService;
import lk.ijse.cmjd108.LibMgmt2025.util.UtilData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LendingServiceIMPL implements LendingService {
    @Override
    public void addLendingData(LendingDTO lendingDTO) {
        lendingDTO.setLendingId(UtilData.generateLendingId());
        System.out.println(lendingDTO);
    }

    @Override
    public void handOverBook(String lendingId, LendingDTO lendingDTO) {

    }

    @Override
    public void deleteLendingData(String lendingId) {

    }

    @Override
    public LendingDTO getSelectedLendingData(String lendingId) {
        return new LendingDTO(
            lendingId,
            "MemberName",
            "BookTitle",
            "2023-01-01",
            "2023-01-15",
            true,
            5L,
            50.0
        );
    }

    @Override
    public List<LendingDTO> getAllLendingData() {
        List<LendingDTO> lendingDTOList = new ArrayList<>();

        lendingDTOList.add(new LendingDTO(
            "L001",
            "Alice",
            "Introduction to Algorithms",
            "2023-01-01",
            "2023-01-15",
            true,
            3L,
            15.0
        ));

        lendingDTOList.add(new LendingDTO(
            "L002",
            "Bob",
            "Design Patterns",
            "2023-02-01",
            "2023-02-14",
            true,
            2L,
            10.0
        ));

        lendingDTOList.add(new LendingDTO(
            "L003",
            "Charlie",
            "Effective Java",
            "2023-03-01",
            "2023-03-10",
            false,
            0L,
            0.0
        ));

        lendingDTOList.add(new LendingDTO(
            "L004",
            "David",
            "Clean Code",
            "2023-04-01",
            "2023-04-12",
            true,
            1L,
            5.0
        ));

        lendingDTOList.add(new LendingDTO(
            "L005",
            "Eve",
            "Java Concurrency in Practice",
            "2023-05-01",
            "2023-05-18",
            true,
            4L,
            20.0
        ));

        return lendingDTOList;
    }
}
