package com.dybowski_andrzej.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DataTest {
    List<String> columns = new ArrayList<>(Arrays.asList("id", "name", "telephone"));
    List<List<String>> rows = new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList("1", "Jan Kowalski", "123456789")),
            new ArrayList<>(Arrays.asList("2", "Adam Nowak", "987654321")),
            new ArrayList<>(Arrays.asList("3", "Magda Kowalska", "456123789"))
    ));

    @Test
    void getRowsAndGetColumns() {
        Data data = new Data(columns, rows);

        Assertions.assertIterableEquals(this.columns, data.getColumns());
        Assertions.assertIterableEquals(this.rows, data.getRows());
    }
}