package application.VolumeFrame;

public interface Obserable {
	void SendNotify();
	void registerObserver(Observer o);
}
