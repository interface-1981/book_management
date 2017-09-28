package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import dto.BookDto;
import dto.OwnedBooksDto;
import dto.OwnedBooksListDto;
import dto.UserDto;
import entity.OwnedBooks;
import service.AbstractDBAccessService;
import service.OwnedBooksService;

@Component
public class OwnedBooksServiceImpl extends AbstractDBAccessService implements OwnedBooksService{



	@Override
	public void registOwnedBooks(OwnedBooksDto ownedBooksDto) {
		super.beginTransaction();
		OwnedBooks ownedBooks = new OwnedBooks();
		try {
			ownedBooks.setBookId(ownedBooksDto.getBookId());
			ownedBooks.setUserId(ownedBooksDto.getUserId());

			super.save(ownedBooks);
			super.commit();
		}finally {

			super.close();
		}
	}

	@Override
	public List<OwnedBooksDto> getOwnedBooksList(OwnedBooksListDto ownedBooksListDto) {
		Criteria criteria = super.getCriteria(OwnedBooks.class);

		if(ownedBooksListDto != null) {
			if (!ownedBooksListDto.getUserCriteria().trim().equals("")) {
				criteria.createCriteria("user")
				.add(Restrictions.like("name", ownedBooksListDto.getUserCriteria(), MatchMode.ANYWHERE));
			}

		}
		@SuppressWarnings("unchecked")
		List<OwnedBooks> results = (List<OwnedBooks>)criteria.list();
		OwnedBooksDto ownedBooksDto;
		List<OwnedBooksDto> ownedBooksList = new ArrayList<OwnedBooksDto>();
		for(OwnedBooks ownedBooks :results) {

			ownedBooksDto = new OwnedBooksDto();

			ownedBooksDto.setUserId(ownedBooks.getUserId());
			ownedBooksDto.setBookId(ownedBooks.getBookId());
			ownedBooksDto.setBook(new BookDto(ownedBooks.getBook()));
			ownedBooksDto.setUser(new UserDto(ownedBooks.getUser()));

			ownedBooksList.add(ownedBooksDto);

		}
		return ownedBooksList;
	}

	@Override
	public List<OwnedBooksDto> getOwnedBooksList() {
		// TODO 自動生成されたメソッド・スタブ
		return this.getOwnedBooksList(null);
	}


}
