package yanwenyuan.jaylibtest.shadertest;

import com.raylib.Colors;
import yanwenyuan.jaylibtest.Main;

import static com.raylib.Raylib.*;
import static yanwenyuan.jaylibtest.util.Vector.vec2;
import static yanwenyuan.jaylibtest.util.Vector.vec3;

public class ShaderDisplay {
    private final Camera3D camera;
    private final Model model;
    private final Texture texture;
    private final Shader shader;

    private final Vector3 position;
    private final RenderTexture target;

    public ShaderDisplay() {
        camera = new Camera3D()
                ._position(vec3(2f, 3f, 2f))
                .target(vec3(0f, 1f, 0f))
                .up(vec3(0f, 1f, 0f))
                .fovy(45f)
                .projection(CAMERA_PERSPECTIVE);

        model = LoadModel("assets/models/church.obj");
        texture = LoadTexture("assets/textures/church_diffuse.png");
        model.materials().maps().getPointer(MATERIAL_MAP_DIFFUSE).texture(texture);

        position = vec3(0f, 0f, 0f);

        shader = LoadShader(null, "assets/shaders/scanlines.fsh");
        System.out.println("SHADER STATE: " + IsShaderValid(shader));

        target = LoadRenderTexture(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
    }

    public void update() {
        UpdateCamera(camera, CAMERA_ORBITAL);
    }

    public void draw() {
        BeginTextureMode(target);
            ClearBackground(Colors.RAYWHITE);
            BeginMode3D(camera);
                DrawModel(model, position, 0.1f, Colors.BEIGE);
                DrawGrid(10, 1f);
            EndMode3D();
        EndTextureMode();

        BeginDrawing();
            ClearBackground(Colors.GRAY);
            BeginShaderMode(shader);
            DrawTextureRec(
                    target.texture(),
                    new Rectangle().x(0).y(0).width(target.texture().width()).height(-target.texture().height()),
                    vec2(0, 0),
                    Colors.WHITE );
            EndShaderMode();

            DrawFPS(700, 15);
        EndDrawing();
    }

    public void unload() {
        UnloadShader(shader);
        UnloadTexture(texture);
        UnloadModel(model);
        UnloadRenderTexture(target);
    }
}
