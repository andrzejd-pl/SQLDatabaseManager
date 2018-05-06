package com.dybowski_andrzej.Database;

import java.util.List;

public class Data {
    private List<List<String>> rows;
    private List<String> columns;

    public Data(List<String> cols, List<List<String>> rows){
        this.columns = cols;
        this.rows = rows;
    }

    public List<List<String>> getRows() {
        return rows;
    }

    public List<String> getColumns() {
        return columns;
    }
}
