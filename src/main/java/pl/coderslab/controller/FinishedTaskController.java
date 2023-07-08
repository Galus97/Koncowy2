package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.coderslab.component.AuthenticationUtils;
import pl.coderslab.entity.FinishedTask;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.service.FinishedTaskService;
import pl.coderslab.service.TaskService;

@Controller
public class FinishedTaskController {
    private final FinishedTaskService finishedTaskService;
    private final TaskService taskService;
    private final AuthenticationUtils authenticationUtils;

    public FinishedTaskController(FinishedTaskService finishedTaskService, TaskService taskService, AuthenticationUtils authenticationUtils) {
        this.finishedTaskService = finishedTaskService;
        this.taskService = taskService;
        this.authenticationUtils = authenticationUtils;
    }

    @GetMapping("/finishTask/{id}")
    public String finishTask(@PathVariable Long id) {
        Task task = taskService.findById(id).orElse(null);
        if (task != null) {
            FinishedTask finishedTask = new FinishedTask();
            finishedTask.setUser(task.getUser());
            finishedTask.setGeneralPurpose(task.getGeneralPurpose());
            finishedTask.setFirstStep(task.getFirstStep());
            finishedTask.setSecondStep(task.getSecondStep());

            finishedTaskService.saveFinishedTask(finishedTask);
            taskService.deleteTask(id);
        }
        return "redirect:/home";
    }

    @GetMapping("/finishedTasks")
    public String finishedTasks(Model model) {
        User currentUser = authenticationUtils.getCurrentUser().orElse(null);
        if (currentUser != null) {
            model.addAttribute("finishedTasks", finishedTaskService.getFinishedTasksByUser(currentUser));
            return "finishedTasks";
        }
        return "login";
    }
}

