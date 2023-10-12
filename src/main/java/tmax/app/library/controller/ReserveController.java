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
import tmax.app.library.domain.reserve.ReserveService;
import tmax.app.library.domain.reserve.dtos.ReserveDetailsData;
import tmax.app.library.domain.reserve.dtos.ReserveListData;
import tmax.app.library.domain.reserve.dtos.ReserveRegisterData;
import tmax.app.library.domain.reserve.dtos.ReserveUpdateData;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService service;

    @PostMapping
    @Transactional
    public ResponseEntity<ReserveDetailsData> register(@RequestBody @Valid ReserveRegisterData data, UriComponentsBuilder uriBuilder) {
        return service.createReserve(data, uriBuilder);
    }
    @GetMapping
    public ResponseEntity<Page<ReserveListData>> list(@PageableDefault(size = 10, sort = {"description"}) Pageable paging) {
        return service.getAllReserves(paging);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<ReserveDetailsData> update(@RequestBody @Valid ReserveUpdateData data){
        return service.reserveUpdate(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        return service.reserveDelete(id);
    }
}
