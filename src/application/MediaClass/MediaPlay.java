package application.MediaClass;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaPlay extends MediaPlayBase{

	public MediaPlay(BorderPane root, Stage stage, double heitht,IMediator<Double, MediaPlayBase> iMediator) {
		super(root, stage, heitht);
		this.iMediator=iMediator;
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
    	mediaPlayer.setOnReady(()->{
    	    int videoWidth = mediaPlayer.getMedia().getWidth();
    	    int videoHeight = mediaPlayer.getMedia().getHeight();
    	    
    	    this.iMediator.SendData(this.mediaPlayer.getTotalDuration().toSeconds(), this);
    	    // フォーム（Stage）のサイズを動画ファイルのサイズに設定
    	    stage.setWidth(videoWidth);
    	    stage.setHeight(videoHeight+height);
    	    root.setBottom(iMediator.GetRoot());
    	});
		
	}

	@Override
	public MediaPlayer GetMedipPlayer() {
		// TODO 自動生成されたメソッド・スタブ
		return mediaPlayer;
	}

	@Override
	public void CurrentTimeEvent(Slider slider, Label label) {
//		   mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
//			
//			@Override
//			public void invalidated(Observable arg0) {
//				// TODO 自動生成されたメソッド・スタブ
//				slider.setValue(mediaPlayer.getCurrentTime().toSeconds());
//			}
//		});

		mediaPlayer.currentTimeProperty().addListener((o,oldvaue,newValue)->{
			 if(!slider.isValueChanging()) {
				 slider.setValue(newValue.toSeconds());
			 }
		});
	}

}
