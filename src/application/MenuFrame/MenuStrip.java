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
    		var videoPath=fileOpenable.openFileDialog();
    		if(videoPath==null)
    			return;
    		mediaPlayBase.setFileName(fileOpenable.getFilePath());
    		mediaPlayBase.setVideoReady(videoPath);
    	});
    }
    private void EditMenuItemEventAddInit() {

    	playItem.setOnAction(event->{
        	if(mediaPlayBase.getMedipPlayer()==null)
        		return;
    		mediaPlayBase.getMedipPlayer().play();
    	});
    	PAUSEITEM.setOnAction(e->{
    		if(mediaPlayBase.getMedipPlayer().getStatus()==Status.PLAYING) {
    			mediaPlayBase.getMedipPlayer().pause();
    		}
    		
    	});
    	STOPITEM.setOnAction(e->{
    		if(mediaPlayBase.getMedipPlayer().getStatus()==Status.PLAYING||mediaPlayBase.getMedipPlayer().getStatus()==Status.PAUSED) {
    			mediaPlayBase.getMedipPlayer().stop();
    		}
    		
    	});
    }
}
