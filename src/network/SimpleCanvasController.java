/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     Hudson Arney
 * Date:       1/17/2023
 */

package network;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 * The controller for the main window.
 * <p>
 * Also manages the networks.
 */
public class SimpleCanvasController {
    public ToggleButton alexLike;
    public ToggleButton inceptionLike;
    public ToggleButton hudsonLike;
    @FXML
    private Canvas canvas;

    @FXML
    private void showNetwork() {
        NetworkLayer network = null;
        if(alexLike.isSelected()) {
            network = createAlexNet();
        } else if (inceptionLike.isSelected()) {
            network = createInception();
        } else if(hudsonLike.isSelected()) {
            network = createHudsonNetwork();
        }

        if (network != null) {
            clearCanvas();
            network.draw(canvas);
        }
    }

    @FXML
    private void initialize() {
    }

    /**
     * As client code, use the decorator classes to construct the inception-like network,
     * as described in the lab.
     *
     * @return network The network created.
     */
    private NetworkLayer createInception() {
        double x = 10;
        NetworkLayer network = new IdentityLayer(x, 3);
        network = new ConvolutionalLayer(network);
        network = new ConvolutionalLayer(network);
        network = new ConvolutionalLayer(network);
        return network;
    }

    /**
     * As client code, use the decorator classes to construct the AlexNet-like network,
     * as described in the lab.
     *
     * @return network The network created.
     */
    private NetworkLayer createAlexNet() {
        double x = 10;
        NetworkLayer network = new IdentityLayer(x, 4);
        network = new ConvolutionalLayer(network);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 4);
        network = new FullyConnectedLayer(network, 3);
        return network;
    }

    private NetworkLayer createHudsonNetwork() {
        double x = 20;
        NetworkLayer network = new IdentityLayer(x, 4);
        network = new FullyConnectedLayer(network, 3);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 2);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 1);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 2);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 3);
        network = new ConvolutionalLayer(network);
        network = new FullyConnectedLayer(network, 4);
        network = new ConvolutionalLayer(network);
        return network;
    }

    private void clearCanvas() {
        GraphicsContext context = canvas.getGraphicsContext2D();
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

}
