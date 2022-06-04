package com.harisw.mangareo.mangaservice.service;

import com.harisw.mangareo.mangaservice.dto.MangaResponse;
import com.harisw.mangareo.mangaservice.model.Genre;
import com.harisw.mangareo.mangaservice.model.Manga;
import com.harisw.mangareo.mangaservice.repository.MangaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MangaService {
    private final MangaRepository mangarepository;
    public MangaResponse get(String slug) {
        Manga manga = mangarepository.findBySlug(slug);
        log.info("Slug: {}", slug);
        log.info("Manga: {} ", manga.getTitle());
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
                .genre(manga.getGenre().getClass().getName()).build();
    }

    public List<MangaResponse> getLastUpdatedMangas() {
        List<Manga> mangas = mangarepository.findLastUpdated();
        return mangas.stream().map(this::mapToMangaResponse).toList();
    }

    public List<MangaResponse> getMostViewedMangas() {
        List<Manga> mangas = mangarepository.findMostViewed();
        return mangas.stream().map(this::mapToMangaResponse).toList();
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
