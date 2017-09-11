package service.test;


import java.util.List;

import org.springframework.stereotype.Component;

import dto.SampleDto;
import dto.UserDto;
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

	@Override
	public void registUser(UserDto userDto) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
