package org.example.web.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class QueryBooksToRemove {
    @NotEmpty
    private String queryRegex;

    public String getQueryRegex() {
        return queryRegex;
    }

    public void setQueryRegex(String queryRegex) {
        this.queryRegex = queryRegex;
    }
}
