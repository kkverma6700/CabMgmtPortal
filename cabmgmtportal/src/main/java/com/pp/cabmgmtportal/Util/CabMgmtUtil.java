package com.pp.cabmgmtportal.Util;

import com.pp.cabmgmtportal.entity.Cab;
import com.pp.cabmgmtportal.entity.City;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CabMgmtUtil {

    public static List<Cab> getCabs(){
        List<Cab> cabList=new ArrayList<>();
        cabList.add(Cab.builder().cabId("MH01JK5656").cityName("MUMBAI").cabState("IDLE").lastUpdateTime(LocalDateTime.now()).build());
        cabList.add(Cab.builder().cabId("MH01JK7878").cityName("MUMBAI").cabState("IDLE").lastUpdateTime(LocalDateTime.now()).build());
        cabList.add(Cab.builder().cabId("TN01JK1212").cityName("CHENNAI").cabState("IDLE").lastUpdateTime(LocalDateTime.now()).build());
        cabList.add(Cab.builder().cabId("TN01JK7878").cityName("CHENNAI").cabState("IDLE").lastUpdateTime(LocalDateTime.now()).build());

        return cabList;
    }

    public static List<City> getCities(){
        List<City> cities=new ArrayList<>();
        cities.add(City.builder().cityName("MUMBAI").build());
        cities.add(City.builder().cityName("CHENNAI").build());
        return cities;

    }
}
