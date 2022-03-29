package com.tothenew.sharda.Ecommerce.Registration;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
    public ResponseEntity<Object> register(@Valid @RequestBody RegistrationRequestSeller request) {
        registrationService.registerAsSeller(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("api/v1/registration/seller").buildAndExpand(request.getEmail()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

    @PostMapping(path = "/customer/confirm")
    public String confirmByEmail(@RequestParam("email") String email) {
        return registrationService.confirmByEmail(email);
    }
}