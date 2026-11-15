package yanwenyuan.jaylibtest.ballgame;

import com.raylib.Colors;
import com.raylib.Raylib.Vector2;
import yanwenyuan.jaylibtest.Screen;

import static com.raylib.Raylib.*;
import static yanwenyuan.jaylibtest.Main.SCREEN_HEIGHT;
import static yanwenyuan.jaylibtest.Main.SCREEN_WIDTH;

public class BallGame implements Screen {
    private final Ball ball;

    public BallGame() {
        ball = new Ball(new Vector2()
                .x(SCREEN_WIDTH / 2f)
                .y(SCREEN_HEIGHT / 2f));
    }

    @Override
    public void update(float dt) {
        ball.update();
    }

    @Override
    public void draw() {
        BeginDrawing();
        ClearBackground(Colors.RAYWHITE);
        DrawText("Window window window!", 192, 200, 20, Colors.LIGHTGRAY);
        ball.draw();
        EndDrawing();
    }

    @Override
    public void unload() {
    }
}
