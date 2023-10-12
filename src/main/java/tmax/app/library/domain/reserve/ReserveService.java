package tmax.app.library.domain.reserve;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import tmax.app.library.domain.reserve.dtos.ReserveDetailsData;
import tmax.app.library.domain.reserve.dtos.ReserveListData;
import tmax.app.library.domain.reserve.dtos.ReserveRegisterData;
import tmax.app.library.domain.reserve.dtos.ReserveUpdateData;

@Service
public class ReserveService {
    @Autowired
    private ReserveRepository repository;
    public ResponseEntity<Page<ReserveListData>> getAllReserves(Pageable paging){
        return ResponseEntity.ok(repository.findAll(paging).map(ReserveListData::new));
    }
    public ResponseEntity<ReserveDetailsData> createReserve(ReserveRegisterData data, UriComponentsBuilder uriBuilder){
        var reserve = new Reserve(data);
        repository.save(reserve);
        var uri = uriBuilder.path("/book/{id}").buildAndExpand(reserve.getId()).toUri();
        return ResponseEntity.created(uri).body(new ReserveDetailsData(reserve));

    }
    public ResponseEntity<ReserveDetailsData> reserveUpdate(ReserveUpdateData data){
        var reserve = repository.getReferenceById(data.id());
        return ResponseEntity.ok(new ReserveDetailsData(reserve.updateInfo(data)));

    }
    public ResponseEntity reserveDelete(Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
