package com.example.demo.dto;

import com.example.demo.dto.response.ResponseGuestDTO;
import com.example.demo.dto.response.ResponseRoomDTO;
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
public class ReservationDTO {
    private ResponseRoomDTO room;
    private ResponseGuestDTO guest;
    private Date startDate;
    private Date endDate;
}
