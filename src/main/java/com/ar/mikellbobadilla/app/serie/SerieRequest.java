package com.ar.mikellbobadilla.app.serie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record SerieRequest(
        @NotBlank
        String title,
        String description,
        @Size(min = 1)
        List<String> genres
) {
}
