package application;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PizzaController {
	
	//attribute for the whole controller
	private String s;
	private double total = 0;
	private String size;
	private String cheese;
	private String mushroom;
	private String pepperoni;
	
    //define the FX ID 
    @FXML
    private ChoiceBox<String> size1 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> cheese1 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> pepperoni1 = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> mushroom1 = new ChoiceBox<>();

    //choice box observableArrayList
    @FXML
    private TextField size2;
    private ObservableList<String> sizeList = FXCollections.observableArrayList(
    		"choose...","small", "medium", "large");

    @FXML
    private TextField cheese2;
    private ObservableList<String> cheeseList = FXCollections.observableArrayList(
    		"choose...","single", "double", "triple");

    @FXML
    private TextField pepperoni2;
    
    
    @FXML
    private TextField mushroom2;
    private ObservableList<String> pepperoniList = FXCollections.observableArrayList(
			"choose...","none", "single", "double");
    private ObservableList<String> mushroomList1 = FXCollections.observableArrayList(
    		"choose...","none", "single", "double");
    private ObservableList<String> mushroomList2 = FXCollections.observableArrayList(
    		"choose...","none");

    @FXML
    private Button price;

    @FXML
    private TextField getPrice;

    @FXML
    private TextArea quantity;

    @FXML
    private Button save;
    
    @FXML
    private Button currentCost1;
    
    @FXML
    private TextField currentCost2;

    @FXML
    private TextArea order;
    
    //this method is to calculate the price of each configured pizza
    @FXML
    void Price(ActionEvent event) {
    	size = size2.getText();
    	cheese = cheese2.getText();
    	mushroom = mushroom2.getText();
    	pepperoni = pepperoni2.getText();
    	Pizza newPizza = null;
    	try {
    		newPizza = new Pizza(size, cheese, mushroom, pepperoni); //call Pizza class
    		
    	}catch (IllegalPizza e) {
    		e.printStackTrace();
    	} 
    	    	    	    	    	
    	double price = newPizza.getCost();//call getCost() method in Pizza class
    	String price1 = String.valueOf(price);
    	getPrice.setText(price1);
    }//end Price
    
    // this method is to calculate the cost of the configured pizza with current quantity      	    	     
    @FXML
    void CurrentCost(ActionEvent event) {
    	size = size2.getText();
    	cheese = cheese2.getText();
    	mushroom = mushroom2.getText();
    	pepperoni = pepperoni2.getText();
    	Pizza newPizza = null;
    	try {
    		newPizza = new Pizza(size, cheese, mushroom, pepperoni);//call Pizza class
    		
    	}catch (IllegalPizza e) {
    		e.printStackTrace();
    	} 
    	    	    	    	
    	String Val = quantity.getText();
    	int aVal = Integer.parseInt(Val);    	
    	LineItem item = null;
    	try {
    		
    		item = new LineItem(aVal, newPizza);//call LineItem Class
    	}catch (IllegalPizza e) {
    		e.printStackTrace();
    	}
    	double Cost0 = item.getCost();//getCost() in LineItem class
    	String Cost1 = String.valueOf(Cost0);
    	currentCost2.setText(Cost1); 
    	}//end CurrentCost
    
 // this method is to calculate the total cost
    @FXML
    void TotalCost(ActionEvent event){
    	size = size2.getText();
    	cheese = cheese2.getText();
    	mushroom = mushroom2.getText();
    	pepperoni = pepperoni2.getText();
    	Pizza newPizza = null;
    	try {
    		newPizza = new Pizza(size, cheese, mushroom, pepperoni);//call Pizza class
    		
    	}catch (IllegalPizza e) {
    		e.printStackTrace();
    	} 
    	    	    	    	
    	String Val = quantity.getText();
    	int aVal = Integer.parseInt(Val);    	
    	LineItem item = null;
    	try {
    		
    		item = new LineItem(aVal, newPizza);//call LineItem Class
    	}catch (IllegalPizza e) {
    		e.printStackTrace();
    	}
    	
    	double Cost0 = item.getCost();
    	total += Cost0;// get the total cost
    	s += item.toString() + "\n";// get the order description
    	String total1 = String.valueOf(total);
    	order.setText(s + "\n" + "Total cost: " + "$ " + total1);    	
    	}//end TotalCost
   
 // this method is to set the value of choice box and restrict to only integer can be entered in the quantity textfield 
    @FXML
    void initialize() {
    	size1.setValue("choose...");
    	size1.setItems(sizeList);    	
    	size1.valueProperty().addListener((observableValue, oldVal, newVal) ->
    	{
        	size2.setText(newVal);
    	});
    	cheese1.setValue("choose...");
    	cheese1.setItems(cheeseList);   	
    	cheese1.valueProperty().addListener((ob, oldVal, newVal) ->
    	{
    		cheese2.setText(newVal);
    	});
    	pepperoni1.setValue("choose...");
    	pepperoni1.setItems(pepperoniList);
    	mushroom1.setValue("choose...");
    	mushroom1.setItems(mushroomList2);
    	pepperoni1.valueProperty().addListener((ob, oldVal, newVal) ->
    	{
    		pepperoni2.setText(newVal);
    		//a Pizza cannot have mushrooms unless it has single or double pepperoni.
    		switch(newVal) {
    		case "none" :
    			mushroom1.setItems(mushroomList2);
    			break;
    		case "single" :
    			mushroom1.setItems(mushroomList1);
    			break;
    		case "double" :
    			mushroom1.setItems(mushroomList1);
    			break;
    		}
    	});
    	mushroom1.valueProperty().addListener((ob, oldVal, newVal) ->
    	{
    		mushroom2.setText(newVal);
    	});
    	
    	quantity.textProperty().addListener((observableValue, oldText, newText) ->
    	{
    		if (newText != null && !newText.isEmpty()) {
	    		try {
	    			Integer.parseInt(newText);//only integer
	    			
	    		} catch (NumberFormatException e) {
	    			((StringProperty)observableValue).setValue(oldText);
	    		}
    		}
    	});    	    	
    	}//end initialized    
}//end PizzaController
