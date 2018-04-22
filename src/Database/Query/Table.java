package Database.Query;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private String name;
    private List<Column> columns;
    private String alias = null;

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void choiceColumns(List<String> columns) {

    }

    public List<Column> getSelectedColumns() {
        List<Column> columnsSelected = new ArrayList<>();

        for (Column column : columns) {
            if (column.isSelected())
                columnsSelected.add(column);
        }
    }

    public String getFromSection() {
        return name + ((alias != null) ? (" " + alias) : null);
    }
}
