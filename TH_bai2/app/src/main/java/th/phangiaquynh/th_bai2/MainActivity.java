package th.phangiaquynh.th_bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText hed, wed;
    private CheckBox asianCheckBox;
    private Button calcbtn;
    private TextView bmires, bmicate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hed = findViewById(R.id.heightEditText);
        wed = findViewById(R.id.weightEditText);
        asianCheckBox = findViewById(R.id.asianCheckBox);
        calcbtn = findViewById(R.id.calculateButton);
        bmires = findViewById(R.id.bmiResultText);
        bmicate = findViewById(R.id.bmiCategoryText);

        calcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double height = Double.parseDouble(hed.getText().toString()) / 100; // Convert cm to meters
                double weight = Double.parseDouble(wed.getText().toString());

                double bmi = weight / (height * height);
                bmires.setText("Chỉ số BMI: " + String.format("%.2f", bmi));

                String category = getdanhgia(bmi, asianCheckBox.isChecked());
                bmicate.setText("Đánh giá: " + category);

            }
        });

    }
    private String getdanhgia(double bmi, boolean isAsian) {
        if (isAsian) {
            if (bmi < 18.5) return "Thiếu cân";
            if (bmi >= 18.5 && bmi < 23) return "Bình thường";
            if (bmi >= 23 && bmi < 27.5) return "Thừa cân";
            return "Béo phì";
        } else {
            if (bmi < 18.5) return "Thiếu cân";
            if (bmi >= 18.5 && bmi < 25) return "Bình thường";
            if (bmi >= 25 && bmi < 30) return "Thừa cân";
            return "Béo phì";
        }
    }
}