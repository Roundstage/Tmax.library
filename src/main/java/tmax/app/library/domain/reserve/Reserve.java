package tmax.app.library.domain.reserve;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tmax.app.library.domain.book.Book;
import tmax.app.library.domain.reserve.dtos.ReserveRegisterData;
import tmax.app.library.domain.reserve.dtos.ReserveUpdateData;
import tmax.app.library.domain.user.User;
import tmax.app.library.domain.user.dtos.UserRegisterData;
import tmax.app.library.domain.user.dtos.UserUpdateData;

import java.util.Date;
import java.util.Set;

@Table(name = "reserves")
@Entity(name = "Reserve")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Reserve {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;
    private Date startDate;
    private Date endDate;

    public Reserve(ReserveRegisterData data){
        this.user = data.user();
        this.book = data.book();
        this.startDate = data.startDate();
        this.endDate = data.endDate();
    }
    public Reserve(ReserveUpdateData data) {
        if(data.startDate() != null) this.startDate = data.startDate();
        if(data.endDate() != null) this.endDate = data.endDate();
    }

    public Reserve updateInfo(ReserveUpdateData data) {
        if(data.startDate() != null) this.startDate = data.startDate();
        if(data.endDate() != null) this.endDate = data.endDate();
        return new Reserve(data);
    }
}
