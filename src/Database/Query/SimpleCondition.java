package Database.Query;

public class SimpleCondition implements Condition {
    private String condition;

    @Override
    public String getCondition() {
        return condition;
    }
}
