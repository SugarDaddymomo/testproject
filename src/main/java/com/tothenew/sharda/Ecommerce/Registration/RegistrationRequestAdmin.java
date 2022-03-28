package com.tothenew.sharda.Ecommerce.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestAdmin {
    private final String firstName;
    private final String lastName;
    private final Long contact;
    private final String email;
    private final String password;
    private final String confirmPassword;
}