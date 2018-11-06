package cs11F;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("AuthorMat 5000");
		
		primaryStage.show();
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		/*final Text actiontarget = new Text();
			grid.add(actiontarget, 1, 6);*/
		
		Scene scene = new Scene(grid, 500, 275);
		primaryStage.setScene(scene);
		
		Text scenetitle = new Text("Welcome to AuthorMat");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Label source = new Label("Source text: ");
		grid.add(source, 0, 1);
		
		TextField sourceField = new TextField("hamlet.txt");
		grid.add(sourceField, 1, 1);
		
		Label seedLength = new Label("Seed length: ");
		grid.add(seedLength, 0, 2);
		
		TextField seedLengthField = new TextField();
		grid.add(seedLengthField, 1, 2);
		
		Button btn = new Button("Write");
		grid.add(btn, 1, 4);
		
		
		
	}

}
