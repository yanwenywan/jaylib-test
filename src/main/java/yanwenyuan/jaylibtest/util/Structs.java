package yanwenyuan.jaylibtest.util;

import com.raylib.Raylib;

/**
 * Factory methods for making raylib objects using native java like syntax
 */
public class Structs {
    private Structs() {}

    public static Raylib.Vector2 vec2(float x, float y) {
        return new Raylib.Vector2().x(x).y(y);
    }

    public static Raylib.Vector3 vec3(float x, float y, float z) {
        return new Raylib.Vector3().x(x).y(y).z(z);
    }

    public static Raylib.Vector4 vec4(float x, float y, float z, float w) {
        return new Raylib.Vector4().x(x).y(y).z(z).w(w);
    }

    public static Raylib.Rectangle rect(float x, float y, float width, float height) {
        return new Raylib.Rectangle().x(x).y(y).width(width).height(height);
    }
}
