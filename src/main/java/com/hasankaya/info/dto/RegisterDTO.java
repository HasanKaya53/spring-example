package com.hasankaya.info.dto;


import lombok.Data;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;


@Data
public class RegisterDTO {

    @NotBlank(message = "Username cannot be empty")
    @Size(min = 3, max = 20, message = "Username must be 3-20 characters")
    private String username;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Pattern.List({
        @Pattern(regexp = ".*[A-Z].*", message = "Password must contain at least one uppercase letter"),
        @Pattern(regexp = ".*[a-z].*", message = "Password must contain at least one lowercase letter"),
        @Pattern(regexp = ".*\\d.*", message = "Password must contain at least one digit"),
        @Pattern(regexp = ".*[!@#$%^&*._()].*", message = "Password must contain at least one special character")
    })
    private String password;

    @NotBlank(message = "Email cannot be empty")
    @Email(message = "Email should be valid")
    @Size(max = 50, message = "Email must be less than 50 characters")
    private String email;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Phone number must be valid and contain 10-15 digits")
    @Size(max = 15, message = "Phone number must be less than 15 characters")
    private String phone;

}
