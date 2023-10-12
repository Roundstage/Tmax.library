package tmax.app.library.domain.reserve.dtos;

import jakarta.validation.constraints.NotNull;
import tmax.app.library.domain.book.Book;
import tmax.app.library.domain.user.User;

import java.util.Date;

public record ReserveUpdateData(
        @NotNull
        Long id,
        Date startDate,
        Date endDate
) {
}
