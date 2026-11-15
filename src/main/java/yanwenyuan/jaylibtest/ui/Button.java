package yanwenyuan.jaylibtest.ui;

import com.raylib.Colors;
import com.raylib.Raylib.*;

import static com.raylib.Raylib.*;

public class Button {

    private enum State { NONE, HOVER, PRESSED }

    private Rectangle rect;
    private Text label;
    private Runnable action;
    private final Color inactiveColour;
    private final Color activeColour;

    private State state = State.NONE;

    /**
     * Note: hover colour is the inactive colour lightened towards white (this won't work if the inactive colour is white
     */
    public Button(Rectangle rect, Text label, Runnable action, Color inactiveColour, Color activeColour) {
        this.rect = rect;
        this.label = label;
        this.action = action;
        this.inactiveColour = inactiveColour;
        this.activeColour = activeColour;
    }

    public void update() {
        Vector2 mousePos = GetMousePosition();
        int button = MOUSE_BUTTON_LEFT;
        boolean colliding = CheckCollisionPointRec(mousePos, rect);
        if (IsMouseButtonUp(button)) {
            state = colliding ? State.HOVER : State.NONE;
        }
        else if (IsMouseButtonPressed(button) && colliding) {
            state = State.PRESSED;
        }
        else if (IsMouseButtonReleased(button) && colliding) {
            state = State.HOVER;
        }

        if (colliding && IsMouseButtonReleased(MOUSE_BUTTON_LEFT)) {
            action.run();
        }
    }

    public void draw() {
        Color colour = switch (state) {
            case NONE -> inactiveColour;
            case HOVER -> ColorLerp(inactiveColour, Colors.WHITE, 0.2f);
            case PRESSED -> activeColour;
        };

        DrawRectangleRec(rect, colour);
        label.draw();
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public void setLabel(Text label) {
        this.label = label;
    }

    public void setAction(Runnable action) {
        this.action = action;
    }
}
