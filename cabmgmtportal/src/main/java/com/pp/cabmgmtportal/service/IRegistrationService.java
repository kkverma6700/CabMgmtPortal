package com.pp.cabmgmtportal.service;

import com.pp.cabmgmtportal.dto.RegisterCabDTO;

import java.util.List;

public interface IRegistrationService {

    String register(List<RegisterCabDTO> cabs);
}
