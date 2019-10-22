package application;
/**
 *  The class is to calculate the total cost of pizza.
 *  * name: Qianyu Zhang
 * This version demonstrates the implementation of Comparable (for sorting) and Serializable (for
 * filing).  Also, the mutators for temperature and weather condition have been combined, so both
 * attributes have to be set at the same time.  In this way they cannot be set to an illegal value
 * independently.
 */

import java.io.Serializable;

public class LineItem implements Comparable<LineItem>, Serializable {

	private static final long serialVersionUID = -5090767330478541647L;
	private int PizzaNum = 0;
	private Pizza pizza0;
	
	/**
	 * full parameters constructor 
	 * @param num,  the number of pizza
	 * @param pizza2  the class of pizza
	 * @throws IllegalPizza   If arguments are not legal.
	 */
	public LineItem (int num, Pizza pizza2) throws IllegalPizza {
		setNumber(num);
		setPizza(pizza2);
		
	}
	
	/**
	 * constructor for a pizza
	 * @param pizza, the class of pizza
	 * @throws IllegalPizza   If arguments are not legal.
	 */
	public LineItem (Pizza pizza) throws IllegalPizza {
		setPizza(pizza);
		PizzaNum = 1;
	}
	
	/**
	 * mutator to set the pizza class
	 * @param pizza2
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	private void setPizza(Pizza pizza2) throws IllegalPizza {
		if (pizza2 == null) {
			throw new IllegalPizza("Illegal type of pizza");
		}
		pizza0 = pizza2;
	}
	
	/**
	 * mutator to set the number of pizza
	 * @param num, the number of pizza
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	public void setNumber (int num) throws IllegalPizza{
		if ((0 < num) && (num <= 100)) {
			PizzaNum = num;
		}
		else {
			throw new IllegalPizza ("Illegal number of pizza: " + num);
		}
	}
	
	/**
	 * accessor to get the class Pizza
	 * @return pizza0
	 */
	public Pizza getPizza() {
		return pizza0;
	}
	
	/**
	 * accessor to get the number of pizza
	 * @return PizzaNum the number of pizza
	 */
	public int getNumber() {
		return PizzaNum;
	}
	
	/**
	 * accessor to get the price of all pizza
	 * @param price
	 * @return the price of all pizza
	 * 
	 */
	public double getCost() {		
		double price = (pizza0.getCost()) * PizzaNum;
		if ((PizzaNum >= 10) && (PizzaNum <= 20)) {
			price = price * 0.9;
			return price;
		}
		else if (PizzaNum > 20) {
			price = price * 0.85;
			return price;
		}
		else {
			return price;
		}
	}
	
	/**
	 * A String representation of the current object.
     * @return A String representation of the contents of the object containing the values of
     * all the attributes.
	 */
	public String toString() {
		String s;
		if (PizzaNum < 10) {
			s = " " + PizzaNum + " " + pizza0.toString();
			return s;
		}
		else {
			s = PizzaNum + " " + pizza0.toString();
			return s;
		}
	}
	
	/**
	 * Compares Pizza objects on the basis of the number of visitors only.
     * @param otherH The other Pizza object.
     * @return A positive <code>int</code> if the supplied object is higher than the highest total cost, zero if they have the same
     * number and a positive number if the current object has more visitors.
	 */
	public int compareTo(LineItem other) {
        return (int) ((other.getCost()) - (this.getCost()));
    }

}
