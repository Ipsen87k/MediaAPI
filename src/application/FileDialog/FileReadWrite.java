package application.FileDialog;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class FileReadWrite implements FileOpenable{
	private FileChooser dialog=new FileChooser();
	private Stage stage;
	private String filePath;
	
	public FileReadWrite(Stage stage) {
		this.stage=stage;
	    dialog.setTitle("ファイルを選択してください");
	        // 初期ディレクトリを設定（オプション）
	    dialog.setInitialDirectory(new File(System.getProperty("user.home")));
	    dialog.getExtensionFilters().add(new ExtensionFilter("MP4 files (*.mp4)", "*.mp4"));
	}
	public String OpenFileDialog() {
        var selectedFile = dialog.showOpenDialog(stage);
        
        // 選択されたファイルがある場合は処理を行う
        if (selectedFile != null) {
            // 選択されたファイルの処理
        	filePath=selectedFile.getName();
        	return new File(selectedFile.getAbsolutePath()).toURI().toString();

        }
        return null;
	}
	public String getFilePath() {
		return filePath;
	}
}