package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.component.AuthenticationUtils;
import pl.coderslab.entity.PersonalData;
import pl.coderslab.entity.Task;
import pl.coderslab.entity.User;
import pl.coderslab.service.PersonalDataService;
import pl.coderslab.service.TaskService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final PersonalDataService personalDataService;
    private final TaskService taskService;
    private final AuthenticationUtils authenticationUtils;

    public HomeController(TaskService taskService, AuthenticationUtils authenticationUtils, PersonalDataService personalDataService) {
        this.taskService = taskService;
        this.authenticationUtils = authenticationUtils;
        this.personalDataService = personalDataService;
    }

    @GetMapping("/home")
    public String homeGet(Model model){
        Optional<User> optionalUser = authenticationUtils.getCurrentUser();
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            List<Task> tasks = taskService.listTask(user);
            model.addAttribute("tasks", tasks);

            PersonalData data = personalDataService.findByUser(user);
            model.addAttribute("data", data);
        }
        return "home";
    }

}
