package yanwenyuan.jaylibtest.shadertest;

import com.raylib.Colors;
import yanwenyuan.jaylibtest.Main;
import yanwenyuan.jaylibtest.Screen;

import static com.raylib.Raylib.*;
import static yanwenyuan.jaylibtest.util.Structs.*;

public class ShaderDisplay implements Screen {
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

    @Override
    public void update(float dt) {
        UpdateCamera(camera, CAMERA_ORBITAL);
    }

    @Override
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
                    rect(0, 0, target.texture().width(), -target.texture().height()),
                    vec2(0, 0),
                    Colors.WHITE );
            EndShaderMode();

            DrawFPS(700, 15);
        EndDrawing();
    }

    @Override
    public void unload() {
        UnloadShader(shader);
        UnloadTexture(texture);
        UnloadModel(model);
        UnloadRenderTexture(target);
    }
}
