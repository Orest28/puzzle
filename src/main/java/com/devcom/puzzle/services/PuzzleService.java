package com.devcom.puzzle.services;

import org.springframework.web.multipart.MultipartFile;

public interface PuzzleService {

    void uploadAndBreakImage(MultipartFile image);
}