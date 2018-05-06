package com.dybowski_andrzej.Database;

import java.util.ArrayList;
import java.util.List;

public abstract class Query {
    protected List<String> tables = new ArrayList<>();

    protected Query(String tables) {
        this.tables.add(tables);
    }

    public abstract String getQuery();
}
