package fr.maif.bookstore_api.service;

import fr.maif.bookstore_api.entity.Book;
import fr.maif.bookstore_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return Optional.of(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé")));
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> OptionalBook = bookRepository.findById(id);
        if (OptionalBook.isPresent()) {
            Book currentbook = OptionalBook.get();
            currentbook.setTitle(book.getTitle());
            currentbook.setPrice(book.getPrice());
            currentbook.setPublicationDate(book.getPublicationDate());
            currentbook.setStock(book.getStock());
            return bookRepository.save(currentbook);
        }
        throw new RuntimeException("Livre non trouvé");
    }

    public void deleteBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        }
        throw new RuntimeException("Livre non trouvé");

    }
}
