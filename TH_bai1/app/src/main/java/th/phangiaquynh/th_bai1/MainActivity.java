package th.phangiaquynh.th_bai1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText edtA, edtB;
    private Button btnAdd, btnSubtract, btnMultiply, btnDivide, btnCalculate;
    private TextView tvResult;
    private String pt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnAdd = findViewById(R.id.btnAdd);
        btnSubtract = findViewById(R.id.btnSubtract);
        btnMultiply = findViewById(R.id.btnMultiply);
        btnDivide = findViewById(R.id.btnDivide);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(v -> pt = "+");
        btnSubtract.setOnClickListener(v -> pt = "-");
        btnMultiply.setOnClickListener(v -> pt = "*");
        btnDivide.setOnClickListener(v -> pt = "/");

        btnCalculate.setOnClickListener(v -> {
            double numA = Double.parseDouble(edtA.getText().toString());
            double numB = Double.parseDouble(edtB.getText().toString());
            double result = 0;

            if (pt != null) {
                switch (pt) {
                    case "+":
                        result = numA + numB;
                        tvResult.setText("Kết quả"+numA+" + " +numB +" = "+result);
                        break;
                    case "-":
                        result = numA - numB;
                        tvResult.setText("Kết quả"+numA+" - " +numB +" = "+result);
                        break;
                    case "*":
                        result = numA * numB;
                        tvResult.setText("Kết quả"+numA+" * " +numB +" = "+result);
                        break;
                    case "/":
                        if (numB != 0) {
                            result = numA / numB;
                            tvResult.setText("Kết quả"+numA+" / " +numB +" = "+result);
                        } else {
                            tvResult.setText("Lỗi: Chia cho 0");
                            return;
                        }
                        break;
                }

            } else {
                tvResult.setText("Lỗi");
            }
        });
    }
}