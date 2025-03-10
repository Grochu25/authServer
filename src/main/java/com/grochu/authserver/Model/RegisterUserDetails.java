package com.grochu.authserver.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserDetails
{
    @NotBlank(message = "Imie nie może być puste")
    private String name;
    @NotBlank(message = "Nazwisko nie może być puste")
    private String surname;
    @NotBlank(message = "Email jest wymagany")
    @Email(message = "Podany Email jest niepoprawny")
    private String email;
    private String phoneNumber;
    @NotBlank(message="adres korespondencyjny jest wymagany")
    private String addressStreet;
    @NotBlank(message="adres korespondencyjny jest wymagany")
    private String addressCity;
    @NotBlank(message="adres korespondencyjny jest wymagany")
    private String addressState;
    @Pattern(regexp="^([0-9][0-9])([-])([0-9][0-9][0-9])$", message="Nieprawidłowy format kodu pocztowego")
    @NotBlank(message="adres korespondencyjny jest wymagany")
    private String addressZip;

    @NotBlank(message = "Nie można utworzyć konta bez hasła")
    private String password;
    private String confirmPassword;
}
