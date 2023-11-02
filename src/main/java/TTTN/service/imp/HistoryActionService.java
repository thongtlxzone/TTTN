package TTTN.service.imp;

import TTTN.dto.HistoryActionDTO;

import java.util.List;

public interface HistoryActionService {
    List<HistoryActionDTO> getAllHistoryActionByUserId(int userId);
    void cleanHistory();
}
