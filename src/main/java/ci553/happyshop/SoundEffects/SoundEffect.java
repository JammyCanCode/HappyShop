package ci553.happyshop.SoundEffects;

import javafx.scene.media.MediaPlayer;
import javafx.scene.media.Media;
import javafx.util.Duration;

import java.net.URISyntaxException;
import java.util.Objects;

    /* This method contains all the functionality to allow a click sound to be played upon an action (e.g. Click a button in cView)
    This is accomplished by initializing the player first but this is only done if the player is not already created
    The first check is done by checking to see if the MediaPlayer is null, if it is null then proceed initialize the player
    If setup fails, the method is exited by return.

    If the program successfully initializes the player, then the audio file is played and .seek will ensure that the audio
    file is started from zero to enable repeated sounds upon the method being called.
     */


    public class SoundEffect {

    private static MediaPlayer player = null;


    private static void initializePlayer() {
        try {
            String audio = Objects.requireNonNull(SoundEffect.class.getResource("/buttonClick.mp3")).toURI().toString();
            Media media = new Media(audio);
            player = new MediaPlayer(media);
        } catch (NullPointerException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static void playMedia() {
        if (player == null) {
            initializePlayer();
        }
        if (player == null) {
            return;
        }
        player.seek(Duration.ZERO);
        player.setVolume(0.5);
        player.play();
    }

}



