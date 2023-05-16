package application.MediaClass;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaPlayAddEventLisner extends MediaPlayAddEventLisnerBase{
	private final Duration ONEFPSDuration=Duration.seconds(0.033333333);
	private MediaPlayer mediaPlayer;
	private ReadOnlyObjectProperty<Duration> currentTimeProperty;
	
	
	private MediaPlayAddEventLisner() {
	}
	static MediaPlayAddEventLisner CreateInstance() {
		return new MediaPlayAddEventLisner();
	}
	void addSetKeyEvent(Scene scene) {
		scene.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.K) {
                if (mediaPlayer.getStatus() == Status.PLAYING) {
                    mediaPlayer.pause();
                }
                else if(mediaPlayer.getStatus()==Status.PAUSED||mediaPlayer.getStatus()==Status.READY)
                	mediaPlayer.play();
			}
			if(e.getCode()==KeyCode.DOWN) {
				if(mediaPlayer.getStatus()==Status.PAUSED) {
					seekToPreviousFrame();
				}
			}
			if(e.getCode()==KeyCode.UP) {
				if(mediaPlayer.getStatus()==Status.PAUSED) {
					seekToNextFrame();
				}
			}
		});
	}
	void addSetMediaPlayerReadyOnEvent(Stage stage) {
    	mediaPlayer.setOnReady(()->{
    	    int videoWidth = mediaPlayer.getMedia().getWidth();
    	    int videoHeight = mediaPlayer.getMedia().getHeight();
    	    // フォーム（Stage）のサイズを動画ファイルのサイズに設定
    	    iMediator.SendData(this);
    	    stage.setWidth(videoWidth);
    	    stage.setHeight(videoHeight);
    	});
	}
	protected void CurrentTimeEvent(Slider slider, Label label) {
		mediaPlayer.currentTimeProperty().addListener((o,oldvaue,newValue)->{
			 if(!slider.isValueChanging()) {
				 slider.setValue(newValue.toSeconds());
			 }
		});
	}
    void setMediaInfo(MediaPlayer mediaPlayer) {
    	this.mediaPlayer=mediaPlayer;
    	this.currentTimeProperty=mediaPlayer.currentTimeProperty();
    }
    MediaPlayer getMediaPlayer() {
    	return this.mediaPlayer;
    }
    HBox getHbox() {
    	return iMediator.GetRoot();
    }
    private void seekToPreviousFrame() {
    	//System.out.println(currentTimeProperty.get().toMillis());
        double newTime = this.currentTimeProperty.get().toMillis() - ONEFPSDuration.toMillis();
        //System.out.println(newTime);
        this.mediaPlayer.seek(Duration.millis(newTime));
    }

    private void seekToNextFrame() {
        double newTime = this.currentTimeProperty.get().toMillis() + ONEFPSDuration.toMillis();
        this.mediaPlayer.seek(Duration.millis(newTime));
    }

}
