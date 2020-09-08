package com.devcom.puzzle.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {

    void init();

    void save(MultipartFile file);

    void deleteAll();
}
