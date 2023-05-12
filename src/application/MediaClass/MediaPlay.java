package application.MediaClass;

import VolumeFrame.VolumeSliderBase;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MediaPlay extends MediaPlayBase{

	private Scene scene;
	private final Duration ONEFPSDuration=Duration.seconds(0.0333);
	private ReadOnlyObjectProperty<Duration> currentTimeProperty;
	public MediaPlay(BorderPane root, Stage stage, double heitht,IMediator<MediaPlayBase> iMediator ,Scene scene) {
		super(root, stage, heitht);
		this.iMediator=iMediator;
		this.scene=scene;
	}

	@Override
	public void SetVideoPath(String videoPath) {
		initialize(videoPath);
    	EventInit();
	}
	private void initialize(String videoPath) {
    	media=new Media(videoPath);
    	mediaPlayer=new MediaPlayer(media);
    	meidaView =new MediaView(mediaPlayer);
    	meidaView.setFitWidth(700);
    	root.setCenter(this.meidaView);
    	
	}


	private void EventInit() {
		scene.setOnKeyPressed(e->{
			if(e.getCode()==KeyCode.K) {
                if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                    mediaPlayer.pause();
                }
                else if(mediaPlayer.getStatus()==Status.PAUSED)
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
    	mediaPlayer.setOnReady(()->{
    	    int videoWidth = mediaPlayer.getMedia().getWidth();
    	    int videoHeight = mediaPlayer.getMedia().getHeight();
    	    
    	    this.iMediator.SendData(this);
    	    currentTimeProperty=mediaPlayer.currentTimeProperty();
    	    // フォーム（Stage）のサイズを動画ファイルのサイズに設定
    	    stage.setWidth(videoWidth);
    	    stage.setHeight(videoHeight+height);
    	    root.setBottom(iMediator.GetRoot());
    	});
		
	}
    private void seekToPreviousFrame() {
        double newTime = currentTimeProperty.get().toMillis() - ONEFPSDuration.toMillis();
        mediaPlayer.seek(Duration.millis(newTime));
    }

    private void seekToNextFrame() {
        double newTime = currentTimeProperty.get().toMillis() + ONEFPSDuration.toMillis();
        mediaPlayer.seek(Duration.millis(newTime));
    }
	@Override
	public MediaPlayer GetMedipPlayer() {
		// TODO 自動生成されたメソッド・スタブ
		return mediaPlayer;
	}

	@Override
	public void CurrentTimeEvent(Slider slider, Label label) {
		mediaPlayer.currentTimeProperty().addListener((o,oldvaue,newValue)->{
			 if(!slider.isValueChanging()) {
				 slider.setValue(newValue.toSeconds());
			 }
		});
	}

	@Override
	public  void OnNext(VolumeSliderBase obserable) {
		// TODO 自動生成されたメソッド・スタブ
		
	}



}
