package pl.coderslab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.component.RegisterMailer;

@RestController
public class TestController {

    private final RegisterMailer registerMailer;

    public TestController(RegisterMailer registerMailer) {
        this.registerMailer = registerMailer;
    }

    @RequestMapping("send")
    public String sendMail(){
        registerMailer.sendMessage("projektkoncowymichal@gmail.com", "Temat", "text");
        return "mail sent";
    }
}
