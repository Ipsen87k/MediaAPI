package application.VolumeFrame;

public interface Obserable {
	void SendNotify();
	void setObserver(Observer observer);
}
