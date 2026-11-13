package yanwenyuan.jaylibtest;

import yanwenyuan.jaylibtest.ballgame.BallGame;
import yanwenyuan.jaylibtest.shadertest.ShaderDisplay;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.raylib.Raylib.*;

public class Main {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 450;

    private static BallGame ballGame;
    private static ShaderDisplay display;

    public static void main(String[] args) throws IOException {
        SetConfigFlags(FLAG_MSAA_4X_HINT);
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Java JNI Raylib window");
        SetTargetFPS(60);

        ballGame = new BallGame();
        display = new ShaderDisplay();

        String data = Files.readString(Path.of("assets/hi.txt"));
        System.out.println(data);

        while (!WindowShouldClose()) {
            display.update();
            display.draw();
        }

        display.unload();
        CloseWindow();
    }
}
