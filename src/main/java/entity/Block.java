package entity;

import config.Config;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.BlockMatrix;

/**
 * Block.java
 * @author     Yannick Rüfenacht
 * @author     Mohammed Ali
 * @version    1.0
 *
 * This class represents a single block on the play grid.
 */
public class Block extends Entity {

    private int x;
    private int y;
    private int value;
    private int sink;
    private Label center;
    private Label valueLabel;
    private BlockMatrix blockMatrix;


    /**
     * Constructs a {@code Block} object.
     * @param x array position x
     * @param y array position y
     * @param value number on label
     * @param blockMatrix tell model when button is clicked
     */
    public Block(BlockMatrix blockMatrix, int x, int y, int value) {

        this.x = x;
        this.y = y;
        this.value = value;
        this.center = new Label();
        this.valueLabel = new Label(Integer.toString(value));
        this.blockMatrix = blockMatrix;

        this.setBackground();
        this.center.setAlignment(Pos.CENTER);
        this.center.setPrefWidth(Config.BLOCK_WIDTH - Config.GRID_SPACING);
        this.center.setPrefHeight(Config.BLOCK_HEIGHT - Config.GRID_SPACING);
        this.setLayoutX(this.x * Config.BLOCK_WIDTH);
        this.setLayoutY(this.y * Config.BLOCK_HEIGHT);
        this.setScaleX(0);
        this.setScaleY(0);
        this.setPrefSize(Config.BLOCK_WIDTH, Config.BLOCK_HEIGHT );
        this.setCursor(Cursor.HAND);
        this.setAlignment(Pos.CENTER);
        this.getStyleClass().add("playfield__block");
        this.getChildren().addAll(this.center, this.valueLabel);
        this.setOnMouseClicked(e -> this.blockClicked());
    }


    /**
     * Set background color and connectors.
     */
    public void setBackground() {

        Color backgroundColor = (this.value == Config.LEVEL) ?
            Config.BLOCK_COLORS.get(0) : Config.BLOCK_COLORS.get(this.value);

        if(this.value == Config.LEVEL) backgroundColor = Config.BLOCK_COLORS.get(0);

        this.center.setBackground(new Background(new BackgroundFill(
            backgroundColor,
            new CornerRadii(Config.BLOCK_BORDER_RADIUS),
            Insets.EMPTY)
        ));
    }


    /**
     * Sets or removes red border.
     * @param bombMode activate or deactivate
     */
    public void setBombMode(boolean bombMode) {

        if(bombMode)
            this.center.getStyleClass().add("playfield__block--bomb-mode");
        else
            this.center.getStyleClass().remove("playfield__block--bomb-mode");
    }


    /**
     * Sends coordinates to model.
     */
    private void blockClicked() {

        if(Config.BOT_MODE) return;
        this.blockMatrix.blockClicked(new Location(this.x, this.y));
    }


    /**
     * Let block fall down by n blocks.
     */
    public void prepareToSink() {

        this.y++;
        this.sink++;
    }


    /**
     * Set Layout Y to this.y.
     */
    public void sink() {

        Animations.getSinkAnimation(this, this.sink).play();
        this.sink = 0;
    }


    /**
     * Shake when game is over.
     */
    public void shake() {

        Animations.getShakeAnimation(this).play();
    }


    /**
     * Value setter.
     */
    public void updateValue() {

        this.value++;
        this.valueLabel.setText(Integer.toString(value));
        this.setBackground();
    }


    /**
     * X value getter.
     * @return x
     */
    public int getX() {

        return this.x;
    }


    /**
     * Y value getter.
     * @return y
     */
    public int getY() {

        return this.y;
    }


    /**
     * Value getter.
     * @return value
     */
    public int getValue() {

        return this.value;
    }

}
