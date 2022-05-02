package com.pp.cabmgmtportal.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterCabDTO {
    private String cabId;
    private String cityName;
}
