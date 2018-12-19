package com.spring.henallux.templatesSpringProject.model.form.register;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RegisterForm {

    private Integer userId;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    private String confirmPassword;

    private String authorities;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean credentialsNonExpired;

    private Boolean enabled;

    @NotBlank
    private String email;

    @NotBlank
    private String firstname;

    @NotBlank
    private String name;

    @NotBlank
    private String addressStreetName;

    @Min(0)
    private Integer addressNumber;

    private String addressBox;

    @NotBlank
    private String addressLocality;

    @NotBlank
    @Min(1000)
    @Max(9999)
    private String addressPostalCode;


}
