package com.harisw.mangareo.mangaservice.controller;

import com.harisw.mangareo.mangaservice.dto.MangaResponse;
import com.harisw.mangareo.mangaservice.service.MangaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manga")
@RequiredArgsConstructor
public class MangaController {
    private final MangaService mangaService;

    @GetMapping("/{slug}")
    @ResponseStatus(HttpStatus.OK)
    public MangaResponse getManga(@PathVariable("slug") String slug){
        return mangaService.get(slug);
    }
    @GetMapping("/last-updated")
    @ResponseStatus(HttpStatus.OK)
    public List<MangaResponse> getLastUpdatedMangas(){
        return mangaService.getLastUpdatedMangas();
    }

    @GetMapping("/most-viewed")
    @ResponseStatus(HttpStatus.OK)
    public List<MangaResponse> getMostViewedMangas(){
        return mangaService.getMostViewedMangas();
    }
}