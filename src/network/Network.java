package network;/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     MSOE Faculty and Hudson Arney
 * Date:       1/11/2023
 */

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

//TODO: Either implement this class or replace it by a different class (depending on your design).
public class Network {

    // TODO: You might also want to make it variable.
    private static double RADIUS = 40;

    public void draw(Canvas destination) {
        drawNode(destination, 100,100);
        drawNode(destination, 300,400);
        drawEdge(destination, 100, 100, 300, 400);
    }

    /**
     * Draw a node centered on the given location.
     * @param canvas canvas on which to draw this.
     * @param x center of the node
     * @param y center of the node
     */
    // TODO: The name and parameters probably need updating as well.
    private static void drawNode(Canvas canvas, int x, int y){
        canvas.getGraphicsContext2D().strokeOval(x-RADIUS,y-RADIUS,2*RADIUS,2*RADIUS);
    }

    /**
     * Draw an edge between two nodes.
     *
     * @param canvas
     * @param x1 center of first node
     * @param y1
     * @param x2 center of second node
     * @param y2
     */
    //TODO: The name and parameters probably need updating as well. Drawing arrows on the edges is not a requirement.
    public static void drawEdge(Canvas canvas, double x1, double y1, double x2, double y2) {
        GraphicsContext context = canvas.getGraphicsContext2D();
        Point2D p1 = new Point2D(x1, y1);
        Point2D p2 = new Point2D(x2, y2);
        Point2D direction = p2.subtract(p1).normalize();
        Point2D radius = direction.multiply(RADIUS);
        Point2D start = p1.add(radius);
        Point2D end = p2.subtract(radius);
        context.strokeLine(start.getX(), start.getY(), end.getX(), end.getY());
    }
}
