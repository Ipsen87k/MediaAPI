package application.MenuFrame;

import application.FileDialog.FileOpen;
import application.FileDialog.FileOpenable;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.Stage;

public class MenuStrip extends MenuStripBase{
	private FileOpenable fileOpenable;
	
	public MenuStrip(BorderPane root, Stage stage,Scene scene) {
		super(root, stage, scene);
		fileOpenable=new FileOpen(stage);
		FileMenuItemAddEvent(); 
		EditMenuItemEventAddInit();
	}
    private void FileMenuItemAddEvent() {
    	openItem.setOnAction(event->{
    		var videoPath=fileOpenable.OpenFileDialog();
    		if(videoPath==null)
    			return;
    		mediaPlayBase.setFileName(fileOpenable.getFilePath());
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
    		if(mediaPlayBase.GetMedipPlayer().getStatus()==Status.PLAYING||mediaPlayBase.GetMedipPlayer().getStatus()==Status.PAUSED) {
    			mediaPlayBase.GetMedipPlayer().stop();
    		}
    		
    	});
    }
}
