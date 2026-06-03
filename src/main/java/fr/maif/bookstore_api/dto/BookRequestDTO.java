package fr.maif.bookstore_api.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class BookRequestDTO {

    @NotBlank(message = "Ce champ ne peut être vide")
    private String title;

    @Pattern(regexp = "^(?:ISBN(?:-13)?:? )?(?<gs1>\\d{3})(?:(?<number>\\d{9})|(?=[\\d -]{14}$)[ -](?<registrationGroup>\\d{1,5})[ -](?<registrant>\\d{1,7})[ -](?<publication>\\d{1,6})[ -])(?<checkDigit>\\d)$")
    private String isbn;

    @NotBlank
    @Positive(message = "Ce champ doit être supérieur à zéro")
    private Double price;

    @NotBlank(message = "Ce champ ne peut être vide")
    private Date publicationDate;

    @NotBlank
    @Min(value = 0, message = "Ce champ doit être supérieur ou égal à zéro")
    private int stock;
}
