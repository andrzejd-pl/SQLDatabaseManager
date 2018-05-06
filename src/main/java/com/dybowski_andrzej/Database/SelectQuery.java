package com.dybowski_andrzej.Database;

import java.util.Iterator;
import java.util.List;

public class SelectQuery extends Query{
    private List<String> columns;
    private String condition;

    public SelectQuery(String tables, List<String> columns, String condition) {
        super(tables);

        this.columns = columns;
        this.condition = condition;
    }

    @Override
    public String getQuery() {
        String query = "select ";
        String columnTmp = null;

        for(String column : this.columns) {
            query += column + ", ";
        }

        query = query.substring(0, query.length()-3);
        query += " from ";

        for (String table : this.tables) {
            query += table + ", ";
        }

        query = query.substring(0, query.length()-3);
        query += " where " + condition;

        return query;
    }
}
