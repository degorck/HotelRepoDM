package com.example.demo.dto;

import com.example.demo.dto.response.ResponseGuestTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GuestDTO {
    @NotEmpty(message = "Guest First Name is required")
    private String firstName;
    @NotEmpty(message = "Guest Last Name is required")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Email(message = "A valid email is required")
    private String email;
    private ResponseGuestTypeDTO type;
}
