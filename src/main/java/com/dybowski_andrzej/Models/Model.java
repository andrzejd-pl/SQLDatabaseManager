package com.dybowski_andrzej.Models;

import Database.Data;
import Database.MysqlConnector;
import Database.Query;
import Database.SelectQuery;
import Exceptions.BadArgument;
import Views.View;

import java.sql.SQLException;
import java.util.List;

public class Model {
    private List<View> observers;
    private MysqlConnector connector;

    private Model(MysqlConnector connector, List<View> observers) {
        this.connector = connector;
        this.observers = observers;
    }

    public void addObserver(View observer) {
        this.observers.add(observer);
    }

    public void deleteObserver(View observer) {
        int index = observers.indexOf(observer);
        if (index != -1) observers.remove(index);
    }

    public void notifyObservers() {
        observers.forEach(View::update);
    }

    public void insertData(String table, Data data) {

    }

    public void updateData(String table, Data data, List<String> conditions) {

    }

    public void deleteData(String table, List<String> conditions) {

    }

    public void createTable(String table, List<String> columns) {

    }

    public void dropTable(String table) {

    }

    public Data selectFromTable(String table, List<String> columns, String conditions) {
        Query query = new SelectQuery(table, columns, conditions);


    }

    public List<String> listTables() {
        return null;
    }

    public List<String> listDatabases() {
        return null;
    }

    public class Builder {
        private List<View> observers;
        private MysqlConnector connector;

        public Builder() {
        }

        public Builder addObserver(View observer) {
            this.observers.add(observer);
            return this;
        }

        public Builder addConnector(MysqlConnector connector) {
            this.connector = connector;
            return this;
        }

        public Model build() throws BadArgument {
            if (observers.size() <= 0) throw new BadArgument("List observers in Builder is empty");
            return new Model(this.connector, this.observers);
        }
    }
}
