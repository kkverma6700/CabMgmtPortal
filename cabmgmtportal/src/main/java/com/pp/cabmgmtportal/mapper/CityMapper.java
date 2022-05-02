package com.pp.cabmgmtportal.mapper;

import com.pp.cabmgmtportal.dto.CityDTO;
import com.pp.cabmgmtportal.entity.City;

public class CityMapper {

    public static City toEntity(CityDTO dto){

        return City.builder().cityName(dto.getCityName().toUpperCase()).build();
    }

    public static CityDTO toDTO(City city){

        return CityDTO.builder().cityName(city.getCityName()).build();
    }
}
