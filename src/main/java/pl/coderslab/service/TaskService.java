package pl.coderslab.service;

import org.springframework.stereotype.Service;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }


    public Optional<Task> findById(Long id){
        return taskRepository.findById(id);
    }

    public Optional<Task> deleteTaskById(Long id){
        return taskRepository.deleteTaskById(id);
    }

    public List<Task> listTask(User user){
        return taskRepository.findAllTaskByUser(user);
   }

   public List<Task> finshedTask(Task task){
        List<Task> finshTask = new ArrayList<>();
        finshTask.add(task);
        return finshTask;
   }
}
