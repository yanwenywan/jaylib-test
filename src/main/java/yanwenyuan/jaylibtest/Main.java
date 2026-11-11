package yanwenyuan.jaylibtest;

import com.raylib.Colors;

import static com.raylib.Raylib.*;

public class Main {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 450;

    private static final Ball ball = new Ball(new Vector2().x(SCREEN_WIDTH/2f).y(SCREEN_HEIGHT/2f));

    static void update() {
        ball.update();
    }

    static void draw() {
        ClearBackground(Colors.RAYWHITE);
        DrawText("Window window window!", 192, 200, 20, Colors.LIGHTGRAY);
        ball.draw();
    }

    public static void main(String[] args) {
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Java JNI Raylib window");
        SetTargetFPS(60);

        while (!WindowShouldClose()) {
            update();

            BeginDrawing();
            draw();
            EndDrawing();
        }

        CloseWindow();
    }
}
