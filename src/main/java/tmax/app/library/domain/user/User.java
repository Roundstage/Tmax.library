package tmax.app.library.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import tmax.app.library.domain.reserve.Reserve;
import tmax.app.library.domain.user.dtos.UserRegisterData;
import tmax.app.library.domain.user.dtos.UserUpdateData;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserLevelEnum level;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    public User(UserRegisterData data){
        this.name = data.name();
        this.email = data.email();
        this.password = data.password();
        this.level = data.level();
    }
    public User(UserUpdateData data) {
        if(data.name() != null) this.name = data.name();
        if(data.level() != null) this.level = data.level();
    }

    public User updateInfo(UserUpdateData data) {
        if(data.name() != null) this.name = data.name();
        if(data.level() != null) this.level = data.level();
        return new User(data);
    }
}
