package TTTN.service;

import TTTN.dto.HistoryActionDTO;
import TTTN.entity.HistoryActionEntity;
import TTTN.repository.HistoryActionRepository;
import TTTN.service.imp.HistoryActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class HistoryActionServiceImp implements HistoryActionService {
    @Autowired
    HistoryActionRepository historyActionRepository;
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public boolean createHistory(HistoryActionEntity historyAction) {
        try {
            historyActionRepository.save(historyAction);
            return true;
        }catch (Exception ex){
            System.out.println("Loi tao history " + ex.getMessage());
            return false;
        }
    }

    @Override
    public List<HistoryActionDTO> getAllHistoryActionByUserId(int userId) {
        List<HistoryActionEntity> list = historyActionRepository.getAllHistoryActionByUserId(userId);
        List<HistoryActionDTO> historyActionDTOS = new ArrayList<>();
        for (HistoryActionEntity history : list) {
            HistoryActionDTO historyActionDTO = new HistoryActionDTO();
            historyActionDTO.setId(history.getId());
            historyActionDTO.setContent(history.getContent());
            historyActionDTO.setTime(history.getTime());
            historyActionDTOS.add(historyActionDTO);
        }
        historyActionDTOS.sort(Comparator.comparing(HistoryActionDTO::getTime).reversed());//sort historyActionDTO theo Time theo thuat toan TimSort(Merge + Insertion Sort)
        return historyActionDTOS;
    }
    @Override
    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanHistory() {
        LocalDateTime sevenDaysAgo = LocalDateTime.now().minusDays(7);
        entityManager.createQuery("DELETE FROM history_action h WHERE h.time < :sevenDaysAgo")
                .setParameter("sevenDaysAgo", sevenDaysAgo)
                .executeUpdate();
    }
}
