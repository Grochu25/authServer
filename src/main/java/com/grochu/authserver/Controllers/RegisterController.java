package com.grochu.authserver.Controllers;

import com.grochu.authserver.Model.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterController
{
    public final UserRepo userRepo;
    public final RegisterUserDetailsRepo registerUserDetailsRepo;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegisterForm(Model model)
    {
        model.addAttribute("userDetails", new RegisterUserDetails());
        log.info("Entered register form");
        return "registerForm";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model)
    {
        model.addAttribute("userDetails", new UserLoginDTO("",""));
        log.info("Entered login form");
        return "login";
    }

    @PostMapping("/register")
    public String saveUser(@Valid RegisterUserDetails userDetails, Model model)
    {
        if(!userDetails.getPassword().equals(userDetails.getConfirmPassword()))
        {
            model.addAttribute("passwordCheck", "Hasła nie są takie same");
            model.addAttribute("userDetails", userDetails);
            return "registerForm";
        }
        if(userRepo.findByLogin(userDetails.getEmail()) != null){
            Map<String, String> errorsMap = new HashMap<>();
            errorsMap.put("email", "Istnieje już konto z tym adresem email");
            model.addAttribute("errorMessages", errorsMap);
            model.addAttribute("userDetails", userDetails);
            return "registerForm";
        }
        registerUserDetailsRepo.save(userDetails);
        userRepo.save(new User(userDetails.getEmail(),passwordEncoder.encode(userDetails.getPassword()),"USER"));

        return "redirect:/login";
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleValidationExceptions(MethodArgumentNotValidException ex, Model model) {
        RegisterUserDetails userDetails = (RegisterUserDetails) ex.getBindingResult().getTarget();

        Map<String, String> errorsMap = new HashMap<>();
        Arrays.stream(ex.getDetailMessageArguments()[1].toString().split(", and")).forEach(
                s -> errorsMap.put(s.substring(0,s.indexOf(":")).strip(),s.substring(s.indexOf(":")+1).strip())
        );


        model.addAttribute("userDetails", userDetails);
        model.addAttribute("errorMessages", errorsMap);
        log.info("User Validation failed for: {}", userDetails);
        return "registerForm";
    }
}
