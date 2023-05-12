package application.LayoutBuiler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class LayoutBuidlder extends Builder{
	
	private HBox rootBox=new HBox(10);
	private List<Pane> paneArrayList=new ArrayList();
	@Override
	public void Build(BorderPane borderPane) {
		// TODO 自動生成されたメソッド・スタブ
		for(var pane:paneArrayList) {
			rootBox.getChildren().add(pane);
		}
		borderPane.setBottom(rootBox);
	}
	public LayoutBuidlder(Pane...panes) {
		for(var pane :panes) {
			paneArrayList.add(pane);
		}
	}
}
