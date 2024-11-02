package com.ar.mikellbobadilla.app.genre;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record GenreRequest(
        @NotBlank
        @Length(min = 4, max = 50)
        String name
) {
}
