package tmax.app.library.domain.reserve.dtos;

import tmax.app.library.domain.book.Book;
import tmax.app.library.domain.reserve.Reserve;
import tmax.app.library.domain.user.User;

import java.util.Date;

public record ReserveListData(Long id, User user, Book book, Date startDate, Date endDate) {
    public ReserveListData(Reserve reserve){
        this(reserve.getId(), reserve.getUser(), reserve.getBook(), reserve.getStartDate(), reserve.getEndDate());
    }
}

