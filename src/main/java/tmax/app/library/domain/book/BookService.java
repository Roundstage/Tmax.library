package tmax.app.library.domain.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import tmax.app.library.domain.book.dtos.BookDetailsData;
import tmax.app.library.domain.book.dtos.BookListData;
import tmax.app.library.domain.book.dtos.BookRegisterData;
import tmax.app.library.domain.book.dtos.BookUpdateData;


@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public ResponseEntity<BookDetailsData> getBookDetails(Long id){
        var book = repository.getReferenceById(id);
        return ResponseEntity.ok(new BookDetailsData(book));
    }
    public ResponseEntity<Page<BookListData>> getAllBooks(Pageable paging){
        return ResponseEntity.ok(repository.findAll(paging).map(BookListData::new));
    }
    public ResponseEntity<BookDetailsData> createBook(BookRegisterData data, UriComponentsBuilder uriBuilder){
        var book = new Book(data);
        repository.save(book);
        var uri = uriBuilder.path("/book/{id}").buildAndExpand(book.getId()).toUri();
        return ResponseEntity.created(uri).body(new BookDetailsData(book));
    }
    public ResponseEntity<BookDetailsData> bookUpdate(BookUpdateData data){
        var book = repository.getReferenceById(data.id());
        return ResponseEntity.ok(new BookDetailsData(book.updateInfo(data)));

    }
    public ResponseEntity bookDelete(Long id){
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
