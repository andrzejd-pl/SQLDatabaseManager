package com.dybowski_andrzej.Database;

import java.util.List;

public abstract class Query {
    protected String tables;

    protected Query(String tables) {
        this.tables = tables;
    }

    public abstract String getQuery();
}
