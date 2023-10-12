package tmax.app.library.domain.book.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tmax.app.library.domain.user.UserLevelEnum;

public record BookRegisterData(
        @NotBlank
        String description,
        @NotBlank
        String ean,
        @NotNull
        UserLevelEnum level
) {
}
