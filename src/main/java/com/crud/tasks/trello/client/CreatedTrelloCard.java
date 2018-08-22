package com.crud.tasks.trello.client;

import jdk.nashorn.internal.objects.annotations.Getter;

@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown=true)
public class CreatedTrelloCard {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("shortUrl")
    private String shortUrl;
}
