package com.pp.cabmgmtportal.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CabDTO {
    private String cabId;
    private String cabState;
    private String cityName;
    private LocalDateTime lastUpdateTime;
}
