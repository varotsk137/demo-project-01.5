package com.example.playground.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game implements Serializable {

    private Integer gid;

    private String title;

    private String description;

    private BigDecimal price;

    private ZonedDateTime releaseDate;

    private Integer discount;

    private Publisher publisher;

    private Developer developer;

    private List<GameTag> tags;

}
