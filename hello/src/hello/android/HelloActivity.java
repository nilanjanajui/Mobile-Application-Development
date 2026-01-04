package hello.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load main.xml layout
        setContentView(R.layout.main);

        // Reference to first TextView
        TextView teks1 = (TextView) findViewById(R.id.textView1);
        teks1.setText("I am putting a new text via Java program");

        // Reference to second TextView
        TextView teks2 = (TextView) findViewById(R.id.textView2);
        teks2.setText("nilanjana");
        }
        
        public void handleClick(View v) {
        	 // get a reference to editText1 from main.xml
        	 EditText widget_editText1 = (EditText) findViewById(R.id.editText1);
        	 // get the text (input)
        	 String inputText = widget_editText1.getText().toString();
        	 // get a reference to textView1 from main.xml
        	 TextView widget_textView1 = (TextView) findViewById(R.id.textView3);
        	 // put a message (from input) to the widget
        	 widget_textView1.setText("Your Name: " + inputText);
        	 
    }
}
