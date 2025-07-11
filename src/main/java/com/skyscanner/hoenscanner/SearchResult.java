
package com.skyscanner.hoenscanner;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchResult {
    @JsonProperty
    private String city;

    @JsonProperty
    private String kind;

    @JsonProperty
    private String title;

    public SearchResult() {}

    public SearchResult(String city, String kind, String title) {
        this.city = city;
        this.kind = kind;
        this.title = title;
    }
}
