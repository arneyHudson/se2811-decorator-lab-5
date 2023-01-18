/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

import java.util.ArrayList;

/**
 * The ConvolutionalLayer class represents a layer in a convolutional neural network visualization.
 * It extends the NetworkLayer class and has a list of nodes (nodeList) that are connected to the nodes in the previous network layer (previousNetwork).
 *
 */
public class ConvolutionalLayer extends NetworkLayer {
    /**
     * Constructor for the ConvolutionalLayer class.
     * @param previousNetwork The previous network layer that this layer is connected to.
     */
    public ConvolutionalLayer(NetworkLayer previousNetwork) {
        super(previousNetwork, previousNetwork.x);
        for (Node node : prevNetworkList) {
            ArrayList<Node> list = new ArrayList<>();
            list.add(node);
            nodeList.add(new NetworkNode(x, node.getY(), list));
        }
    }
}
