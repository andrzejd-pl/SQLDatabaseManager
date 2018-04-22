package Database.Query;

public class NegativeCondition implements Condition {
    private Condition condition;

    @Override
    public String getCondition() {
        return "( NOT " + condition.getCondition() + " )";
    }
}
