package service.test;


import java.util.List;

import org.springframework.stereotype.Component;

import dto.SampleDto;
import service.SampleService;

@Component
public class SampleServiceImpl implements SampleService{


	@Override
	public void save(List<SampleDto> sampleDtoList) {



	}

	@Override
	public List<SampleDto> getSampleDtoList() {

		return null;
	}


}
