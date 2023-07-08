package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.FinishedTask;
import pl.coderslab.entity.User;
import pl.coderslab.repository.FinishedTaskRepository;

import java.util.List;

@Service
public class FinishedTaskService {
    private final FinishedTaskRepository finishedTaskRepository;

    public FinishedTaskService(FinishedTaskRepository finishedTaskRepository) {
        this.finishedTaskRepository = finishedTaskRepository;
    }

    public void saveFinishedTask(FinishedTask finishedTask) {
        finishedTaskRepository.save(finishedTask);
    }

    public List<FinishedTask> getFinishedTasksByUser(User user) {
        return finishedTaskRepository.findAllByUser(user);
    }
}
