package com.pp.cabmgmtportal.rest;

import com.pp.cabmgmtportal.dto.RegisterCabDTO;
import com.pp.cabmgmtportal.service.IRegistrationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/register/")
@OpenAPIDefinition(info = @Info(title = "Cab Registration WebService"))
public class RegisterRestService {

    IRegistrationService  service;

    @PostMapping("/registerCab")
    @Operation(summary = "Register New Cabs")
    public String register(@RequestBody List<RegisterCabDTO> cabs){
        return service.register(cabs);
    }


    @Autowired
    public void setService(IRegistrationService service) {
        this.service = service;
    }
}
