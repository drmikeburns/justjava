package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
	
	/**
	 * initialize numberOfCoffees to 2 and price to 5
	 */
	int numberOfCoffees = 0;
	int price = 5;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		/**
		 * set quantity_text_view to initialized value onCreate
		 */
		TextView quantity_text_view = (TextView) findViewById(R.id.quantity_text_view);
		quantity_text_view.setText(String.valueOf(numberOfCoffees));
	}
	
	/**
	 * This method is called when the order button is clicked.
	 */
	public void submitOrder(View view) {
		String priceMessage = "Name: Micheal Burns\nQuantity: " + numberOfCoffees + "\nTotal: $" + calculatePrice(numberOfCoffees, price) + ".00.\nThank you!";
		TextView order_summary_text_view = (TextView) findViewById(R.id.order_summary_text_view);
		order_summary_text_view.setText(priceMessage);
	}
	/**
	 * This method is called when the + (plus) button is clicked.
	 */
	public void increment(View view) {
		numberOfCoffees = numberOfCoffees + 1;
		displayQuantity(numberOfCoffees);
		
	}
	/**
	 * This method is called when the - (minus) button is clicked.
	 */
	public void decrement(View view) {
		if (numberOfCoffees != 0) {
			numberOfCoffees = numberOfCoffees - 1;
			displayQuantity(numberOfCoffees);
		}
	}
	/**
	 * This method displays the given quantity value on the screen.
	 */
	private void displayQuantity(int number) {
		TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
		quantityTextView.setText(String.valueOf(number));
	}
	
	
	/**
	 * This method displays the given text on the screen.
	 */
	private void displayMessage(String message) {
		TextView priceTextView = findViewById(R.id.order_summary_text_view);
		priceTextView.setText(message);
	}
	
	private int calculatePrice(int quantity, int price) {
		return quantity * price;
	}

}
