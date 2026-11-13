package yanwenyuan.jaylibtest.util;

import com.raylib.Raylib;

public class Vector {
    private Vector() {}

    public static Raylib.Vector2 vec2(float x, float y) {
        return new Raylib.Vector2().x(x).y(y);
    }

    public static Raylib.Vector3 vec3(float x, float y, float z) {
        return new Raylib.Vector3().x(x).y(y).z(z);
    }

    public static Raylib.Vector4 vec4(float x, float y, float z, float w) {
        return new Raylib.Vector4().x(x).y(y).z(z).w(w);
    }
}
