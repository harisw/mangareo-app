package com.harisw.mangareo.mangaservice.repository;

import com.harisw.mangareo.mangaservice.model.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MangaRepository extends JpaRepository<Manga, Integer> {
    Manga findBySlug(String slug);
    @Query(value = "select * from t_mangas m order by m.last_update desc LIMIT 30", nativeQuery = true)
    List<Manga> findLastUpdated();
    @Query(value = "select * from t_mangas m order by m.view_count desc LIMIT 30", nativeQuery = true)
    List<Manga> findMostViewed();
}
