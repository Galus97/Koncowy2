package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t where t.user=:currentUser")
    List <Task> findAllTaskByUser(User currentUser);

    Optional<Task> findById(Long id);

    Optional<Task> deleteTaskById(Long id);
}
