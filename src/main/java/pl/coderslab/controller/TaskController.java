package pl.coderslab.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.component.AuthenticationUtils;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.service.TaskService;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final AuthenticationUtils authenticationUtils;

    public TaskController(TaskService taskService, AuthenticationUtils authenticationUtils) {
        this.taskService = taskService;
        this.authenticationUtils = authenticationUtils;
    }


    @GetMapping("/addtask")
    public String taskGet(Model model) {
        Task task = new Task();

        Optional<User> optionalUser = authenticationUtils.getCurrentUser();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            task.setUser(user);
            model.addAttribute("task", task);
            return "task";
        } else {
            return "login";
        }
    }



    @PostMapping("/addtask")
    public String taskPost(@Valid Task task, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "addtask";
        }

        taskService.saveTask(task);
        return "redirect:home";
    }

    @GetMapping("/taskdetails")
    public String taskdetailsGet(Model model, HttpServletRequest req){
        Long taskId = Long.parseLong(req.getParameter("id"));
        Optional<Task> task = taskService.findById(taskId);
        if (task.isPresent()) {
            model.addAttribute("task", task.get());
            return "taskDetails";
        } else {
            return "error";
        }
    }

    @GetMapping("/deleteTask")
    public String deleteTask(@RequestParam("id") Long taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/home";
    }

    @GetMapping("/finishTask")
    public String finishTask(HttpServletRequest req) {
        Long taskId = Long.parseLong(req.getParameter("id"));
        Optional<Task> task = taskService.findById(taskId);
        if(task.isPresent()){
            List<Task> finshedTask = taskService.finshedTask(task.get());

        }

        return "redirect:/home";
    }
}
