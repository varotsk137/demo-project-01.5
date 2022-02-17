package com.example.playground.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameDtoRequest implements Serializable {

    private GameRequest gameRequest;

    private PublisherRequest publisherRequest;

    private DeveloperRequest developerRequest;

    private List<String> tagList;

}
