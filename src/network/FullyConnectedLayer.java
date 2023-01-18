/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

/**
 The FullyConnectedLayer class represents a connected layer in a network visualization.
 It inherits from the NetworkLayer class and adds a specified number of nodes (numNodes) to the layer.
 The nodes are evenly spaced from the center of the layer.
 */
public class FullyConnectedLayer extends NetworkLayer {
    /**
     Constructor for the FullyConnectedLayer class.
     @param network The previous layer in the network visualization.
     @param numNodes The number of nodes to add to the connected layer.
     */
    public FullyConnectedLayer(NetworkLayer network, int numNodes) {
        super(network, network.x);
        double y = (CANVAS_HEIGHT / 2) - (numNodes * SPACING);
        for (int i = 0; i < numNodes; i++) {
            nodeList.add(new NetworkNode(x, y, previousNetworkList));
            y += SPACING;
        }
    }
}
