package network;

import java.util.ArrayList;
import java.util.List;

public class ConvolutionalLayer extends NetworkLayer {

    private double x;

    public ConvolutionalLayer(List<Node> nodeList, NetworkLayer previousNetwork, double x) {
        super(nodeList, previousNetwork);
        this.x = x;
        double yCount = 325;
        for (Node n: previousNetwork.getNodeList()) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(n);
            nodeList.add(new ConvolutionalNode(x, yCount, list));
        }
    }
}
