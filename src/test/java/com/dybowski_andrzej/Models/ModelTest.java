package com.dybowski_andrzej.Models;

import com.dybowski_andrzej.Database.Data;
import com.dybowski_andrzej.Database.MysqlConnector;
import com.dybowski_andrzej.Exceptions.BadArgument;
import com.dybowski_andrzej.Views.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void addObserverAndDeleteObserverAndNotifyObservers() {
        try {
            Model model = null;
            View view = new ViewMock(model);
            model = new Model.Builder().addConnector(new MysqlConnectorMock("test", "test", "test", "test")).addObserver(view).build();

            model.notifyObservers();

            model.deleteObserver(view);

            model.notifyObservers();

            model.addObserver(view);

            model.notifyObservers();
        } catch (BadArgument | ClassNotFoundException badArgument) {
            badArgument.printStackTrace();
        }
    }

    private class ViewMock extends View {
        public ViewMock(Model model) {
            super(model);
        }

        @Override
        public void setModel(Model model) {
        }

        @Override
        public void deleteModel() {
        }

        @Override
        public void show() {
        }

        @Override
        public void update() {
        }
    }

    private class MysqlConnectorMock extends MysqlConnector {

        MysqlConnectorMock(String host, String database, String user, String password) throws ClassNotFoundException {
            super(host, database, user, password);
        }

        @Override
        public void connect() {
        }

        @Override
        public void close() {
        }

        @Override
        public Data execute(String query) {
            return new Data(new ArrayList<>(Arrays.asList("id", "name", "telephone")), new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList("1", "Jan Kowalski", "123456789")),
                    new ArrayList<>(Arrays.asList("2", "Adam Nowak", "987654321")),
                    new ArrayList<>(Arrays.asList("3", "Magda Kowalska", "456123789"))
            )));
        }

    }

//    @Test
//    void selectFromTable() {
//    }
}