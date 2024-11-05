package com.ar.mikellbobadilla.app.serie;

import com.ar.mikellbobadilla.app.genre.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SerieService {
    private final SerieRepository repository;
    private final GenreRepository genreRepository;

    private final String storagePath = "E:\\dev\\streamer\\storage";

    public void createSerie(SerieRequest request, MultipartFile file) {
        
    }
}
