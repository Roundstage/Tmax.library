package tmax.app.library.domain.reserve.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import tmax.app.library.domain.book.Book;
import tmax.app.library.domain.reserve.Reserve;
import tmax.app.library.domain.user.User;

import java.util.Date;

public record ReserveRegisterData(
        @NotNull
        User user,
        @NotNull
        Book book,
        @NotNull
        Date startDate,
        @NotNull
        Date endDate
) {
}
