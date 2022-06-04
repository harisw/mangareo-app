package com.harisw.mangareo.mangaservice.repository;

import com.harisw.mangareo.mangaservice.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Genre findBySlug(String slug);
}
