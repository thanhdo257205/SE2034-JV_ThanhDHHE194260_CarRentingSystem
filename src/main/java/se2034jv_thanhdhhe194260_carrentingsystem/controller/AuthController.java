package se2034jv_thanhdhhe194260_carrentingsystem.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import se2034jv_thanhdhhe194260_carrentingsystem.dto.RegisterDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.dto.CustomerDTO;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Account;
import se2034jv_thanhdhhe194260_carrentingsystem.entities.Role;
import se2034jv_thanhdhhe194260_carrentingsystem.service.CustomerService;
import se2034jv_thanhdhhe194260_carrentingsystem.service.RegisterService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AuthController {

    private final RegisterService registerService;
    private final CustomerService customerService;

    @GetMapping(path = {"/", "/login"})
    public String showLoginPage(Model model) {
        model.addAttribute("account", new Account());
        return "auth/login";
    }

    @PostMapping("/do-login")
    public String doLogin(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        CustomerDTO customerDTO = null;
        try {
            customerDTO = customerService.findByUserNameAndPassword(username, password);
        } catch (Exception ex) {
            model.addAttribute("error", ex.getMessage());
            return "auth/login";
        }
        session.setAttribute("user", customerDTO);
        if (customerDTO.getRole().equals(Role.ADMIN)) {
            return "redirect:/admin/dashboard";
        }
        return "redirect:/cars/list";
    }

    @GetMapping("/register")
    public String showRegisterPage(Model model) {
        model.addAttribute("register", new RegisterDTO());
        return "auth/register";
    }

    @PostMapping("/customer/register")
    public String doRegister(@Valid @ModelAttribute("register") RegisterDTO registerDTO, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "auth/register";
        }
        try {
            registerService.registerAccount(registerDTO);
        } catch (Exception e) {
            log.info("error at auth controller register " + e.getMessage());
            bindingResult.reject("error", e.getMessage());
            return "auth/register";
        }
        return "redirect:/login";
    }
}
