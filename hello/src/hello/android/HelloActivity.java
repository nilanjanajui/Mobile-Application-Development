package hello.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        // Initial text setup

        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Some analysis of name");
    }

    // Called when button1 is clicked
    public void handleClick(View v) {
        // Reference to EditText
        EditText widget_editText1 = (EditText) findViewById(R.id.editText1);
        String inputText = widget_editText1.getText().toString().trim();

        // Reference to TextView
        TextView widget_textView1 = (TextView) findViewById(R.id.textView1);

        // Check if input is empty
        if (inputText.length() == 0) {
            widget_textView1.setText("Please enter your name!");
            return;
        }

        // Length of the name
        int nameLen = inputText.length();

        // First half and second half
        String firstHalf = inputText.substring(0, nameLen / 2);
        String secondHalf = inputText.substring(nameLen / 2, nameLen);

        // Reverse the input
        String reversed = new StringBuilder(inputText).reverse().toString();

        // Display all info
        StringBuilder output = new StringBuilder();
        output.append("Your Name: ").append(inputText).append("\n");
        output.append("Length: ").append(nameLen).append("\n");
        output.append("First Half: ").append(firstHalf).append("\n");
        output.append("Second Half: ").append(secondHalf).append("\n");
        output.append("Reversed: ").append(reversed);

        widget_textView1.setText(output.toString());
    }


}
