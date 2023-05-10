package application.MediaClass;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;

public class MovieTiem extends Slider implements IMediator<Double,MediaPlayBase>{
	
	private MediaPlayBase mediaPlayBase;
	private Label timeLabel=new Label();
	private HBox root=new HBox(5.0);
	public MovieTiem() {
		super();
		setMin(0);
		setValue(0);
		root.getChildren().add(this);
		root.getChildren().add(timeLabel);
		

	}

	public  void SendData(Double data) {
		SendData(data,null);
	}
	public void SendData(Double data,MediaPlayBase media) {
		setMin(media.GetMedipPlayer().getStartTime().toSeconds());
		setMax(media.GetMedipPlayer().getStopTime().toSeconds());
		mediaPlayBase=media;
		SliderChanged();
		media.CurrentTimeEvent(this, timeLabel);
	}
	private void SliderChanged() {
        // スライダーの値が変化したときに再生位置を変更する
		setOnMouseReleased(event->{
			mediaPlayBase.GetMedipPlayer().pause();
			mediaPlayBase.GetMedipPlayer().seek(javafx.util.Duration.seconds(getValue()));
			mediaPlayBase.GetMedipPlayer().play();
		});
	}
	@Override
	public HBox GetRoot() {
		// TODO 自動生成されたメソッド・スタブ
		return root;
	}

}
