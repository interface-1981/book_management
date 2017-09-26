package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dto.UserDto;
import dto.UserListDto;
import entity.User;
import service.AbstractDBAccessService;
import service.UserService;

@Component
public class UserServiceImpl extends AbstractDBAccessService implements UserService{

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

	@Override
	public List<UserDto> getUserList(UserListDto userList) {

		Criteria criteria = super.getCriteria(User.class);

		criteria.add(Restrictions.like("name", userList.getUserCriteria(), MatchMode.ANYWHERE));

		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)criteria.list();
		UserDto userDto;
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for(User user :results) {

			userDto = new UserDto();

			userDto.setId(user.getId());
			userDto.setName(user.getName());

			userDtoList.add(userDto);

		}
		return userDtoList;
	}


}
