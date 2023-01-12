package network;

import java.util.List;

public class AbstractNode implements Node {
    protected double x;
    protected double y;
    protected List<Node> previousNodes;

    public AbstractNode(double x, double y, List<Node> previousNodes) {
        this.x = x;
        this.y = y;
        this.previousNodes = previousNodes;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public List<Node> getPreviousNodes() {
        return previousNodes;
    }
}
