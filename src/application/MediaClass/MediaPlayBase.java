package application.MediaClass;

import application.VolumeFrame.Obserable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public abstract class MediaPlayBase implements Obserable{
	protected Media media;
    protected MediaPlayer mediaPlayer;
    protected MediaView meidaView;
    protected IMediator<MediaPlayBase> iMediator;
    protected BorderPane root;
    protected Stage stage;
    double height;
    public MediaPlayBase(BorderPane root,Stage stage ,double heitht) {
	// TODO 自動生成されたコンストラクター・スタブ
    	this.root=root;
    	this.stage=stage;
    	this.height=heitht;
    }
    public abstract void SetVideoPath(String videoPath );
    public abstract MediaPlayer GetMedipPlayer();
    public abstract void CurrentTimeEvent(Slider slider,Label label);
	public abstract String getFileName();
	public abstract void setFileName(String filename);
}
