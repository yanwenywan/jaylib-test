package yanwenyuan.jaylibtest;

public interface Screen {

    void update(float dt);

    /** Implementers are expected to call BeginDrawing();EndDrawing() themselves */
    void draw();

    void unload();
}
