package se2034jv_thanhdhhe194260_carrentingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarListController {

    @GetMapping("/cars/list")
    public String listCars(Model model) {
        return "admin/producer-management";
    }

}
