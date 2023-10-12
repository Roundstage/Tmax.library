package tmax.app.library.domain.user.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import tmax.app.library.domain.user.UserLevelEnum;

public record UserRegisterData(
        @NotBlank @Email
        String email,
        @NotBlank
        String name,
        @NotBlank
        String password,
        @NotNull
        UserLevelEnum level
) {

}
