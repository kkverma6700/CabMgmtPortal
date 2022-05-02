package com.pp.cabmgmtportal.service;

import com.pp.cabmgmtportal.dto.CityDTO;

import java.util.List;

public interface IOnboardService {

    String onboardCity(List<CityDTO> cities);

    List<CityDTO> getAllOnboardedCities();

    boolean isCityOnboarded(String cityName);
}
