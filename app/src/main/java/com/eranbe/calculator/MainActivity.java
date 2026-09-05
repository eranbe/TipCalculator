package com.eranbe.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn10p;
    private Button btn15p;
    private Button btn20p;
    private EditText etBill;
    private TextView tvTotal;

    private void updateTotal(double tipPercent) {
        String billStr = etBill.getText().toString();
        if (billStr.isEmpty()) {
            tvTotal.setText("Total: $0.0");
        } else {
            double bill = Double.parseDouble(billStr);
            double tip = bill * tipPercent;
            double total = bill + tip;
            tvTotal.setText("Total: $" + total);
        }
    }
    public void init() {
        btn10p = findViewById(R.id.btn10p);
        btn15p = findViewById(R.id.btn15p);
        btn20p = findViewById(R.id.btn20p);
        etBill = findViewById(R.id.etBill);
        tvTotal = findViewById(R.id.tvTotal);

        btn10p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTotal(0.1);
            }
        });
        btn15p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTotal(0.15);
            }
        });
        btn20p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTotal(0.20);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }
}