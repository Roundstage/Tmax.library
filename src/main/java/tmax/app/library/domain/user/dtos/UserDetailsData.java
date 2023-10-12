package tmax.app.library.domain.user.dtos;

import tmax.app.library.domain.reserve.Reserve;
import tmax.app.library.domain.user.User;
import tmax.app.library.domain.user.UserLevelEnum;

import java.util.Set;

public record UserDetailsData(Long id, String name, String email, UserLevelEnum level) {
    public UserDetailsData(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getLevel());
    }

}
