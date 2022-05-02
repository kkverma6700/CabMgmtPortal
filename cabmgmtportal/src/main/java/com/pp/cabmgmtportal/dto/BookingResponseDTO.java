package com.pp.cabmgmtportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponseDTO {

    private String cabId;
    private String cityName;
    private String message;
    private boolean isSuccess;

}
