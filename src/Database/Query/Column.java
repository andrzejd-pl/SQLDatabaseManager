package Database.Query;

public class Column {
    private boolean selected;
    private String name;
    private String type;
    private String aliasSelected = null;
    private String aliasTable = null;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setAlias(String alias) {
        this.aliasSelected = alias;
    }

    public void setAliasTable(String alias) {
        this.aliasTable = alias;
    }

    public String getSelectedSection() {
        return ((aliasTable != null) ? (aliasTable + ".") : null) + name + ((aliasSelected != null) ? (" " + aliasSelected) : null);
    }

    public String getConditionSection() {
        return ((aliasSelected != null) ? (aliasSelected) : ((aliasTable != null) ? (aliasTable + "." + name) : name));
    }
}
