module MediaAPI {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.media;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
