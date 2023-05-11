package VolumeFrame;

public interface Observer <T extends Obserable>{
	void OnNext(T obserable);
}
