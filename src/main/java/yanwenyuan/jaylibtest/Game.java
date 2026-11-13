package yanwenyuan.jaylibtest;

import com.raylib.Colors;
import com.raylib.Raylib.Vector2;

import static com.raylib.Raylib.ClearBackground;
import static com.raylib.Raylib.DrawText;
import static yanwenyuan.jaylibtest.Main.SCREEN_HEIGHT;
import static yanwenyuan.jaylibtest.Main.SCREEN_WIDTH;

public class Game {
    private final Ball ball;

    public Game() {
        ball = new Ball(new Vector2()
                .x(SCREEN_WIDTH / 2f)
                .y(SCREEN_HEIGHT / 2f));
    }

    public void update() {
        ball.update();
    }

    public void draw() {
        ClearBackground(Colors.RAYWHITE);
        DrawText("Window window window!", 192, 200, 20, Colors.LIGHTGRAY);
        ball.draw();
    }
}
