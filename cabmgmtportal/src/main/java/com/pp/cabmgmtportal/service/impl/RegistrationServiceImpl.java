package com.pp.cabmgmtportal.service.impl;

import com.pp.cabmgmtportal.common.CabMgmtConstants;
import com.pp.cabmgmtportal.dto.RegisterCabDTO;
import com.pp.cabmgmtportal.entity.Cab;
import com.pp.cabmgmtportal.mapper.CabMapper;
import com.pp.cabmgmtportal.repository.CabRepository;
import com.pp.cabmgmtportal.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements IRegistrationService {

    private CabRepository cabRepository;

    public String register(List<RegisterCabDTO> cabs){

        List<Cab> cabList=cabs.stream().map(CabMapper::toEntity).collect(Collectors.toList());

        cabRepository.saveAll(cabList);
        return CabMgmtConstants.REGISTRATION_SUCCESS;


    }

    @Autowired
    public void setCabRepository(CabRepository cabRepository) {
        this.cabRepository = cabRepository;
    }
}
