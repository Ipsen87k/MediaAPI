package application.MenuFrame;

import application.MediaClass.MediaPlay;
import application.MediaClass.MediaPlayBase;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

abstract class MenuStripBase extends MenuBar{
	protected MediaPlayBase mediaPlayBase;
	
    protected final Menu fileMenu = new Menu("ファイル");
    protected final Menu editMenu = new Menu("編集");

    // メニューアイテムを作成
    protected final MenuItem newItem = new MenuItem("新規作成");
    protected final MenuItem openItem = new MenuItem("開く");
    protected final MenuItem saveItem = new MenuItem("保存");
    protected final MenuItem playItem = new MenuItem("再生");
    protected final MenuItem PAUSEITEM = new MenuItem("一時停止");
    protected final MenuItem STOPITEM = new MenuItem("停止");
    
    public MenuStripBase(BorderPane root,Stage stage,Scene scene) {
        fileMenu.getItems().addAll(newItem, openItem, saveItem);
        editMenu.getItems().addAll(playItem, PAUSEITEM, STOPITEM);     
        getMenus().addAll(fileMenu,editMenu);
        mediaPlayBase=new MediaPlay(root,stage,scene);
        root.setTop(this);
    }

}