package celcius.to.farenheit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CelciustofarenheitActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    public void handleNom(View v) {
    	 EditText inputTeks = (EditText) findViewById(R.id.editText1);
    	 String teks = inputTeks.getText().toString();
    	 float celsius = Float.parseFloat(teks);
    	 float paren = ((celsius * 9) / 5) + 32;
    	 TextView label2 = (TextView) findViewById(R.id.textView3);
    	 label2.setText(celsius + " Celsius is equal to " + paren + " Farenheit.");

    	}
}