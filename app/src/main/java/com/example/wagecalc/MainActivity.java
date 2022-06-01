package com.example.wagecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText empName, hours;
    RadioGroup empType;
    RadioButton btnSelect;
    Button btnCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        empName = findViewById(R.id.editEmployeeName);
        hours = findViewById(R.id.editHours);
        empType = findViewById(R.id.groupType);
        btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCalc:
                int selectedEmployeeType = empType.getCheckedRadioButtonId();
                btnSelect = findViewById(selectedEmployeeType);

                String type = btnSelect.getText().toString();
                String name = empName.getText().toString();
                String renderHours = (hours.getText().toString());

                Intent intent = new Intent(this, Display.class);

                intent.putExtra("type", type);
                intent.putExtra("empName", name);
                intent.putExtra("hours", renderHours);
                startActivity(intent);

                break;
        }

    }
}