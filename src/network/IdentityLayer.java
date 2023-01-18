/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

public class IdentityLayer extends NetworkLayer {
    public IdentityLayer(double x, int numNodes) {
        super(null, x);
        double y = (CANVAS_HEIGHT / 2) - (numNodes * SPACING);
        for (int i = 0; i < numNodes; i++) {
            nodeList.add(new NetworkNode(x, y, null));
            y += SPACING;
        }
    }
}
