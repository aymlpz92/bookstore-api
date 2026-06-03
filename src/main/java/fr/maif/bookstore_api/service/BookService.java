package fr.maif.bookstore_api.service;

import fr.maif.bookstore_api.dto.BookRequestDTO;
import fr.maif.bookstore_api.dto.BookResponseDTO;
import fr.maif.bookstore_api.entity.Book;
import fr.maif.bookstore_api.mapper.BookMapper;
import fr.maif.bookstore_api.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private  final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookRequestDTO createBook(BookRequestDTO bookRequestDTO) {
        Book book = bookMapper.bookRequestDTOtoBookEntity(bookRequestDTO);
        bookRepository.save(book);
        return bookMapper.bookEntityToBookRequestDTO(book);
    }

    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::bookEntityToBookResponseDTO)
                .toList();
    }

    public Optional<BookResponseDTO> getBookById(Long id) {
        return Optional.of(bookMapper.bookEntityToBookResponseDTO(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Livre non trouvé"))));
    }

    public BookRequestDTO updateBook(Long id, BookRequestDTO bookRequestDTO) {
        Optional<Book> OptionalBook = bookRepository.findById(id);
        if (OptionalBook.isPresent()) {
            Book currentbook = OptionalBook.get();
            currentbook.setTitle(bookRequestDTO.getTitle());
            currentbook.setPrice(bookRequestDTO.getPrice());
            currentbook.setPublicationDate(bookRequestDTO.getPublicationDate());
            currentbook.setStock(bookRequestDTO.getStock());
            bookRepository.save(currentbook);
            return bookMapper.bookEntityToBookRequestDTO(currentbook);
        }
        throw new RuntimeException("Livre non trouvé");
    }

    public void deleteBookById(Long id) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            bookRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Livre non trouvé");
        }

    }
}
