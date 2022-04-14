package views;

import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import models.mainModel;

public class mainviewController {

    @FXML
    private TextField LowerNumTextField;

    @FXML
    private Label SumLabel;

    @FXML
    private TextField upperNumTextField;
    
    mainModel model;

    @FXML
    void onClickAdd(ActionEvent event) {
    	model.setSum(calculate());
    }

	
	public void setModel(mainModel newModel) {
		
		model = newModel;
		
		//bind label
		StringConverter<Number> fmt = new NumberStringConverter();
		Bindings.bindBidirectional(SumLabel.textProperty(), model.getSum(),fmt);
	}
	
	private double calculate() {
		String val1= LowerNumTextField.textProperty().get();
		String val2= upperNumTextField.textProperty().get();
		double amt1=0;
		double amt2=0;
		try {
			amt1 = Double.parseDouble(val1);
			amt2 = Double.parseDouble(val2);
		}catch (NumberFormatException e) {
			LowerNumTextField.textProperty().set("");
			upperNumTextField.textProperty().set("");
		}
		LowerNumTextField.textProperty().set("");
		upperNumTextField.textProperty().set("");
		
		return amt1+amt2;
	}

}

