package yanwenyuan.jaylibtest.ballgame;

import com.raylib.Colors;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.Vector2;

class Ball {
    private static final int RADIUS = 40;
    private Vector2 position;
    private boolean selected = false;

    public Ball(Vector2 position) {
        this.position = position;
    }

    public void update() {
        if (IsMouseButtonPressed(MOUSE_BUTTON_LEFT) && Vector2Distance(position, GetMousePosition()) < RADIUS) {
            selected = true;
        }
        if (IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
            selected = false;
        }

        if (selected) {
            position = GetMousePosition();
        }
    }

    public void draw() {
        DrawCircleV(position, RADIUS, selected ? Colors.RED : Colors.BLUE);
    }
}
