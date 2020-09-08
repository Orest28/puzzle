package com.devcom.puzzle.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Puzzles")
@Data
public class Puzzle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resultImage;

    @OneToMany(mappedBy = "puzzle", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Image> particlesList;

}
