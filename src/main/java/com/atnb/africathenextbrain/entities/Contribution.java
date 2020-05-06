package com.atnb.africathenextbrain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Contribution implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String message;
    private String signature;
    private String domaine;
    private int  etat;
}
