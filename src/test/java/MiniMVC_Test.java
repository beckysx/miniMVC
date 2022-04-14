

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import models.mainModel;
import views.mainviewController;

import org.testfx.api.FxRobot;
import org.testfx.assertions.api.Assertions;


@ExtendWith(ApplicationExtension.class)
class MiniMVC_Test
{
	@Start  // Before
	private void start(Stage stage) {
		mainModel model  = new mainModel();
		FXMLLoader loader  = new FXMLLoader();
		loader.setLocation(Main.class.getResource("views/mainview.fxml"));
		BorderPane view;
		try
		{
			view = loader.load();
			mainviewController mainC = loader.getController();
			mainC.setModel(model);
			Scene s = new Scene(view);
			stage.setScene(s);
			stage.show();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


		
	}
	
	private void enterVals(FxRobot robot, String upper, String lower) {
		robot.clickOn("#enterUpperVal");
		robot.write(upper);
		robot.clickOn("#enterLowerVal");
		robot.write(lower);
	}
	
	
	private void checkSum(FxRobot robot, String sum) {
		Assertions.assertThat(robot.lookup("#sumText")
				.queryAs(Label.class)).hasText(sum);
	}
	
	private void CheckAdding(FxRobot robot,String upper, String lower, String sum) {
		enterVals(robot, upper, lower);
		robot.clickOn("#addButton");
		checkSum(robot, sum);
	}


	@Test
	public void testAdds(FxRobot robot) {
		CheckAdding(robot, "1", "2", "3");
		CheckAdding(robot, "5", "-5", "0");
		CheckAdding(robot, "-4", "12", "8");
		CheckAdding(robot, "-1", "-3", "-4");
		CheckAdding(robot, "5", "-10", "-5");
		CheckAdding(robot, "0", "0", "0");
		CheckAdding(robot, "10", "0", "10");


	}

}
