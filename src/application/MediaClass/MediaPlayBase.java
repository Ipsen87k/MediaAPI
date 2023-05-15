package application.MediaClass;

import application.VolumeFrame.Obserable;
import javafx.scene.media.MediaPlayer;

public abstract class MediaPlayBase implements Obserable{
    
    public abstract void SetVideoPath(String videoPath );
    public abstract MediaPlayer GetMedipPlayer();
	public abstract String getFileName();
	public abstract void setFileName(String filename);
}
