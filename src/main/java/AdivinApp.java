import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{
	private TextField AdiviText;
	private Button CheckButton;
	private Label AdiviLabel;
	private int respuesta = (int) (Math.random() * 100) + 1;
	private int count = 0;
	@Override
	public void start(Stage primaryStage) throws Exception {

		AdiviText = new TextField();
		AdiviText.setPromptText("Introduce un numero del 1 al 100");
		AdiviText.setMaxWidth(150);

		AdiviLabel = new Label("Introduce un numero del 1 al 100");

		CheckButton = new Button("Comprobar");
		CheckButton.setDefaultButton(true);
		CheckButton.setOnAction(e -> onButtonAction(e));

		
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(AdiviLabel, AdiviText,CheckButton);

		Scene scene = new Scene(root, 320, 200);
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void onButtonAction(ActionEvent e) {
		try {
			int number=Integer.parseInt (AdiviText.getText());
			count++;
			
			if (respuesta <number) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				alert.setHeaderText("Has Perdido!!");
				alert.setContentText("La respuesta es menor que "+ number );
				alert.showAndWait();
			}
			else if (respuesta >number) {
				Alert alert1 = new Alert(AlertType.WARNING);
				alert1.setTitle("");
				alert1.setHeaderText("Has Perdido!!");
				alert1.setContentText("La respuesta es mayor que "+ number);
				alert1.showAndWait();
			}
			else {
				Alert alert2 = new Alert(AlertType.INFORMATION);
				alert2.setTitle("");
				alert2.setHeaderText("Has ganado!!");
				alert2.setContentText("Has acertado y solo has necesitado "+count+" intentos\n\nVuelve a intentarlo");
				alert2.showAndWait();
			}
		} catch (NumberFormatException e1) {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setTitle("Error");
			alerta.setHeaderText("Mensaje de error");
			alerta.setContentText("No has introducido un numero");

			alerta.showAndWait();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	
}
