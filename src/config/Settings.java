package config;

import javafx.scene.paint.Color;
import java.util.Map;

/**
 * Settings.java
 * This class stores all constant variables of the project.
 */
public class Settings {

    public static final String APP_TITLE = "Thirteen";

    public static int GRID_DIMENSION = 5;
    public static final int BLOCK_WIDTH = 50;
    public static final int BLOCK_HEIGHT = 50;
    public static final int BLOCK_BORDER_RADIUS = 5;

    private static final int SCENE_TOP = 150;
    private static final int SCENE_BOTTOM = 50;

    private static final int SCENE_SIDE_PADDING = 50;
    public static final int SCENE_WIDTH = (GRID_DIMENSION * BLOCK_WIDTH) + SCENE_SIDE_PADDING;
    public static final int SCENE_HEIGHT = (GRID_DIMENSION * BLOCK_HEIGHT) + SCENE_TOP + SCENE_BOTTOM;

    public static final Map<Integer, Color> BLOCK_COLORS = Map.of(
        1, Color.rgb(181, 207, 97),
        2, Color.rgb(230, 194, 74),
        3, Color.rgb(198, 132, 84),
        4, Color.rgb(192, 83, 78),
        5, Color.rgb(196, 83, 147),
        6, Color.rgb(147, 73, 198),
        7, Color.rgb(96, 61, 165),
        8, Color.rgb(54, 65, 181),
        9, Color.rgb(54, 129, 197),
        10, Color.rgb(252, 252, 252)
    );
}
