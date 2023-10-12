package tmax.app.library.domain.user.dtos;

import tmax.app.library.domain.user.User;
import tmax.app.library.domain.user.UserLevelEnum;

public record UserListData(Long id, String name, String email, UserLevelEnum level) {
    public UserListData(User user){
        this(user.getId(), user.getName(), user.getEmail(), user.getLevel());
    }
}
