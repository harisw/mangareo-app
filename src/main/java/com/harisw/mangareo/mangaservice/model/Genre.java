package com.harisw.mangareo.mangaservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "t_genres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String slug;
    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Manga> mangas;
}