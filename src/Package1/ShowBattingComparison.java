package Package1;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class ShowBattingComparison extends Application{

	public static void main(String [] args){
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button b1 = new Button("Team A");
		Button b2 = new Button("Team B");
		
		b1.setOnAction(new EventHandler <ActionEvent>() {

			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Hello World");
				
			}
		});
		//
		VBox s1 = new VBox();
		s1.getChildren().add(b1);
		s1.getChildren().add(b2);
		
		Scene scene1 = new Scene(s1,500,400);
		
		primaryStage.setScene(scene1);
		primaryStage.show();
		 
	}
}
