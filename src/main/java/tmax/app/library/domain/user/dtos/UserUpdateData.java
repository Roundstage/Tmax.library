package tmax.app.library.domain.user.dtos;

import jakarta.validation.constraints.NotNull;
import tmax.app.library.domain.user.UserLevelEnum;

public record UserUpdateData(
        @NotNull
        Long id,
        String name,
        UserLevelEnum level
) {

}
