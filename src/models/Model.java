package models;

import Database.Data;
import Database.MysqlConnector;
import views.View;

import java.util.List;

public class Model {
    private List<View> observer;
    private MysqlConnector connector;

    public void addObserver(View observer) {

    }

    public void deleteObserver(View observer) {

    }

    public void notifyObservers() {

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

    public Data selectFromTable(String table, List<String> columns, List<String> conditions) {

    }

    public List<String> listTables() {

    }

    public List<String> listDatabases() {

    }
}
