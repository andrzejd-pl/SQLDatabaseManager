package Database.Query;

public class ConjuctionCondition implements Condition {
    private Condition leftCondition;
    private Condition rightCondition;
    private TypeConjuction type;

    public ConjuctionCondition(TypeConjuction type, Condition left, Condition right) {
        this.leftCondition = left;
        this.rightCondition = right;
        this.type = type;
    }

    @Override
    public String getCondition() {
        return "(" + leftCondition.getCondition() + " " + type.toString() + " " + rightCondition.getCondition() + ")";
    }
}
