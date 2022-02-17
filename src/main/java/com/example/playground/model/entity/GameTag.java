package com.example.playground.model.entity;

import com.example.playground.model.entity.id.GameTagId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.io.Serializable;

@Data
@ToString(exclude = "game")
@EqualsAndHashCode(exclude = "game")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameTag implements Serializable {

    private GameTagId id;

    @JsonBackReference
    private Game game;

    private Tag tag;

}
