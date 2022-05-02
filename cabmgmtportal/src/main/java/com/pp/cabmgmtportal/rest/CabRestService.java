package com.pp.cabmgmtportal.rest;

import com.pp.cabmgmtportal.common.CabMgmtConstants;
import com.pp.cabmgmtportal.dto.*;
import com.pp.cabmgmtportal.service.ICabService;
import com.pp.cabmgmtportal.service.IOnboardService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cab/")
@OpenAPIDefinition(info = @Info(title = "Cab WebService"))
public class CabRestService {

    private ICabService service;
    private IOnboardService onboardService;

    @GetMapping("/allCabStatus")
    @Operation(description = "All cabs with current status")
    public List<CabDTO> get(){
        return service.getAllCabStatus();
    }

    @PostMapping("/book")
    @Operation(summary = "Book Cab")
    public BookingResponseDTO book(@RequestBody CityDTO dto){
        if(!onboardService.isCityOnboarded(dto.getCityName().toUpperCase())){
            return BookingResponseDTO.builder().cityName(dto.getCityName()).isSuccess(CabMgmtConstants.FALSE).message(CabMgmtConstants.CITY_NOT_ONBOARDED).build();
        }
        return service.bookCab(dto.getCityName().toUpperCase());
    }

    @PostMapping("/completeTrip")
    @Operation(summary = "Complete ongoing trip")
    public String completeTrip(@RequestBody CompleteTripDTO dto){
        return service.completeTrip(dto.getCabId());
    }

    @PostMapping("/updateLocation")
    @Operation(summary = "update current location of a cab")
    public String register(@RequestBody RegisterCabDTO cab){
        return service.updateLocation(cab);
    }

    @Autowired
    public void setService(ICabService service) {
        this.service = service;
    }

    @Autowired
    public void setOnboardService(IOnboardService onboardService) {
        this.onboardService = onboardService;
    }
}
