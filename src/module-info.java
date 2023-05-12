module MediaAPI {
	requires javafx.controls;
	requires java.desktop;
	requires javafx.media;
	requires javafx.base;
	requires javafx.graphics;
	
	opens application to javafx.graphics, javafx.fxml;
}
