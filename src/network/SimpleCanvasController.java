package network;
/*
 * Course:     SE 2811
 * Term:       Winter 2022-23
 * Assignment: Lab 5: Decorators
 * Author:     MSOE Faculty and Hudson Arney
 * Date:       1/11/2023
 */


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * The controller for the main window.
 * <p>
 * Also manages the networks.
 */
public class SimpleCanvasController {
    @FXML
    private ToggleGroup network;
    @FXML
    private Canvas canvas;

    private final Map<String, Network> displayable_networks = new HashMap<>();

    @FXML
    private void showNetwork(ActionEvent actionEvent) {
        ToggleButton source = (ToggleButton) actionEvent.getSource();
        String id = source.getId();
        System.out.println("id = " + id);
        // Clear Canvas: https://stackoverflow.com/q/27203671/1048186
        GraphicsContext context = canvas.getGraphicsContext2D();
        System.out.println("canvas.getWidth() = " + canvas.getWidth());
        System.out.println("canvas.getHeight() = " + canvas.getHeight());
        context.setLineWidth(3);
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if (!displayable_networks.containsKey(id)) {
            System.out.println("Warning: Unknown network id:" + id);
        } else {
            System.out.println("DEBUG: Drawing network: " + id);
            Network network = displayable_networks.get(id);
            network.draw(canvas);
        }
    }

    @FXML
    private void initialize() {
        displayable_networks.put("alexLike", createAlexNet());
        displayable_networks.put("inceptionLike", createInception());
    }

    /**
     * As client code, use the decorator classes to construct the inception-like network,
     * as described in the lab.
     *
     * @return network The network created.
     */
    private Network createInception() {
        // TODO return the network
        Network network = new Network();
        network.draw(canvas);
        return network;
    }

    /**
     * As client code, use the decorator classes to construct the AlexNet-like network,
     * as described in the lab.
     *
     * @return network The network created.
     */
    private Network createAlexNet() {
        // TODO return the network
        Network network = new Network();
        network.draw(canvas);
        return network;
    }

}
