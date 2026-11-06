package ir.maktabsharif.library.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Book {
    private Long id;

    private String title;

    private String author;

    private Integer publishedYear;
}
