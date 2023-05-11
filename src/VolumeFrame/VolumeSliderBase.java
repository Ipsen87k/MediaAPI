package VolumeFrame;

import javafx.scene.control.Slider;

public class VolumeSliderBase extends Slider implements Obserable{
	
	Observer observer;
	public  VolumeSliderBase() {
		super();
		setMin(0);
		setMax(1);
	}
	public void setObserver(Observer observer) {
		this.observer=observer;
	}
	@Override
	public void SendNotify() {
		// TODO 自動生成されたメソッド・スタブ
		observer.OnNext(this);
	}
}
