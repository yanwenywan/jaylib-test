package yanwenyuan.jaylibtest.ballgame;

import com.raylib.Colors;
import com.raylib.Raylib.Vector2;

import static com.raylib.Raylib.*;
import static yanwenyuan.jaylibtest.Main.SCREEN_HEIGHT;
import static yanwenyuan.jaylibtest.Main.SCREEN_WIDTH;

public class BallGame {
    private final Ball ball;

    public BallGame() {
        ball = new Ball(new Vector2()
                .x(SCREEN_WIDTH / 2f)
                .y(SCREEN_HEIGHT / 2f));
    }

    public void update() {
        ball.update();
    }

    public void draw() {
        BeginDrawing();
        ClearBackground(Colors.RAYWHITE);
        DrawText("Window window window!", 192, 200, 20, Colors.LIGHTGRAY);
        ball.draw();
        EndDrawing();
    }
}
