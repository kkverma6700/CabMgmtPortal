package com.pp.cabmgmtportal.service;

import com.pp.cabmgmtportal.dto.BookingResponseDTO;
import com.pp.cabmgmtportal.dto.CabDTO;
import com.pp.cabmgmtportal.dto.RegisterCabDTO;

import java.util.List;

public interface ICabService {
    List<CabDTO> getAllCabStatus();
    BookingResponseDTO bookCab(String cityName);
    String completeTrip(String cabId);
    String updateLocation(RegisterCabDTO dto);
}
