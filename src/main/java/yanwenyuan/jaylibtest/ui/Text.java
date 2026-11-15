package yanwenyuan.jaylibtest.ui;

import com.raylib.Raylib;

/** A light wrapper around a simple raylib DrawText */
public record Text(String text, int x, int y, int fontSize, Raylib.Color color) {
    public void draw() {
        Raylib.DrawText(text, x, y, fontSize, color);
    }
}
