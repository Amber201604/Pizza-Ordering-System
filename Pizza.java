package application;
/**
 * This class is to calculate the price of pizza based on the attributes. There are 4 attributes 'size', 'cheese','mushrooms', 'pepperoni'
	 * name: Qianyu Zhang
	 * <p>
 * This version demonstrates the implementation of Comparable (for sorting) and Serializable (for
 * filing).  Also, the mutators for temperature and weather condition have been combined, so both
 * attributes have to be set at the same time.  In this way they cannot be set to an illegal value
 * independently.
	 */

import java.io.Serializable;
import java.text.DecimalFormat;

public class Pizza implements Serializable{
	
	private static final long serialVersionUID = -1007788116717589057L;
	private String size; 
	private String cheese; 
	private String mushroom; 
	private String pepperoni; 
	
	/**
	 * full parameter constructor
	 * 4 parameters
	 * @param size  the size of pizza which can be "small", "medium" or "large", only.
	 * @param cheese  which can be "single", "double" or "triple".
	 * @param mushroom  which can be "none", "single" or "double".
	 * @param pepperoni  which can be "none", "single" or "double".
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	public Pizza (String sz, String chse, String mushr, String pprn) throws IllegalPizza {
		setSize(sz);
		setCheese(chse);
		setMushroom(mushr, pprn);
		setPepperoni(pprn);
	}
	
	/** 
	 * the 2nd constructor for a small pizza with single cheese and single pepperoni without mushrooms.
	 *  no parameter
	 *  @throws IllegalPizza  If arguments are not legal.
	 */
	public Pizza () throws IllegalPizza {
		this("small", "single", "none", "single");
	}
	
	/**
	 * mutator to set the size as legal arguments.
	 * @param sz the size of pizza which can be "small", "medium" or "large", only.
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	private void setSize(String sz) throws IllegalPizza {
		if (sz == null) {
			throw new IllegalPizza ("illegal size of pizza: " + sz);
		}
		else if (sz.equalsIgnoreCase("small")) {
			size = "small";
		}
		else if (sz.equalsIgnoreCase("medium")) {
			size = "medium";
		}
		else if (sz.equalsIgnoreCase("large")) {
			size = "large";
		}
		else {
			throw new IllegalPizza ("illegal size of pizza: " + sz);
		}
		
	}
	
	/**
	 * mutator to set cheese as legal arguments.
	 * @param chse the cheese of pizza which can be "single", "double" or "triple".
	 * @throws IllegalPizza 
	 */
	private void setCheese(String chse) throws IllegalPizza {
		if (chse == null) {
			throw new IllegalPizza ("illegal cheese");
		}
		else if (chse.equalsIgnoreCase("single")) {
			cheese = "single";
		}
		else if(chse.equalsIgnoreCase("double")) {
			cheese = "double";
		}
		else if (chse.equalsIgnoreCase("triple")) {
			cheese = "triple";
		} 
		else {
			throw new IllegalPizza ("illegal cheese: " + chse);
		}		
	}
	
