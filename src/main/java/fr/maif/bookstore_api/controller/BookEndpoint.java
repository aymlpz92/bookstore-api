package fr.maif.bookstore_api.controller;

import fr.maif.bookstore_api.dto.BookRequestDTO;
import fr.maif.bookstore_api.dto.BookResponseDTO;
import fr.maif.bookstore_api.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookEndpoint {

    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookRequestDTO> createBook(@RequestBody BookRequestDTO book) {
        return new ResponseEntity<>(bookService.createBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable Long id) {
        Optional<BookResponseDTO> OptionalBook = bookService.getBookById(id);
        return OptionalBook.map(book -> new ResponseEntity<>(book, HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookRequestDTO> updateBook(@PathVariable Long id, @RequestBody BookRequestDTO book) {
        Optional<BookResponseDTO> OptionalBook = bookService.getBookById(id);
        return OptionalBook.map(updateBook -> new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookResponseDTO> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
