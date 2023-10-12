package tmax.app.library.domain.book.dtos;

import jakarta.validation.constraints.NotNull;
import tmax.app.library.domain.user.UserLevelEnum;

public record BookUpdateData(
        @NotNull
        Long id,
        String description,
        String ean,
        UserLevelEnum level
) {
}
