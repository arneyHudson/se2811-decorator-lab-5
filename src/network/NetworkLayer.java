/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

import javafx.scene.canvas.Canvas;

import java.util.ArrayList;
import java.util.List;

/**
 The NetworkLayer abstract class represents a layer in a network visualization.
 It has a list of nodes (nodeList) and a reference to the previous layer (previousNetwork) it is connected to.
 It also has a x-coordinate (x) and constants for the canvas height (CANVAS_HEIGHT) and spacing between nodes (SPACING).
 */
public abstract class NetworkLayer {

    protected List<Node> nodeList;
    protected List<Node> prevNetworkList;
    protected NetworkLayer prevLayer;
    protected double x;
    protected final double CANVAS_HEIGHT = 700;
    protected final int NODE_SPACING = 55;

    /**

     Constructor for the NetworkLayer class.
     @param prevLayer The previous layer that the current layer is connected to.
     @param coordX The x-coordinate of the current layer.
     */
    public NetworkLayer(NetworkLayer prevLayer, double coordX) {
        nodeList = new ArrayList<>();
        if(prevLayer != null) {
            this.prevNetworkList = prevLayer.getNodeList();
        }
        this.prevLayer = prevLayer;
        this.x = coordX + NODE_SPACING;
    }
    /**
     Getter for the node list of the current layer.
     @return The list of nodes in the current layer.
     */
    public List<Node> getNodeList() {
        return nodeList;
    }

    /**

     The draw method for the NetworkLayer class.
     It will first draw the previous network (if it exists) and then draw all the nodes in the nodeList.
     @param canvas The canvas on which the network should be drawn.
     */
    public void draw(Canvas canvas) {
        if(prevLayer != null) {
            prevLayer.draw(canvas);
        }
        for(Node n : nodeList) {
            n.drawNode(canvas);
        }
    }
}
