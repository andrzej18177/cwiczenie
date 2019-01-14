package pl.hospital.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.hospital.dto.UserDto;


@Controller
@Slf4j
public class HomeController {


    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("user", new UserDto());

        return "home";
    }
}
