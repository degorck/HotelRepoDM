package com.example.demo.dto.request;

import com.example.demo.dto.GuestDTO;
import com.example.demo.dto.ReservationDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationAndGuestDTO {
    @Valid
    GuestDTO guest;
    ReservationDTO reservation;
}
