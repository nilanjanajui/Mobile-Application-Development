package bmi.calculator;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bmi_calculatorActivity extends Activity {

    EditText etWeight, etHeight;
    Button btnCalculate;
    TextView tvBMI, tvCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etWeight = (EditText) findViewById(R.id.etWeight);
        etHeight = (EditText) findViewById(R.id.etHeight);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        tvBMI = (TextView) findViewById(R.id.tvBMI);
        tvCategory = (TextView) findViewById(R.id.tvCategory);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    calculateBMI();
                } catch (Exception e) {
                    tvBMI.setText("Error!");
                    tvCategory.setText("");
                }
            }
        });
    }

    private void calculateBMI() {
        String w = etWeight.getText().toString().trim();
        String h = etHeight.getText().toString().trim();

        if (w.length() == 0 || h.length() == 0) {
            tvBMI.setText("Fill all fields");
            tvCategory.setText("");
            return;
        }

        float weight, height;

        try {
            weight = Float.parseFloat(w);
            height = Float.parseFloat(h);
        } catch (Exception e) {
            tvBMI.setText("Invalid number");
            tvCategory.setText("");
            return;
        }

        if (weight <= 0 || height <= 0) {
            tvBMI.setText("Enter positive values");
            tvCategory.setText("");
            return;
        }

        float bmi = weight / (height * height);
        tvBMI.setText("BMI: " + String.format("%.2f", bmi));

        String category;
        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            category = "Normal";
        } else if (bmi >= 25 && bmi < 29.9) {
            category = "Overweight";
        } else {
            category = "Obesity";
        }

        tvCategory.setText(category);
    }
}
