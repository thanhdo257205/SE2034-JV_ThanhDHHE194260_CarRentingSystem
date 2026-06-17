package se2034jv_thanhdhhe194260_carrentingsystem.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.CarProducer;
import se2034jv_thanhdhhe194260_carrentingsystem.service.CarProducerService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProducerController {

    private final CarProducerService carProducerService;

    @GetMapping("/producers/show")
    public String showProducer(Model model) {
        model.addAttribute("producer", new CarProducer());
        List<CarProducer> carProducers = null;
        if (model.containsAttribute("carProducers")) {
            carProducers = (List<CarProducer>) model.getAttribute("carProducers");
        } else {
            carProducers = carProducerService.findAllCarProducer();
            model.addAttribute("carProducers", carProducers);
        }
        return "admin/producer-management";
    }

    @GetMapping("/producers/search")
    public String searchProducer(RedirectAttributes redirectAttributes, @RequestParam("keyword") String keyword) {
        List<CarProducer> carProducers = carProducerService.findByNameOrCountry(keyword);
        redirectAttributes.addFlashAttribute("carProducers", carProducers);
        return "redirect:/producers/show";
    }

    @PostMapping("/producers/add")
    public String addProducer(@Valid @ModelAttribute("producer") CarProducer carProducer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("openModal", "true");
            return "admin/producer-management";
        }
        carProducerService.saveCarProducer(carProducer);
        return "redirect:/producers/show";
    }

    @GetMapping("/produces/remove/{id}")
    public String removeProducer(@PathVariable("id") Integer id) {
        carProducerService.removeCarProducer(id);
        return "redirect:/producers/show";
    }

}
