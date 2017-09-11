package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dto.SampleDto;
import dto.UserDto;
import entity.Sample;
import entity.User;
import service.AbstractDBAccessService;
import service.SampleService;

@Component
public class SampleServiceImpl extends AbstractDBAccessService implements SampleService{


	@Override
	public void save(List<SampleDto> sampleDtoList) {

		super.beginTransaction();
		Sample sample;
		try {
			for(SampleDto sampleDto :sampleDtoList) {

				sample = new Sample();

				sample.setId(sampleDto.getId());
				sample.setSampleString(sampleDto.getSampleString());
				sample.setSampleInteger(sampleDto.getSampleInteger());
				sample.setSampleDate(sampleDto.getSampleDate());

				super.save(sample);

			}
			super.commit();
		}finally {

			super.close();
		}

	}

	@Override
	public List<SampleDto> getSampleDtoList() {
		@SuppressWarnings({ "unchecked" })
		List<Sample> sampleList = (List<Sample>)super.getCriteria(Sample.class).list();
		SampleDto sampleDto;
		List<SampleDto> sampleDtoList = new ArrayList<SampleDto>();
		for(Sample sample :sampleList) {

			sampleDto = new SampleDto();

			sampleDto.setId(sample.getId());
			sampleDto.setSampleString(sample.getSampleString());
			sampleDto.setSampleInteger(sample.getSampleInteger());
			sampleDto.setSampleDate(sample.getSampleDate());

			sampleDtoList.add(sampleDto);

		}
		return sampleDtoList;
	}

	@Override
	public void registUser(UserDto userDto) {
		super.beginTransaction();
		User user = new User();
		try {
			user.setName(userDto.getName());
			user.setPassword(userDto.getPassword());

			super.save(user);
			super.commit();
		}finally {

			super.close();
		}
	}

}
