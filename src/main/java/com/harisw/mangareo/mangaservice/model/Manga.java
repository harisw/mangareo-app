package com.harisw.mangareo.mangaservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "t_mangas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Manga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "id")
    private Genre genre;
}