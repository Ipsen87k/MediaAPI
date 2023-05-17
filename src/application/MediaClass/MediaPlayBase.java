package application.MediaClass;

import application.VolumeFrame.Obserable;
import javafx.scene.media.MediaPlayer;

public abstract class MediaPlayBase implements Obserable{
    
    public abstract void setVideoReady(String videoPath );
    public abstract MediaPlayer getMedipPlayer();
	public abstract String getFileName();
	public abstract void setFileName(String filename);
}
