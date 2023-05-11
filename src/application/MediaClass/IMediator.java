package application.MediaClass;

import javafx.scene.layout.HBox;

public interface IMediator <U> extends RootProvideer{
	void SendData(U data) ;
}
interface RootProvideer {
	HBox GetRoot();
}