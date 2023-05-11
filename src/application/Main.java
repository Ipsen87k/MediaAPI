package application;
	
import application.MediaClass.MovieTiem;
import application.MenuFrame.MenuStrip;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
