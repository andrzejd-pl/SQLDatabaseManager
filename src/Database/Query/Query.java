package Database.Query;

import java.util.List;

public abstract class Query {
    protected Condition condition;
    protected List<Table> tables;

    public Query(List<Table> table, Condition condition) {
        this.tables = table;
        this.condition = condition;
    }

    public abstract String getQuery();
}
