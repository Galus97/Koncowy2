package pl.coderslab.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.entity.User;
import pl.coderslab.exception.ValidationException;
import pl.coderslab.service.RegistrationService;

import java.util.List;

@Controller
public class UserController {

    private final RegistrationService registrationService;
    //private final UserDetailsService userDetailsService;

    public UserController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            System.out.println("bindingResult.hasErrors");
            return "register";
        }
        try{
            registrationService.newUserRegistration(user);
            System.out.println("login");
            return "redirect:login";
        } catch (ValidationException exception){
            List<String> errors = exception.getValidationErrors();
            model.addAttribute("errors", errors);
            System.out.println("errors");
            return "register";
        }
    }

    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }
}
