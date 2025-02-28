package lk.ijse.cmjd108.LibMgmt2025.service;

import lk.ijse.cmjd108.LibMgmt2025.dto.LendingDTO;

import java.util.List;

public interface LendingService {
    void addLendingData(LendingDTO lendingDTO);
    void handOverBook(String lendingId);
    void deleteLendingData(String lendingId);
    LendingDTO getSelectedLendingData(String lendingId);
    List<LendingDTO> getAllLendingData();
}
