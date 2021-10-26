package com.example.demo.dto;

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
public class SubscribersDTO {
    @NotEmpty(message = "Guest First Name is required")
    private String name;
    @NotEmpty(message = "Email is required")
    @Email(message = "A valid email is required")
    private String email;
}
