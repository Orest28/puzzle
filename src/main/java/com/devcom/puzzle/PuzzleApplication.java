package com.devcom.puzzle;

import com.devcom.puzzle.services.FileStorageService;
import com.devcom.puzzle.services.imp.FileStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class PuzzleApplication implements CommandLineRunner {

    @Resource
    private FileStorageService fileStorageService;


    public static void main(String[] args) {
        SpringApplication.run(PuzzleApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        fileStorageService.deleteAll();
        fileStorageService.init();
    }
}
