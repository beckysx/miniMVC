import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.mainModel;
import views.mainviewController;


public class Main extends Application
{

	@Override
	public void start(Stage stage) throws Exception
	{
		mainModel model  = new mainModel();
		FXMLLoader loader  = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/mainview.fxml"));
		BorderPane view = loader.load();
		mainviewController mainC = loader.getController();
		mainC.setModel(model);
		
		
		
		Scene s = new Scene(view);
		stage.setScene(s);
		stage.show();

	}
	
	public static void main(String []args) {
		launch(args);
	}

}
