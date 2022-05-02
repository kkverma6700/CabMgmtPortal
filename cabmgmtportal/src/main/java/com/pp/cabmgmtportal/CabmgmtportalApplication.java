package com.pp.cabmgmtportal;

import com.pp.cabmgmtportal.Util.CabMgmtUtil;
import com.pp.cabmgmtportal.repository.CabRepository;
import com.pp.cabmgmtportal.repository.CityRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CabmgmtportalApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(CabmgmtportalApplication.class, args);
		context.getBean(CityRepository.class).saveAll(CabMgmtUtil.getCities());
		context.getBean(CabRepository.class).saveAll(CabMgmtUtil.getCabs());


	}

}
