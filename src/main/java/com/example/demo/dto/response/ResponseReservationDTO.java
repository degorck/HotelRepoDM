package com.example.demo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class ResponseReservationDTO {
    private Long id;
    private ResponseRoomDTO room;
    private ResponseGuestDTO guest;
    private Date startDate;
    private Date endDate;
    private boolean status;
    private boolean checkIn;
    private boolean checkOut;
    private List<ResponseChildGuestDTO> childGuestList;
}
