package com.harisw.mangareo.mangaservice.controller;

import com.harisw.mangareo.mangaservice.dto.GenreResponse;
import com.harisw.mangareo.mangaservice.dto.MangaResponse;
import com.harisw.mangareo.mangaservice.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/genre")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GenreResponse> getAllGenres() {
        return genreService.getAllGenres();
    }

    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public Set<MangaResponse> getMangasByGenre(@PathVariable("slug") String slug) {
        return genreService.getMangaByGenre(slug);
    }
}
