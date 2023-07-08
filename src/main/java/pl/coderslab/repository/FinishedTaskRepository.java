package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.FinishedTask;
import pl.coderslab.entity.User;

import java.util.List;

public interface FinishedTaskRepository extends JpaRepository<FinishedTask, Long> {
    List<FinishedTask> findAllByUser(User user);
}
