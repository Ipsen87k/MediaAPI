package application.VolumeFrame;


import application.LayoutBuiler.Builder;
import application.LayoutBuiler.LayoutBuidlder;
import application.MediaClass.MediaPlayBase;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class VolumeSliderBase extends Slider implements Observer<BorderPane,HBox>{
	
	private HBox root=new HBox(5.0);
	private MediaPlayBase mediaPlayBase;
	private BorderPane pane;
	private Builder builder;
	private Label fileName=new Label();
	private final Label volumeLabel=new Label("              音量調整");
	private boolean first=true;
	public  VolumeSliderBase(MediaPlayBase mediaPlayBase) {
		super();
		setMin(0);
		setMax(1);
		this.mediaPlayBase=mediaPlayBase;
		mediaPlayBase.registerObserver(this);
		root.getChildren().addAll(fileName,volumeLabel,this);
		
	}

	//音量イベント登録
	@Override
	public void update(BorderPane pane,HBox hBox) {
		setValue(mediaPlayBase.getMedipPlayer().getVolume());
		valueProperty().addListener(change->{
			mediaPlayBase.getMedipPlayer().setVolume(getValue());
		});
		fileName.setText(mediaPlayBase.getFileName());
		if(first) {
			builder=new LayoutBuidlder(root,hBox);
			builder.build(pane);
			first=false;
		}
		
	}

}
