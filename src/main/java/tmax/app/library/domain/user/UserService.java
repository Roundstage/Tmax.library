package tmax.app.library.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import tmax.app.library.domain.user.dtos.UserDetailsData;
import tmax.app.library.domain.user.dtos.UserListData;
import tmax.app.library.domain.user.dtos.UserRegisterData;
import tmax.app.library.domain.user.dtos.UserUpdateData;

import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public ResponseEntity<UserDetailsData> getUserDetails(Long id){
        var user = repository.getReferenceById(id);
        return ResponseEntity.ok(new UserDetailsData(user));
    }
    public ResponseEntity<Page<UserListData>> getAllUsers(Pageable paging){
        return ResponseEntity.ok(repository.findAll(paging).map(UserListData::new));
    }
    public ResponseEntity<UserDetailsData> createUser(UserRegisterData data, UriComponentsBuilder uriBuilder){
        var user = new User(data);
        repository.save(user);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailsData(user));
    }
    public ResponseEntity<UserDetailsData> userUpdate(UserUpdateData data){
        var user = repository.getReferenceById(data.id());
        return ResponseEntity.ok(new UserDetailsData(user.updateInfo(data)));

    }
    public ResponseEntity userDelete(Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
