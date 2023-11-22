package TTTN.service.imp;

import TTTN.dto.HistoryActionDTO;
import TTTN.entity.HistoryActionEntity;

import java.util.List;

public interface HistoryActionService {
    boolean createHistory(HistoryActionEntity historyAction);
    List<HistoryActionDTO> getAllHistoryActionByUserId(int userId);
    void cleanHistory();
}
