package com.pp.cabmgmtportal.rest;

import com.pp.cabmgmtportal.dto.CityDTO;
import com.pp.cabmgmtportal.dto.OnboardCitiesDTO;
import com.pp.cabmgmtportal.service.IOnboardService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onboard")
@OpenAPIDefinition(info = @Info(title = "Cab Onboard WebService"))
public class OnboardRestService {

    private IOnboardService service;
    @PostMapping("/onboardCity")
    @Operation(summary = "Onboard New City")
    public String onboardCity(@RequestBody OnboardCitiesDTO dto){
        return service.onboardCity(dto.getCities());
   }

    @GetMapping("/allOnboardedCity")
    @Operation(summary = "Get All onboarded cities")
    public List<CityDTO> getAllOnboardedCities(){
        return service.getAllOnboardedCities();
   }

    @Autowired
    public void setService(IOnboardService service) {
        this.service = service;
    }
}
