package loan.payment;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoanpaymentActivity extends Activity {

    EditText etPrincipal, etInterest, etYears;
    Button btnCalculate;
    TextView tvMonthly, tvTotalPay, tvTotalInterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etPrincipal = (EditText) findViewById(R.id.etPrincipal);
        etInterest  = (EditText) findViewById(R.id.etInterest);
        etYears     = (EditText) findViewById(R.id.etYears);
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        tvMonthly    = (TextView) findViewById(R.id.tvMonthly);
        tvTotalPay   = (TextView) findViewById(R.id.tvTotalPay);
        tvTotalInterest = (TextView) findViewById(R.id.tvTotalInterest);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calculateLoan();
            }
        });
    }

    private void calculateLoan() {
        try {
            String sP = etPrincipal.getText().toString();
            String sI = etInterest.getText().toString();
            String sL = etYears.getText().toString();

            if (sP.length() == 0 || sI.length() == 0 || sL.length() == 0) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            double P = Double.parseDouble(sP);
            double I = Double.parseDouble(sI);
            int L = Integer.parseInt(sL);

            if (I < 1 || I > 100) {
                Toast.makeText(this, "Interest must be 1 - 100%", Toast.LENGTH_SHORT).show();
                return;
            }

            double J = I / (12 * 100);
            int N = L * 12;

            double M = (J * P) / (1 - Math.pow(1 + J, -N));

            double totalPayment = M * N;
            double totalInterest = totalPayment - P;

            tvMonthly.setText("Monthly Payment (M) = " + String.format("%.2f", M));
            tvTotalPay.setText("Total Payment = " + String.format("%.2f", totalPayment));
            tvTotalInterest.setText("Total Interest Paid = " + String.format("%.2f", totalInterest));

        } catch (Exception e) {
            Toast.makeText(this, "Invalid Input!", Toast.LENGTH_SHORT).show();
        }
    }
}
