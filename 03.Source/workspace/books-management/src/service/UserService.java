package service;

import java.util.List;

import dto.UserDto;
import dto.UserListDto;

public interface UserService  {


	public List<UserDto> getUserList(UserListDto userList) ;

	public void registUser(UserDto userDto) ;


}
