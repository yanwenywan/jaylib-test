package yanwenyuan.jaylibtest;

import yanwenyuan.jaylibtest.ballgame.BallGame;
import yanwenyuan.jaylibtest.shadertest.ShaderDisplay;

import java.util.function.Supplier;

/**
 * Enum to handle switching screens. Contains the screen object in question, lazy loaded
 */
public enum Screens {
    MENU(MenuScreen::new),
    BALL(BallGame::new),
    SHADER(ShaderDisplay::new)
    ;

    private final Supplier<Screen> screenSupplier;
    private Screen screen;

    Screens(Supplier<Screen> screenSupplier) {
        this.screenSupplier = screenSupplier;
    }

    public Screen screen() {
        if (screen == null) {
            screen = screenSupplier.get();
        }
        return screen;
    }

    public void unload() {
        if (screen != null) {
            screen.unload();
        }
        screen = null;
    }
}
