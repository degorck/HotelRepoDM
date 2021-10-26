package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseGuestDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private boolean status;
    private ResponseGuestTypeDTO type;

}
