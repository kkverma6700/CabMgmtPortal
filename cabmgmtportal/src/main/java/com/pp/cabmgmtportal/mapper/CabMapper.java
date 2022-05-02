package com.pp.cabmgmtportal.mapper;

import com.pp.cabmgmtportal.dto.CabDTO;
import com.pp.cabmgmtportal.dto.RegisterCabDTO;
import com.pp.cabmgmtportal.entity.Cab;

import java.time.LocalDateTime;

public class CabMapper {

    public static Cab toEntity(RegisterCabDTO dto){

        return Cab.builder().cityName(dto.getCityName().toUpperCase()).cabId(dto.getCabId()).lastUpdateTime(LocalDateTime.now()).cabState("IDLE").build();
    }

    public static CabDTO toDTO(Cab entity){

        return CabDTO.builder().cityName(entity.getCityName()).cabId(entity.getCabId()).lastUpdateTime(entity.getLastUpdateTime()).cabState(entity.getCabState()).build();
    }
}
