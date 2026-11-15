package yanwenyuan.jaylibtest;

import com.raylib.Colors;
import yanwenyuan.jaylibtest.ui.Button;
import yanwenyuan.jaylibtest.ui.Text;
import yanwenyuan.jaylibtest.util.Structs;

import static com.raylib.Raylib.*;
import static yanwenyuan.jaylibtest.Main.*;

public class MenuScreen implements Screen {

    private final Button[] buttons = new Button[]{
            MenuScreen.makeButton(0, 0, "Ball test", Colors.GREEN, Colors.RED, () -> switchScreen(Screens.BALL)),
            MenuScreen.makeButton(1, 0, "Shader model\nexample", Colors.BLUE, Colors.RED, () -> switchScreen(Screens.SHADER))
    };

    public MenuScreen() {
        System.out.println("Loading menu screen");
    }

    @Override
    public void update(float dt) {
        for (Button button : buttons) {
            button.update();
        }
    }

    @Override
    public void draw() {
        BeginDrawing();

        ClearBackground(Colors.RAYWHITE);

        DrawText("Uhh, this menu screen is requiring working...", 10, 10, 18, Colors.BLACK);
        DrawText("Press [ESC] from any screen to return back to the menu", 10, 30, 18, Colors.BLACK);

        for (Button button : buttons) {
            button.draw();
        }

        EndDrawing();
    }

    @Override
    public void unload() {

    }

    // button calculation things
    private static final int uiBaseline = 80;
    private static final int buttonGap = 20;
    private static final int borderGap = 40;
    private static final int columns = 4;
    private static final int rows = 3;
    private static final int buttonWidth = (SCREEN_WIDTH - 2*borderGap - (columns-1)*buttonGap) / columns;
    private static final int buttonHeight = (SCREEN_HEIGHT - uiBaseline - borderGap - (rows-1)*buttonGap) / rows;

    /**
     * create a button, based on the button grid. Does not wrap text! (also assumes it's white)
     *
     * @param x x position / column index, 0 indexed
     * @param y y position / row index, 0 indexed
     */
    static Button makeButton(int x, int y, String label, Color inactive, Color active, Runnable action) {
        int screenX = borderGap + x * (buttonGap + buttonWidth);
        int screenY = uiBaseline + y * (buttonGap + buttonHeight);
        Rectangle rect = Structs.rect(screenX, screenY, buttonWidth, buttonHeight);
        Text text = new Text(label, screenX + 12, screenY + 12, 20, Colors.WHITE);
        return new Button(rect, text, action, inactive, active);
    }
}
