package fr.maif.bookstore_api.dto;

import lombok.Data;

import java.time.Instant;
import java.util.Date;

@Data
public class BookResponseDTO {
    private Long id;
    private String title;
    private String isbn;
    private Double price;
    private Date publicationDate;
    private int stock;
    private Instant createdAt;
    private Instant updatedAt;
}
