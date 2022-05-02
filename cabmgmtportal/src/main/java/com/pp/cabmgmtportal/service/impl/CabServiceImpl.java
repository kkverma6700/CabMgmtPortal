package com.pp.cabmgmtportal.service.impl;

import com.pp.cabmgmtportal.dto.BookingResponseDTO;
import com.pp.cabmgmtportal.dto.CabDTO;
import com.pp.cabmgmtportal.dto.RegisterCabDTO;
import com.pp.cabmgmtportal.entity.Cab;
import com.pp.cabmgmtportal.mapper.CabMapper;
import com.pp.cabmgmtportal.repository.CabRepository;
import com.pp.cabmgmtportal.service.ICabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.pp.cabmgmtportal.common.CabMgmtConstants.*;

@Service
public class CabServiceImpl implements ICabService {

    private CabRepository repository;

    @Override
    public List<CabDTO> getAllCabStatus(){
        return repository.findAll().stream().map(CabMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String completeTrip(String cabId){

        Optional<Cab> cabOptional=repository.findById(cabId);
        if(cabOptional.isPresent()){
            Cab cab=cabOptional.get();
            if(ON_TRIP.equalsIgnoreCase(cab.getCabState())){
                cab.setCabState(IDLE);
                cab.setLastUpdateTime(LocalDateTime.now());
                repository.save(cab);
                return COMPLETE_TRIP;
            }else{
              return IDLE_CAB;
            }
        }else{
            return CAB_NOT_FOUND+cabId;
        }
    }

    @Transactional
    @Override
    public BookingResponseDTO bookCab(String cityName){

        Cab cab=repository.findFirstByCityNameAndCabStateOrderByLastUpdateTime(cityName,IDLE);
        if(cab==null){
            return BookingResponseDTO.builder().cabId(cityName).isSuccess(FALSE).message(NO_CAB_AVAILABLE).build();
        }
        cab.setCabState(ON_TRIP);
        cab.setLastUpdateTime(LocalDateTime.now());
        repository.save(cab);

        return BookingResponseDTO.builder().cityName(cityName).cabId(cab.getCabId()).isSuccess(TRUE).message(BOOKING_SUCCESS+cab.getCabId()).build();
    }

    @Override
    public String updateLocation(RegisterCabDTO dto){

        Optional<Cab> cabOptional=repository.findById(dto.getCabId());

        if(cabOptional.isPresent()){
            Cab cab=cabOptional.get();
            cab.setCityName(dto.getCityName());
            repository.save(cab);

            return LOCATION_UPDATED_SUCCESS;
        }else {
            return CAB_NOT_FOUND;
        }

    }

    @Autowired
    public void setRepository(CabRepository repository) {
        this.repository = repository;
    }
}
