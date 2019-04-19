package com.example.figureconversion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity{

    EditText txtNumber;
    TextView givenNumberToWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumber = findViewById(R.id.txtNumber);
        givenNumberToWord = findViewById(R.id.givenNumberToWord);

        TextWatcher fieldValidatorTextWatcher = new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if( filterLongEnough() ){
                    int number = Integer.parseInt(txtNumber.getText().toString());
                    givenNumberToWord.setText(Convert.convert(number));
                }else{
                    givenNumberToWord.setText("");
                }
            }

            private boolean filterLongEnough() {
                return txtNumber.getText().toString().trim().length() > 0;
            }
        };
        txtNumber.addTextChangedListener(fieldValidatorTextWatcher);
    }

}
