package com.ar.mikellbobadilla.app.genre;

import com.ar.mikellbobadilla.app.exceptions.ResourceException;
import com.ar.mikellbobadilla.app.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository repository;

    public List<Genre> getAllGenres() {
        return repository.findAll();
    }

    public Genre createGenre(GenreRequest request) {
        if (repository.existsByNameIgnoreCase(request.name())) {
            throw new ResourceException("Genre name already exists");
        }

        Genre genre = Genre.builder()
                .name(request.name())
                .build();

        return repository.save(genre);
    }

    public Genre updateGenre(Long genreId, GenreRequest request) {
        Genre genre = repository.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));

        if (repository.existsByNameIgnoreCaseAndIdNot(request.name(), genreId)) {
            throw new ResourceException("Genre name already exists");
        }

        genre.setName(request.name());

        return repository.save(genre);
    }

    public void deleteGenre(Long genreId) {
        try {
            repository.deleteById(genreId);
        } catch (DataIntegrityViolationException exc) {
            throw new ResourceException("Cannot delete genre");
        }
    }
}
