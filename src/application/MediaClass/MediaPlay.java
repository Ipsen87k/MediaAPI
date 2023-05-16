package application.MediaClass;

import java.util.ArrayList;
import java.util.List;

import application.VolumeFrame.Observer;
import application.VolumeFrame.VolumeSliderBase;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaPlay extends MediaPlayBase{

	private Scene scene;
	private List<Observer> observers=new ArrayList<>();
	private String filePath;
	private MediaPlayAddEventLisner mediaPlayAddEventLisner;
	private Media media;
	private MediaPlayer mediaPlayer;
	private MediaView meidaView;
    private BorderPane root;
    private Stage stage;
	
	public MediaPlay(BorderPane root, Stage stage,Scene scene) {
		this.root=root;
		this.stage=stage;
		this.scene=scene;
		this.mediaPlayAddEventLisner =MediaPlayAddEventLisner.CreateInstance();
		Observer volumeSliderBase=new VolumeSliderBase(this);
	}
	@Override
	public void SetVideoPath(String videoPath) {
		initialize(videoPath);
		mediaPlayAddEventLisner.addSetKeyEvent(scene);
		mediaPlayAddEventLisner.addSetMediaPlayerReadyOnEvent(stage);
    	SendNotify();
	}
	private void initialize(String videoPath) {
		
    	media=new Media(videoPath);
    	mediaPlayer=new MediaPlayer(media);
    	meidaView =new MediaView(mediaPlayer);
    	meidaView.setFitWidth(1000);
    	root.setCenter(this.meidaView);
    	mediaPlayAddEventLisner.setMediaInfo(mediaPlayer);
	}

	public MediaPlayer GetMedipPlayer() {
		return mediaPlayer;
	}


	@Override
	public void SendNotify() {
		for(var observer:observers) {
			observer.OnNext(this.root,this.mediaPlayAddEventLisner.getHbox());
		}
	}


	public String getFileName() {
		return filePath;
	}

	@Override
	public void setFileName(String filename) {
		filePath=filename;
	}
	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}



}
