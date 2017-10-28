package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dto.UserDto;
import dto.UserSearchDto;
import entity.User;
import service.AbstractDBAccessService;
import service.UserService;

@Component
public class UserServiceImpl extends AbstractDBAccessService implements UserService{

	@Override
	public void registUser(UserDto userDto) {
		super.beginTransaction();
		try {
			super.save(userDto.createUserEntity());
			super.commit();
		}finally {

			super.close();
		}

	}

	@Override
	public List<UserDto> getUserList(UserSearchDto userList) {

		Criteria criteria = super.getCriteria(User.class);

		if(userList != null) {
			criteria.add(Restrictions.like("name", userList.getUserCriteria(), MatchMode.ANYWHERE));
		}
		@SuppressWarnings("unchecked")
		List<User> results = (List<User>)criteria.list();
		UserDto userDto;
		List<UserDto> userDtoList = new ArrayList<UserDto>();
		for(User user :results) {

			userDto = new UserDto(user);
			userDtoList.add(userDto);

		}
		return userDtoList;
	}

	@Override
	public List<UserDto> getUserList() {
		// TODO 自動生成されたメソッド・スタブ
		return this.getUserList(null);
	}


}
