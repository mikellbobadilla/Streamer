package com.ar.mikellbobadilla.app.genre;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService service;

    @GetMapping
    @ResponseStatus(OK)
    List<Genre> getAll() {
        return service.getAllGenres();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    Genre postGenre(@Valid @RequestBody GenreRequest request) {
        return service.createGenre(request);
    }

    @PutMapping("/{genreId}")
    @ResponseStatus(OK)
    Genre putGenre(@PathVariable Long genreId, @Valid @RequestBody GenreRequest request) {
        return service.updateGenre(genreId, request);
    }

    @DeleteMapping("/{genreId}")
    @ResponseStatus(NO_CONTENT)
    void deleteGenre(@PathVariable Long genreId) {
        service.deleteGenre(genreId);
    }
}
