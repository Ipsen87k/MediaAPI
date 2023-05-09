package application.FileDialog;

import java.io.File;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileReadWrite {
	private FileChooser dialog=new FileChooser();
	private Stage stage;
	private String filePath;
	
	public FileReadWrite(Stage stage) {
		this.stage=stage;
	    dialog.setTitle("ファイルを選択してください");

	        // 初期ディレクトリを設定（オプション）
	    dialog.setInitialDirectory(new File(System.getProperty("user.home")));

	}
	public String OpenFileDialog() {
        var selectedFile = dialog.showOpenDialog(stage);

        // 選択されたファイルがある場合は処理を行う
        if (selectedFile != null) {
            // 選択されたファイルの処理
        	filePath = new File(selectedFile.getAbsolutePath()).toURI().toString();
        	return filePath;
        }
        return null;
	}
}