package application.MediaClass;

import javafx.scene.layout.HBox;

public interface IMediator <T extends Number,U> extends RootProvideer{
	default void SendData (T data) {}
	default void SendData(T data,U data2) {}
}
interface RootProvideer {
	HBox GetRoot();
}