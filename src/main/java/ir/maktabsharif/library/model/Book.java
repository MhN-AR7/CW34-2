package ir.maktabsharif.library.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Book {
    private Long id;

    private String title;

    private String author;

    private Integer publishedYear;
}
