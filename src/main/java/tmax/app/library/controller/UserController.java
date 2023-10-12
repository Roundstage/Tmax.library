package tmax.app.library.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import tmax.app.library.domain.user.UserRepository;
import tmax.app.library.domain.user.UserService;
import tmax.app.library.domain.user.dtos.UserDetailsData;
import tmax.app.library.domain.user.dtos.UserListData;
import tmax.app.library.domain.user.dtos.UserRegisterData;
import tmax.app.library.domain.user.dtos.UserUpdateData;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;



    @GetMapping("/{id}")
    public ResponseEntity<UserDetailsData> details(@PathVariable Long id){
        return service.getUserDetails(id);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<UserDetailsData> register(@RequestBody @Valid UserRegisterData data, UriComponentsBuilder uriBuilder) {
        return service.createUser(data, uriBuilder);
    }
    @GetMapping
    public ResponseEntity<Page<UserListData>> list(@PageableDefault(size = 10, sort = {"name"}) Pageable paging) {
        return service.getAllUsers(paging);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<UserDetailsData> update(@RequestBody @Valid UserUpdateData data){
        return service.userUpdate(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        return service.userDelete(id);
    }
}
