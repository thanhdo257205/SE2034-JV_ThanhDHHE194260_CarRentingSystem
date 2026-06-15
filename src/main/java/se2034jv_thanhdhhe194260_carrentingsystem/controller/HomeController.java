package se2034jv_thanhdhhe194260_carrentingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        return "customer/home";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "admin/dashboard";
    }

    @GetMapping("/adminManager")
    public String adminGenter(Model model) {
        return "admin/rental-management";
    }

    @GetMapping("/adminProducer")
    public String adminGenterPro(Model model) {
        return "admin/car-management";
    }
}
