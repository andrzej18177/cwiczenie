package pl.hospital.controller;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.hospital.dto.UserDto;
import pl.hospital.entity.User;
import pl.hospital.service.PatientService;
import pl.hospital.service.UserService;

@Slf4j
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    PatientService patientService;

    @Autowired
    UserService userService;

    @GetMapping(value = "/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDto());

        return "login";
    }


    @GetMapping(value = "/signup")
    public String signUp(Model model) {

        model.addAttribute("user", new UserDto());

        return "signup";
    }


    @PostMapping(value = "/signup")
    public String createUser(Model model, UserDto us){

        model.addAttribute("user", us);

        if (userService.userExists(us.getLogin())){
            String info = "Użytkownik " + us.getLogin() + " już istnieje!";
            model.addAttribute("info", info);
            return "signup";
        }

        userService.createNewUser(us);

        return "login.html";
    }


    @ModelAttribute
    @PostMapping(value = "/login")
    public String logOn(Model model, UserDto us){

        model.addAttribute("user", us);

        if (!userService.userExists(us.getLogin())){
            String info = "Taki użytkownik nie istnieje! Zarejestruj się!";
            model.addAttribute("errorLogin", info);
            return "signup";
        }
        return "home.html";
    }



}
