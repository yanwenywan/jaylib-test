package yanwenyuan.jaylibtest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.raylib.Raylib.*;

public class Main {
    static final int SCREEN_WIDTH = 800;
    static final int SCREEN_HEIGHT = 450;

    private static final Game game = new Game();

    public static void main(String[] args) throws IOException {
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Java JNI Raylib window");
        SetTargetFPS(60);

        String data = Files.readString(Path.of("assets/hi.txt"));
        System.out.println(data);

        while (!WindowShouldClose()) {
            game.update();

            BeginDrawing();
            game.draw();
            EndDrawing();
        }

        CloseWindow();
    }
}
