package application.MediaClass;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.media.MediaPlayer;

public abstract class MediaPlayAddEventLisnerBase {
	protected final IMediator<MediaPlayAddEventLisnerBase> iMediator=new TimeSlider();
	protected abstract void CurrentTimeEvent(Slider slider, Label label) ;
	abstract MediaPlayer getMediaPlayer() ;
	
}
