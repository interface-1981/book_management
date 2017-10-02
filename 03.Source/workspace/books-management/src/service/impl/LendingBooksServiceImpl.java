package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dto.LendingBooksDto;
import dto.LendingBooksSearchDto;
import entity.LendingBooks;
import service.AbstractDBAccessService;
import service.LendingBooksService;

@Component
public class LendingBooksServiceImpl extends AbstractDBAccessService implements LendingBooksService{


	@Override
	public List<LendingBooksDto> getLendingBooksList(LendingBooksSearchDto lendingBooksSearchDto) {

		Criteria criteria = super.getCriteria(LendingBooks.class);
		if(lendingBooksSearchDto != null) {
			if (!lendingBooksSearchDto.getLendingDestUserCriteria().trim().equals("")) {
				criteria.createCriteria("user", "lending_dest_user")
				.add(Restrictions.like("lending_dest_user.name", lendingBooksSearchDto.getLendingDestUserCriteria(), MatchMode.ANYWHERE));

			}
			if (!lendingBooksSearchDto.getLendingSrcUserCriteria().trim().equals("")) {
				criteria.createCriteria("ownedBooks").createCriteria("user", "lending_src_user")
				.add(Restrictions.like("lending_src_user.name", lendingBooksSearchDto.getLendingSrcUserCriteria(), MatchMode.ANYWHERE));

			}
		}

		@SuppressWarnings("unchecked")
		List<LendingBooks> results = (List<LendingBooks>)criteria.list();
		LendingBooksDto lendingBooksDto;
		List<LendingBooksDto> lendingBooksList = new ArrayList<LendingBooksDto>();
		for(LendingBooks lendingBooks :results) {

			lendingBooksDto = new LendingBooksDto(lendingBooks);
			lendingBooksList.add(lendingBooksDto);

		}
		return lendingBooksList;

	}

	@Override
	public void registLendingBooks(LendingBooksDto lendingBooksDto) {
		super.beginTransaction();
		LendingBooks lendingBooks = new LendingBooks();
		try {
			lendingBooks.setOwnedBooksId(lendingBooksDto.getOwnedBooksId());
			lendingBooks.setUserId(lendingBooksDto.getUserId());
			lendingBooks.setStatus(lendingBooksDto.getStatus());

			super.save(lendingBooks);
			super.commit();
		}finally {

			super.close();
		}
	}

	@Override
	public List<LendingBooksDto> getLendingBooksList() {
		// TODO 自動生成されたメソッド・スタブ
		return getLendingBooksList(null);
	}


}
