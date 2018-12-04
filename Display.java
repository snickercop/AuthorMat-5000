
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Display extends Application{
	
	String sourceText;
	int seedLengthInt;

	public static void main(String[] args) {
		launch(args);
	}
	
	public static GridPane makeGrid() {
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		return grid;
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
		
		TextField seedLengthField = new TextField("12");
		grid.add(seedLengthField, 1, 2);
		
		Button btn = new Button("Write");
		grid.add(btn, 1, 4);
		
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event){
				if(sourceField.getText().isEmpty()) {
					sourceText = "hamlet.txt";
				}
				else {
					sourceText = sourceField.getText();
				}
				
				if(sourceField.getText().isEmpty()) {
					seedLengthInt = 12;
				}
				else {
					seedLengthInt = Integer.parseInt(seedLengthField.getText());
				}
				
				try {
					GridPane grid2 = makeGrid();
					Scene scene2 = new Scene(grid2, 500, 275);
					primaryStage.setScene(scene2);
					Text scenetitle = new Text("Your new text: ");
					scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
					grid2.add(scenetitle, 0, 0, 2, 1);
					String[] textAndMeta = RandomWriter.write(sourceText, seedLengthInt, 500).split("@");
					Label sdLabel = new Label("                     Seed: " + textAndMeta[0]);
					grid2.add(sdLabel, 2, 1);
					TextArea newText = new TextArea(textAndMeta[1]);
					grid2.add(newText, 2, 2);
					Button goback = new Button("Go Back");
					grid2.add(goback, 2,1);
					
					goback.setOnAction(new EventHandler<ActionEvent>(){
						@Override
						public void handle(ActionEvent event){
							try{
									start(primaryStage);
								}
							catch(Exception e){
								e.printStackTrace();
							}
						}
					});
					
					
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
	


}
