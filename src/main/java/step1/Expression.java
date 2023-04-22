package step1;

import java.util.List;

public class Expression {
    private final List<Node> nodeList;
    private final List<Operator> operatorList;

    public Expression(List<Node> nodeList, List<Operator> operatorList) {
        this.nodeList = nodeList;
        this.operatorList = operatorList;
    }

    public int execute() {
        int sum = nodeList.get(0).getValue();
        for (int i =0 ; i<operatorList.size() ; i++) {
            sum = operatorList.get(i).calculate(sum, nodeList.get(i + 1).getValue());
        }
        return sum;
    }
}
