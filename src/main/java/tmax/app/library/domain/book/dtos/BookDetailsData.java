package tmax.app.library.domain.book.dtos;

import tmax.app.library.domain.book.Book;
import tmax.app.library.domain.user.UserLevelEnum;

public record BookDetailsData(Long id, String description, String ean, UserLevelEnum level) {
    public BookDetailsData(Book book){
        this(book.getId(), book.getDescription(), book.getEan(), book.getLevel());
    }
}
