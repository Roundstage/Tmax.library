package tmax.app.library.domain.book;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmax.app.library.domain.book.dtos.BookRegisterData;
import tmax.app.library.domain.book.dtos.BookUpdateData;
import tmax.app.library.domain.user.UserLevelEnum;


import java.util.Set;

@Table(name = "books")
@Entity(name = "Book")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String ean;
    private UserLevelEnum level;

    public Book (BookRegisterData data){
        this.description = data.description();
        this.ean = data.ean();
        this.level = data.level();
    }
    public Book(BookUpdateData data) {
        if(data.description() != null) this.description = data.description();
        if(data.ean() != null) this.ean = data.ean();
        if(data.level() != null) this.level = data.level();
    }

    public Book updateInfo(BookUpdateData data) {
        if(data.description() != null) this.description = data.description();
        if(data.ean() != null) this.ean = data.ean();
        if(data.level() != null) this.level = data.level();
        return new Book(data);
    }

}
