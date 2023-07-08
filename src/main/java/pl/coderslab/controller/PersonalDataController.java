package pl.coderslab.controller;

import jakarta.validation.Valid;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.component.AuthenticationUtils;
import pl.coderslab.entity.PersonalData;
import pl.coderslab.entity.User;
import pl.coderslab.repository.UserRepository;
import pl.coderslab.service.PersonalDataService;

import java.util.Optional;

@Controller
public class PersonalDataController {

    private final PersonalDataService personalDataService;
    private final AuthenticationUtils authenticationUtils;

    public PersonalDataController(PersonalDataService personalDataService, AuthenticationUtils authenticationUtils) {
        this.personalDataService = personalDataService;
        this.authenticationUtils = authenticationUtils;
    }

    @GetMapping("/personaldata")
    public String personalDataForm(Model model) {
        PersonalData personalData = new PersonalData();

        Optional<User> optionalUser = authenticationUtils.getCurrentUser();
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            personalData.setUser(user);
            model.addAttribute("personalData", personalData);
            return "personalData";
        } else{
            return "login";
        }
    }


    @PostMapping("/personaldata")
    public String savePersonalData(@Valid PersonalData personalData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "personalData";
        }

        personalDataService.savePersonalData(personalData);
        return "home";
    }
}
