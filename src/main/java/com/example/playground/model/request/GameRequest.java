package com.example.playground.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRequest implements Serializable {

    private String title;

    private String description;

    private BigDecimal price;

    private ZonedDateTime releaseDate;

    private Integer discount;

}
