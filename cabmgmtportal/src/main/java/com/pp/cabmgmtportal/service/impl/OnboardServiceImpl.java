package com.pp.cabmgmtportal.service.impl;

import com.pp.cabmgmtportal.common.CabMgmtConstants;
import com.pp.cabmgmtportal.dto.CityDTO;
import com.pp.cabmgmtportal.entity.City;
import com.pp.cabmgmtportal.mapper.CityMapper;
import com.pp.cabmgmtportal.repository.CityRepository;
import com.pp.cabmgmtportal.service.IOnboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OnboardServiceImpl implements IOnboardService {

    private CityRepository cityRepository;

    @Override
    public String onboardCity(List<CityDTO> cities){

        List<City> cityList=cities.stream().map(CityMapper::toEntity).collect(Collectors.toList());
        cityRepository.saveAll(cityList);
        return CabMgmtConstants.CITY_ONBOARD_SUCCESS;
    }

    @Override
    public List<CityDTO> getAllOnboardedCities(){
        return cityRepository.findAll().stream().map(CityMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public boolean isCityOnboarded(String cityName) {
        return cityRepository.findById(cityName).isPresent();
    }

    @Autowired
    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
}
