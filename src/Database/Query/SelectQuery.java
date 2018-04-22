package Database.Query;

import java.util.Iterator;
import java.util.List;

public class SelectQuery extends Query {
    public SelectQuery(List<Table> table, Condition condition) {
        super(table, condition);
    }

    @Override
    public String getQuery() {
        String query = "select ";
        for(Table table : tables) {
            boolean comma = false;
            Column tmpColumn = null;
            List<Column> columns = table.getSelectedColumns();

            Iterator<Column> columnIterator = columns.iterator();
            while (columnIterator.hasNext() || comma) {
                if(!comma) query += columnIterator.next().getSelectedSection();
                else if(comma)
            }
        }

        return query;
    }
}
