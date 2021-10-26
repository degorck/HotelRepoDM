package com.example.demo.dto;

import com.example.demo.dto.response.ResponseGuestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationLogDTO {
    private Long id;
    private String hotelName;
    private String roomName;
    private ResponseGuestDTO guest;
    private Date startDate;
    private Date endDate;
}
