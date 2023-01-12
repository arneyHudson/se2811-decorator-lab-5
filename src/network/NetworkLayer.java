package network;

import java.util.List;

public abstract class NetworkLayer {

    protected List<Node> nodeList;
    protected NetworkLayer previousNetwork;

    public NetworkLayer(List<Node> nodeList, NetworkLayer previousNetwork) {
        this.nodeList = nodeList;
        this.previousNetwork = previousNetwork;
    }

    public NetworkLayer getPreviousNetwork() {
        return previousNetwork;
    }

    public List<Node> getNodeList() {
        return nodeList;
    }
}
