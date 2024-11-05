package com.ar.mikellbobadilla.app.utils;

import com.ar.mikellbobadilla.app.exceptions.StorageException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
@Slf4j
public class StorageUtil {

    @Value("${storage.path}")
    private String storagePath;

    public void createDir(String dirName) {
        Path path = Paths.get(storagePath, dirName);
        try {
            if (Files.notExists(path)) Files.createDirectories(path);
        } catch (IOException e) {
            log.error(e.getMessage(), e.getCause());
            throw new StorageException("Cannot create dir " + path);
        }
    }

    public void saveFile(String dirName, MultipartFile file) {

    }
}
