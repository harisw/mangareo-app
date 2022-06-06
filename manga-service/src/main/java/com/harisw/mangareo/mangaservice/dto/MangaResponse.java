package com.harisw.mangareo.mangaservice.dto;

import com.harisw.mangareo.mangaservice.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MangaResponse {
    private String title;
    private String description;
    private String cover_img;
    private Timestamp release_date;
    private Boolean is_finished;
    private Integer chapter;
    private Float avg_rating;
    private Integer view_count;
    private Timestamp last_update;
    private String writer;
    private String slug;
    private String genre;
}