	/**
	 * mutator to set the mushroom as legal arguments. 
	 * a Pizza cannot have mushrooms unless it has single or double pepperoni. 
	 * @param mushr the mushroom of pizza which can be "none", "single" or "double", only.
	 * @param pprn, the pepperoni of pizza which can be "none", "single" or "double", only.
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	private void setMushroom(String mushr, String pprn) throws IllegalPizza {
		if (mushr == null) {
			throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
		}
		if (pprn == null) {
			throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
		}
		if (pprn.equalsIgnoreCase("none")) {
			if (mushr.equalsIgnoreCase("single")) {
			    throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
		    }
			else if (mushr.equalsIgnoreCase("double")) {
				throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
			}
			else if (mushr.equalsIgnoreCase("none")) {
				mushroom = "none";
			}
			else {
				throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
			}
		}
		else if (pprn.equalsIgnoreCase("single") || pprn.equalsIgnoreCase("double")) {
			if (mushr.equalsIgnoreCase("double")) {
				mushroom = "double";
			}
			else if (mushr.equalsIgnoreCase("single")) {
				mushroom = "single";
			}
			else if (mushr.equalsIgnoreCase("none")) {
				mushroom = "none";
			}
			else {
				throw new IllegalPizza ("a Pizza cannot have mushrooms if it has none pepperoni. Illegal mushroom: " + mushr);
			}
		}
		else {
			throw new IllegalPizza ("illegal mushroom: " + mushr);
		}	
	}
	
	
	/**
	 * mutator to set pepperoni as legal arguments
	 * @param pprn, the pepperoni of pizza which can be "none", "single" or "double", only.
	 * @throws IllegalPizza  If arguments are not legal.
	 */
	private void setPepperoni(String pprn) throws IllegalPizza {
		if (pprn == null) {
			throw new IllegalPizza ("illegal pepperoni: " + pprn);
		}
		if (pprn.equalsIgnoreCase("single")) {
			pepperoni = "single";
		}
		else if (pprn.equalsIgnoreCase("double")) {
			pepperoni = "double";
		}
		else if (pprn.equalsIgnoreCase("none")) {
			pepperoni = "none";
		} 
		
		else {
			throw new IllegalPizza ("illegal pepperoni: " + pprn);
		}	
	}
	
	
	/**
	 * accessor to get the price of a pizza
	 * @param price
	 * @return the price of one pizza
	 */
	public double getCost() {
		double pizzaCost = 0;
		double cheeseCost = 0;
		double mushroomCost = 0;
		double pepperoniCost = 0;
		double cost = 0;
		if (size.equalsIgnoreCase("small")) {
			pizzaCost = 7;
		}
		if (size.equalsIgnoreCase("medium")) {
			pizzaCost = 9;
		}
		if (size.equalsIgnoreCase("large")) {
			pizzaCost = 11;
		}
		if (cheese.equalsIgnoreCase("double")) {
			cheeseCost = 1.5;
		}
		if (cheese.equalsIgnoreCase("triple")) {
			cheeseCost = 3;
		}
		if (mushroom.equalsIgnoreCase("single")) {
			mushroomCost = 1.5;
		}
		if (mushroom.equalsIgnoreCase("double")) {
			mushroomCost = 3;
		}
		if (mushroom.equalsIgnoreCase("none")) {
			mushroomCost = 0;
		}
		if (pepperoni.equalsIgnoreCase("single")) {
			pepperoniCost = 1.5;
		}
		if (pepperoni.equalsIgnoreCase("double")) {
			pepperoniCost = 3;
		}
		if (pepperoni.equalsIgnoreCase("none")) {
			pepperoniCost = 0;
		}
		cost = pizzaCost + cheeseCost + mushroomCost + pepperoniCost;
		return cost;
	}
	
	/**
	 * A String representation of the current object.
     * @return A String representation of the contents of the object containing the values of
     * all the attributes.
	 */
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
        String s = size + " pizza, " + cheese + " cheese, ";
        if (mushroom == "none") {
        	s += "no mushrooms, ";
        } else {
            s += mushroom + " mushrooms, ";
        }
        if (pepperoni == "none") {
        s += "no pepperoni. ";
        } else {
        	s += pepperoni + " pepperoni. ";
        }       
        s += "Cost: $" + df.format(this.getCost()) + " each.";
        return s;
    }
	
	/**
	 * Tests two Pizza objects for equality.
     * @return <code>true</code> if all the attributes of both objects are exactly equal, <code>false</code>
     * otherwise.
     * @param otherObject The other Pizza object.
	 */
	public boolean equals(Object otherObject) {
        if (otherObject instanceof Pizza) {
        	Pizza otherH = (Pizza)otherObject;
            return size.equalsIgnoreCase(otherH.size) &&
                	cheese.equalsIgnoreCase(otherH.cheese) &&
                    mushroom.equalsIgnoreCase(otherH.mushroom) &&
                    pepperoni.equalsIgnoreCase(otherH.pepperoni);
        } // end if
        return false;
    }
	
	/**
	 * Returns a copy of the of the current Pizza object.
     * @return A copy of the current object
	 */
	public Pizza clone() {
        Pizza pizzaCopy = null;
        try {
            pizzaCopy = new Pizza(size, cheese, mushroom, pepperoni);
        } catch (IllegalPizza e) {
            // Should never get here!
            return null;
        } // end try/catch
        return pizzaCopy;
    } // end clone

}
