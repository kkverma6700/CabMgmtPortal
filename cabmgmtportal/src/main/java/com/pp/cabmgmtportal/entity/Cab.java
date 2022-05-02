package com.pp.cabmgmtportal.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cab {
    @Id
    private String cabId;
    private String cabState;
    private String cityName;
    private LocalDateTime lastUpdateTime;
}
