package se2034jv_thanhdhhe194260_carrentingsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarListController {

    @GetMapping("/cars/list")
    public String listCars(Model model) {
        return "/customer/car-list";
    }
}
