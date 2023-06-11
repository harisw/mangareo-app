package com.harisw.mangareo.mangaservice.dto;

import com.harisw.mangareo.mangaservice.model.Manga;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenreResponse {
    private String slug;
    private String name;
    private Set<Manga> mangas;
}
