package com.pp.cabmgmtportal.repository;

import com.pp.cabmgmtportal.entity.Cab;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CabRepository extends JpaRepository<Cab,String> {


    Cab findFirstByCityNameAndCabStateOrderByLastUpdateTime(String cityName,String cabState);
}
