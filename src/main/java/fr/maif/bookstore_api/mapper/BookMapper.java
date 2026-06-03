package fr.maif.bookstore_api.mapper;

import fr.maif.bookstore_api.dto.BookRequestDTO;
import fr.maif.bookstore_api.dto.BookResponseDTO;
import fr.maif.bookstore_api.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book bookRequestDTOtoBookEntity(BookRequestDTO bookRequestDTO) {
        Book book = new Book();
        book.setTitle(bookRequestDTO.getTitle());
        book.setIsbn(bookRequestDTO.getIsbn());
        book.setPrice(bookRequestDTO.getPrice());
        book.setPublicationDate(bookRequestDTO.getPublicationDate());
        book.setStock(bookRequestDTO.getStock());
        return book;
    }

    public BookRequestDTO bookEntityToBookRequestDTO(Book book) {
        BookRequestDTO bookRequestDTO = new BookRequestDTO();
        bookRequestDTO.setTitle(book.getTitle());
        bookRequestDTO.setIsbn(book.getIsbn());
        bookRequestDTO.setPrice(book.getPrice());
        bookRequestDTO.setPublicationDate(book.getPublicationDate());
        bookRequestDTO.setStock(book.getStock());
        return bookRequestDTO;
    }

    public BookResponseDTO bookEntityToBookResponseDTO(Book book) {
        BookResponseDTO bookResponseDTO = new BookResponseDTO();
        bookResponseDTO.setId(book.getId());
        bookResponseDTO.setTitle(book.getTitle());
        bookResponseDTO.setIsbn(book.getIsbn());
        bookResponseDTO.setPrice(book.getPrice());
        bookResponseDTO.setPublicationDate(book.getPublicationDate());
        bookResponseDTO.setStock(book.getStock());
        bookResponseDTO.setCreatedAt(book.getCreatedAt());
        bookResponseDTO.setUpdatedAt(book.getUpdatedAt());
        return bookResponseDTO;
    }
}
