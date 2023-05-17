package application.VolumeFrame;

public interface Obserable {
	void sendNotify();
	void registerObserver(Observer o);
}
