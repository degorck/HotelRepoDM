package com.example.demo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SearchAvailableRoomDTO {
    Date from;
    Date to;
}
