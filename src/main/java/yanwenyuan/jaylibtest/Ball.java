package yanwenyuan.jaylibtest;

import com.raylib.Colors;
import com.raylib.Raylib;

import static com.raylib.Raylib.*;
import static com.raylib.Raylib.Vector2;

class Ball implements Entity {
    private static final int RADIUS = 40;
    private Vector2 position;
    private boolean selected = false;

    public Ball(Vector2 position) {
        this.position = position;
    }

    @Override
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

    @Override
    public void draw() {
        DrawCircleV(position, RADIUS, selected ? Colors.RED : Colors.BLUE);
    }
}
