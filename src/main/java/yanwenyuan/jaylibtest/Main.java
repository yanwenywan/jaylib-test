package yanwenyuan.jaylibtest;

import static com.raylib.Raylib.*;

public class Main {
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 450;

    private static Screens currentScreen = Screens.MENU;

    static void main() {
        SetConfigFlags(FLAG_MSAA_4X_HINT);
        InitWindow(SCREEN_WIDTH, SCREEN_HEIGHT, "Java JNI Raylib window");
        SetExitKey(KEY_NULL);  // disables esc to exit
        SetTargetFPS(60);

        while (!WindowShouldClose()) {
            if (IsKeyPressed(KEY_ESCAPE)) {
                switchScreen(Screens.MENU);
            }

            currentScreen.screen().update(GetFrameTime());
            currentScreen.screen().draw();
        }

        currentScreen.screen().unload();
        CloseWindow();
    }

    public static void switchScreen(Screens screen) {
        currentScreen.unload();
        currentScreen = screen;
    }
}
