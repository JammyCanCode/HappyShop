package ci553.happyshop.SoundEffects;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SoundEffectTest {
    // Make sure to uncomment **requires org.junit.jupiter.api;** in module-info.java //
    @BeforeAll
    public static void initToolkit() {
        //** Starts the JavaFX toolkit to allow testing.
        if (!Platform.isFxApplicationThread()) {
            Platform.startup(() -> {});
        }
    }
    @Test
    void playMediaDoesNotThrowErrorWhenCalled() {
        //** Tests to ensure that playMedia() does not throw exceptions when called.
        assertDoesNotThrow(SoundEffect::playMedia);
        assertDoesNotThrow(SoundEffect::playMedia);
    }
    @Test
    void buttonClickResourceExists(){
        //** Tests to ensure that the resource exists that is used for buttonClick.
        assertNotNull(SoundEffect.class.getResource("/buttonClick.mp3"));
    }
}