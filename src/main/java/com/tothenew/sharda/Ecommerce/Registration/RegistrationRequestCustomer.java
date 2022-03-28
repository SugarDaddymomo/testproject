package com.tothenew.sharda.Ecommerce.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestCustomer {

    private final String firstName;
    private final String lastName;

    @NotEmpty
    @Size(min = 10, max = 10, message = "Phone number must be of 10 digits")
    private final Long contact;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email should be unique and valid")
    @NotEmpty(message = "Email cannot be empty")
    private final String email;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters but less than 16 characters")
    private final String password;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password should be same to Password")
    private final String confirmPassword;
}