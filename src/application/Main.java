package application;
	
import application.FileDialog.FileReadWrite;
import application.MediaClass.IMediator;
import application.MediaClass.MediaPlay;
import application.MediaClass.MediaPlayBase;
import application.MediaClass.MovieTiem;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			var imediatir=new MovieTiem();
			new MenuStrip(root,primaryStage,imediatir);
			//root.setBottom(imediatir.GetRoot());
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			//var fe=new FileReadWrite(primaryStage);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
abstract class ButtonEstablishment{
	
	Application application;
	protected Button button=new Button();
	
	public ButtonEstablishment(Application app) {
		this.application=app;
	}
}
final class MenuStrip extends MenuBar{
	private FileReadWrite file;
	MediaPlayBase mediaPlayBase;
	private Stage stage;
	
    Menu fileMenu = new Menu("ファイル");
    Menu editMenu = new Menu("編集");

    // メニューアイテムを作成
    MenuItem newItem = new MenuItem("新規作成");
    MenuItem openItem = new MenuItem("開く");
    MenuItem saveItem = new MenuItem("保存");
    MenuItem playItem = new MenuItem("再生");
    MenuItem copyItem = new MenuItem("コピー");
    MenuItem pasteItem = new MenuItem("貼り付け");
    
    public MenuStrip(BorderPane root,Stage stage,IMediator<Double, MediaPlayBase> iMediator) {
        fileMenu.getItems().addAll(newItem, openItem, saveItem);
        editMenu.getItems().addAll(playItem, copyItem, pasteItem);
        
        getMenus().addAll(fileMenu,editMenu);
        mediaPlayBase=new MediaPlay(root,stage,this.getHeight(),iMediator);
        file=new FileReadWrite(stage);
        this.stage=stage;
        FileMenuItemEventInit();
        EditMenuItemEventInit();
        root.setTop(this);
    }
    private void FileMenuItemEventInit() {
    	openItem.setOnAction(event->{
    		mediaPlayBase.SetVideoPath(file.OpenFileDialog());
    	});
    }
    private void EditMenuItemEventInit() {
    	playItem.setOnAction(event->{
    		mediaPlayBase.GetMedipPlayer().play();
    	});
    }
}
