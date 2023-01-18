/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import java.util.List;

/**
 * The NetworkNode class represents a node in a network visualization.
 * It has a position (x, y) and a list of previous nodes (previousNodes) that it is connected to.
 * The radius of the node is fixed at 10.
 */
public class NetworkNode implements Node {
    protected double x;
    protected double y;
    protected List<Node> previousNodes;
    protected static final double RADIUS = 10;

    /**
     * Constructor for the NetworkNode class.
     * @param x The x-coordinate of the node.
     * @param y The y-coordinate of the node.
     * @param previousNodes The list of previous nodes that the node is connected to.
     */
    public NetworkNode(double x, double y, List<Node> previousNodes) {
        this.x = x;
        this.y = y;
        this.previousNodes = previousNodes;
    }

    /**
     * Getter for the x-coordinate of the node.
     * @return The x-coordinate of the node.
     */
    public double getX() {
        return x;
    }

    /**
     * Getter for the y-coordinate of the node.
     * @return The y-coordinate of the node.
     */
    public double getY() {
        return y;
    }

    /**
     * Draws the node and the arrows connecting it to its previous nodes on a given canvas.
     * @param canvas The canvas on which the node and arrows should be drawn.
     */
    public void drawNode(Canvas canvas) {
        canvas.getGraphicsContext2D().strokeOval(x-RADIUS,y-RADIUS,2*RADIUS,2*RADIUS);
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        if(previousNodes != null) {
            for (Node previousNode : previousNodes) {
                Point2D p1 = new Point2D(x, y);
                Point2D p2 = new Point2D(previousNode.getX(), previousNode.getY());
                Point2D direction = p2.subtract(p1).normalize();
                Point2D radius = direction.multiply(RADIUS);
                Point2D start = p1.add(radius);
                Point2D end = p2.subtract(radius);
                graphicsContext.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());


                double arrowLength = 5;
                double angle = Math.atan2(p2.getY() - p1.getY(), p2.getX() - p1.getX());
                double x1 = start.getX() + arrowLength * Math.cos(angle + Math.PI / 6);
                double y1 = start.getY() + arrowLength * Math.sin(angle + Math.PI / 6);
                double x2 = start.getX() + arrowLength * Math.cos(angle - Math.PI / 6);
                double y2 = start.getY() + arrowLength * Math.sin(angle - Math.PI / 6);
                graphicsContext.strokePolygon(new double[]{start.getX(), x1, x2}, new double[]{start.getY(), y1, y2}, 3);


            }
        }
    }
}
