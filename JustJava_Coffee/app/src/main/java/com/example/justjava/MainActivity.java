/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.v7.app.AppCompatActivity;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    int num=1;
    int p1;
    int p2;
       public void submitOrder(View view) {
        if(num<0)
            num=0;
        int quantity=num;
           CheckBox cream = (CheckBox) findViewById(R.id.checkbox);
           boolean state =  cream.isChecked();
           //Log.v("MainActivity","has whipped cream: "+state);

           if(state)
               this.p1=1;
           else
               this.p1=0;

           CheckBox chocolate = (CheckBox) findViewById(R.id.checkbox1);
           boolean chocstate = chocolate.isChecked();

           if(chocstate)
               this.p2=2;
           else
               this.p2=0;

           EditText name = (EditText) findViewById(R.id.Name);
           String Name = name.getText().toString();


//        String priceMessage="Name: "+Name+"\nQuantity: "+num+"\nAdd Whipped Cream? "+state+"\nAdd Chocolate? "+chocstate+"\nTotal: ₹"+(quantity*5+p1*num+p2*num)+"\nThank you!";
//        displayMessage(priceMessage,Name);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for "+Name);
        intent.putExtra(Intent.EXTRA_TEXT, "Name: "+Name+"\nQuantity: "+num+"\nAdd Whipped Cream? "+state+"\nAdd Chocolate? "+chocstate+"\nTotal: ₹"+(quantity*5+p1*num+p2*num)+"\n"+getString(R.string.thank_you));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void displayMessage(int quan) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        if(num>0)
            ordersummaryTextView.setText("₹"+(quan*5+p1*num+p2*num));
        else
            ordersummaryTextView.setText("₹"+0);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
//    private void display(int number) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        if(number<0)
//            quantityTextView.setText(""+0);
//        else
//        quantityTextView.setText(""+number);
//    }

    public void increment(View view){
        if(num<0)
            num=0;
        else if(num>=100)
            num=100;
        else
            num++;
        disp(num);
       // displayPrice(0);
        displayMessage(num);
    }
    public void decrement(View view){
        if(num<0)
            num=0;
        num--;
        disp(num);
        //displayPrice(0);
        displayMessage(num);
    }
    private void disp(int num) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if(num<0)
            quantityTextView.setText(""+0);
        else if(num>100)
            quantityTextView.setText(""+100);
        else
        quantityTextView.setText(""+num);
    }
}