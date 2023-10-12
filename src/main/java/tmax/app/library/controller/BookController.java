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
import tmax.app.library.domain.book.BookRepository;
import tmax.app.library.domain.book.BookService;
import tmax.app.library.domain.book.dtos.BookDetailsData;
import tmax.app.library.domain.book.dtos.BookListData;
import tmax.app.library.domain.book.dtos.BookRegisterData;
import tmax.app.library.domain.book.dtos.BookUpdateData;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsData> details(@PathVariable Long id){
        return service.getBookDetails(id);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<BookDetailsData> register(@RequestBody @Valid BookRegisterData data, UriComponentsBuilder uriBuilder) {
        return service.createBook(data, uriBuilder);
    }
    @GetMapping
    public ResponseEntity<Page<BookListData>> list(@PageableDefault(size = 10, sort = {"description"}) Pageable paging) {
        return service.getAllBooks(paging);
    }
    @PutMapping
    @Transactional
    public ResponseEntity<BookDetailsData> update(@RequestBody @Valid BookUpdateData data){
        return service.bookUpdate(data);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){
        return service.bookDelete(id);
    }
}
