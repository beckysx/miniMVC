package models;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class mainModel
{
	DoubleProperty sum = new SimpleDoubleProperty();

	
	public mainModel()
	{
		
	}
	
	public DoubleProperty getSum()
	{
		return sum;
	}
	
	public void setSum(double num) {
		sum.set(num);
	}

}
