/*
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 */

package com.example.android.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the increment (+) button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the decrement (-) button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        // Calculate the price
        int price = calculatePrice();

        // Check to see if the user wants whipped cream and/or chocolate
        boolean hasWhippedCream = ((CheckBox) findViewById(R.id.checkbox_whipped_cream)).isChecked();
        boolean hasChocolate = ((CheckBox) findViewById(R.id.checkbox_chocolate)).isChecked();

        // Display the order summary
        String message = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(message);

    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() {
        return quantity * 5;
    }

    /**
     * Create summary of the order.
     *
     * @param price of the order
     * @param addWhippedCream is whether user wants whipped cream or not
     * @param addChocolate is whether user wants whipped cream or not
     * @return text summary
     */
    private String createOrderSummary(int price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = "Name: Kaptain Kunal\n" +
                "Add whipped cream? " + addWhippedCream + "\n" +
                "Add chocolate? " + addChocolate + "\n" +
                "Quantity: " + quantity + "\n" +
                "Total: $" + price + "\n" +
                "Thank you!";
        return priceMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}