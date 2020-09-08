package com.devcom.puzzle.controllers;

import com.devcom.puzzle.services.PuzzleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/puzzle")
public class PuzzleController {

    private final PuzzleService puzzleService;

    public PuzzleController(PuzzleService puzzleService) {
        this.puzzleService = puzzleService;
    }

    @PostMapping("/sendImage")
    public ResponseEntity<?> uploadAndBreakImage(@RequestParam("file") MultipartFile file) {

        puzzleService.uploadAndBreakImage(file);

        return null;
    }
}
