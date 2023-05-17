package application.LayoutBuiler;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class LayoutBuidlder extends Builder{
	
	private HBox rootBox=new HBox(10);
	private List<Node> paneArrayList=new ArrayList();
	@Override
	public void build(BorderPane borderPane) {
		// TODO 自動生成されたメソッド・スタブ
		for(var pane:paneArrayList) {
			rootBox.getChildren().add(pane);
		}
		borderPane.setBottom(rootBox);
	}
	public LayoutBuidlder(Node...nodes) {
		for(var pane :nodes) {
			paneArrayList.add(pane);
		}
	}
}
