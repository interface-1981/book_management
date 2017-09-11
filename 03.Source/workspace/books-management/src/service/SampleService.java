package service;

import java.util.List;

import dto.SampleDto;
import dto.UserDto;

public interface SampleService  {


	public void save(List<SampleDto> sampleDtoList);

	public List<SampleDto> getSampleDtoList() ;

	public void registUser(UserDto userDto) ;


}
