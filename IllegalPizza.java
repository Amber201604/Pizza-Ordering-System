package application;
public class IllegalPizza extends Exception {

		
		/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

		
		public IllegalPizza (String message) {
			super(message);
		}
		
		/**
		 * This constructor uses a default, generic error message.
		 */
		public IllegalPizza () {
			super("Attempt to create Pizza with illegal data!");
		}
		
	}
