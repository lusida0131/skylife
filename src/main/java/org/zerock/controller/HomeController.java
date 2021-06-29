package org.zerock.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() throws Exception {
<<<<<<< HEAD
        return "auth/loginForm";
=======
//        return "auth/loginForm";
    	return "page/flight";
>>>>>>> e3a52d50edaac527bdc22406ad3eb71c5df6ab45
    }
}