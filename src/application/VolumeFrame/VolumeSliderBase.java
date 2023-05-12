package application.VolumeFrame;


import application.LayoutBuiler.Builder;
import application.LayoutBuiler.LayoutBuidlder;
import application.MediaClass.MediaPlayBase;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class VolumeSliderBase extends Slider implements Observer<MediaPlayBase>{
	
	private HBox root=new HBox(5.0);
	private BorderPane pane;
	private Builder builder;
	private Label fileName=new Label();
	private final Label volumeLabel=new Label("              音量調整");
	public  VolumeSliderBase(BorderPane pane,HBox hBox) {
		super();
		setMin(0);
		setMax(1);
		this.pane=pane;
		root.getChildren().addAll(fileName,volumeLabel,this);
		builder=new LayoutBuidlder(root,hBox);
	}

	//音量イベント登録
	@Override
	public void OnNext(MediaPlayBase media) {
		setValue(media.GetMedipPlayer().getVolume());
		valueProperty().addListener(change->{
			media.GetMedipPlayer().setVolume(getValue());
		});
		fileName.setText(media.getFileName());
		builder.Build(pane);
	}
}
