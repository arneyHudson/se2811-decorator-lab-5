/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

import javafx.scene.canvas.Canvas;

/**
 * The Node interface defines methods that a node in a network visualization should have.
 */
public interface Node {
    /**
     * Getter for the x-coordinate of the node.
     * @return The x-coordinate of the node.
     */
    double getX();

    /**
     * Getter for the y-coordinate of the node.
     * @return The y-coordinate of the node.
     */
    double getY();

    /**
     * Draws the node on a given canvas.
     * @param c The canvas on which the node should be drawn.
     */
    void drawNode(Canvas c);
}
