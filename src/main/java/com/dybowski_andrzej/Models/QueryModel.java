package com.dybowski_andrzej.Models;

import com.dybowski_andrzej.Database.*;
import com.dybowski_andrzej.Exceptions.BadArgument;
import com.dybowski_andrzej.Views.View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryModel extends Model {
    private MysqlConnector connector;

    private QueryModel(MysqlConnector connector, List<View> observers) {
        super(observers);
        this.connector = connector;
    }

    public Data selectFromTable(String table, List<String> columns, String conditions) throws SQLException {
        Query query = new SelectQuery(table, columns, conditions);

        Data data = connector.execute(query.getQuery());
        connector.close();
        return data;
    }

    public static class Builder {
        private List<View> observers = new ArrayList<>();
        private MysqlConnector connector;

        public Builder addObserver(View observer) {
            this.observers.add(observer);
            return this;
        }

        public Builder addConnector(MysqlConnector connector) {
            this.connector = connector;
            return this;
        }

        public QueryModel build() throws BadArgument {
            if (observers.size() <= 0) throw new BadArgument("List observers in Builder is empty");
            return new QueryModel(this.connector, this.observers);
        }
    }
}
