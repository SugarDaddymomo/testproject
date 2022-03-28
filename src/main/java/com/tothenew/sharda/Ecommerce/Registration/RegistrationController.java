package com.tothenew.sharda.Ecommerce.Registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private RegistrationService registrationService;

    @PostMapping(path = "/customer")
    public String register(@Valid @RequestBody RegistrationRequestCustomer request) {
        return registrationService.registerAsCustomer(request);
    }

    @PostMapping(path = "/seller")
    public String register(@Valid @RequestBody RegistrationRequestSeller request) {
        return registrationService.registerAsSeller(request);
    }

    @PutMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping(path = "confirm")
    public String confirmByEmail(@RequestParam("email") String email) {
        return registrationService.confirmByEmail(email);
    }
}