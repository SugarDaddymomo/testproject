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
public class RegistrationRequestSeller {

    private final String firstName;
    private final String lastName;

    @NotEmpty
    @Size(min = 10, max = 10, message = "Phone number must be of 10 digits")
    private final Long companyContact;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Email should be unique and valid")
    @NotEmpty(message = "Email cannot be empty")
    private final String email;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password must be equal or greater than 8 characters but less than 16 characters")
    private final String password;

    @NotEmpty
    @Size(min = 8, max = 16, message = "Password should be same to Password")
    private final String confirmPassword;

    @NotEmpty
    @Pattern(regexp = "[A-Za-z0-9]", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Company name should be unique")
    private final String companyName;

    @Size(min = 15, max = 15)
    @Pattern(regexp = "[01-35]+[A-Z0-9]+[1]+[Z]+[0-9a-zA-Z]", message = "GST number should be according to Indian Govt. norms")
    private final String gstNumber;
}