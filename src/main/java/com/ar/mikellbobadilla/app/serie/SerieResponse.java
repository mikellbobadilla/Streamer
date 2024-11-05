package com.ar.mikellbobadilla.app.serie;

import com.ar.mikellbobadilla.app.genre.Genre;

import java.util.List;

public record SerieResponse(
        Long id,
        String title,
        String description,
        String poster,
        List<Genre> genres
) {
}
