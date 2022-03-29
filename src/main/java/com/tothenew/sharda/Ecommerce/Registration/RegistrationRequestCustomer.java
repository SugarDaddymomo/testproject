package com.tothenew.sharda.Ecommerce.Registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.*;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequestCustomer {

    private final String firstName;
    private final String lastName;

    @Pattern(regexp="(^$|[0-9]{10})", message = "Phone number must be of 10 digits")
    @NotBlank(message = "Phone number cannot be empty")
    private final String contact;

    @Email(flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email should be unique and valid")
    @NotBlank(message = "Email cannot be empty")
    private final String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters but less than 16 characters")
    private final String password;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 8, max = 16, message = "Password should be same to Password")
    private final String confirmPassword;
}