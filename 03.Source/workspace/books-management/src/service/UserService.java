package service;

import java.util.List;

import dto.UserDto;
import dto.UserSearchDto;

public interface UserService  {


	public List<UserDto> getUserList(UserSearchDto userList) ;
	public List<UserDto> getUserList() ;

	public void registUser(UserDto userDto) ;


}
