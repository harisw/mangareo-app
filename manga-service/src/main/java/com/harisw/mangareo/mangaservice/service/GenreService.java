package com.harisw.mangareo.mangaservice.service;

import com.harisw.mangareo.mangaservice.dto.GenreResponse;
import com.harisw.mangareo.mangaservice.dto.MangaResponse;
import com.harisw.mangareo.mangaservice.model.Genre;
import com.harisw.mangareo.mangaservice.model.Manga;
import com.harisw.mangareo.mangaservice.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public List<GenreResponse> getAllGenres() {
        List<Genre> genres = genreRepository.findAll();
        return genres.stream().map(this::mapToGenreResponse).toList();
    }

    public Set<MangaResponse> getMangaByGenre(String slug) {
        Genre genre = genreRepository.findBySlug(slug);
        Set<Manga> mangas = genre.getMangas();
        return mangas.stream().map(this::mapToMangaResponse).collect(Collectors.toSet());
    }

    private GenreResponse mapToGenreResponse(Genre genre) {
        return GenreResponse.builder()
                .name(genre.getName())
                .slug(genre.getSlug()).build();
    }
    private MangaResponse mapToMangaResponse(Manga manga){
        return MangaResponse.builder()
                .title(manga.getTitle())
                .description(manga.getDescription())
                .cover_img(manga.getCover_img())
                .release_date(manga.getRelease_date())
                .is_finished(manga.getIs_finished())
                .chapter(manga.getChapter())
                .avg_rating(manga.getAvg_rating())
                .view_count(manga.getView_count())
                .last_update(manga.getLast_update())
                .writer(manga.getWriter())
                .slug(manga.getSlug())
                .genre(manga.getGenre().getName()).build();
    }
}
