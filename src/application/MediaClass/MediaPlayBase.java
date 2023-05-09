package application.MediaClass;

import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MediaPlayBase {
	protected Media media;
    protected MediaPlayer mediaPlayer;
    protected MediaView meidaView;
    BorderPane root;
    Stage stage;
    double height;
    public MediaPlayBase(BorderPane root,Stage stage ,double heitht) {
	// TODO 自動生成されたコンストラクター・スタブ
    	this.root=root;
    	this.stage=stage;
    	this.height=heitht;
    }
    public void SetVideoPath(String videoPath ) {
    	media=new Media(videoPath);
    	mediaPlayer=new MediaPlayer(media);
    	this.meidaView =new MediaView(mediaPlayer);
    	EventInit();
    	root.setCenter(this.meidaView);
    }
    public MediaPlayer GetMedipPlayer() {
    	return this.mediaPlayer;
    }
    public Media GetMedia() {
    	return this.media;
    }
    private void EventInit() {
    	mediaPlayer.setOnReady(()->{
    	    int videoWidth = mediaPlayer.getMedia().getWidth();
    	    int videoHeight = mediaPlayer.getMedia().getHeight();

    	    // フォーム（Stage）のサイズを動画ファイルのサイズに設定
    	    stage.setWidth(videoWidth);
    	    stage.setHeight(videoHeight+height);
    	});
    }
}
