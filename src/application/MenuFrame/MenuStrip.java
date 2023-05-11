package application.MenuFrame;

import application.FileDialog.FileOpenable;
import application.FileDialog.FileReadWrite;
import application.MediaClass.IMediator;
import application.MediaClass.MediaPlayBase;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

public class MenuStrip extends MenuStripBase{
	private FileOpenable fileOpenable;
	
	public MenuStrip(BorderPane root, Stage stage, IMediator<Double, MediaPlayBase> iMediator) {
		super(root, stage, iMediator);
		fileOpenable=new FileReadWrite(stage);
		FileMenuItemAddEvent(); 
		EditMenuItemEventAddInit();
	}
    private void FileMenuItemAddEvent() {
    	openItem.setOnAction(event->{
    		var videoPath=fileOpenable.OpenFileDialog();
    		if(videoPath==null)
    			return;
    		mediaPlayBase.SetVideoPath(videoPath);
    	});
    }
    private void EditMenuItemEventAddInit() {

    	playItem.setOnAction(event->{
        	if(mediaPlayBase.GetMedipPlayer()==null)
        		return;
    		mediaPlayBase.GetMedipPlayer().play();
    	});
    	PAUSEITEM.setOnAction(e->{
    		if(mediaPlayBase.GetMedipPlayer().getStatus()==Status.PLAYING) {
    			mediaPlayBase.GetMedipPlayer().pause();
    		}
    		
    	});
    	STOPITEM.setOnAction(e->{
    		if(mediaPlayBase.GetMedipPlayer().getStatus()==Status.PLAYING) {
    			mediaPlayBase.GetMedipPlayer().stop();
    		}
    		
    	});
    }
}
