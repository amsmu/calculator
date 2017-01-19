package com.teksavant.calculator;


import android.databinding.DataBindingUtil;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.teksavant.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    Double firstValue = Double.NaN;
    Double secondValue;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private char CURRENT_ACTION = '0';
    private DecimalFormat decimalFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decimalFormat = new DecimalFormat("#.#######");
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mBinding.one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "1");
            }
        });

        mBinding.two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "2");
            }
        });
        mBinding.three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "3");
            }
        });
        mBinding.four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "4");
            }
        });
        mBinding.five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "5");
            }
        });
        mBinding.six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "6");
            }
        });
        mBinding.seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "7");
            }
        });
        mBinding.eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "8");
            }
        });
        mBinding.nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "9");
            }
        });
        mBinding.zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.editText.setText(mBinding.editText.getText() + "0");
            }
        });

        mBinding.addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = ADDITION;
                computeCalc();
                mBinding.editText2.setText(mBinding.editText.getText() + " + ");
                mBinding.editText.setText(null);

            }
        });
        mBinding.subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = SUBTRACTION;
                computeCalc();
                mBinding.editText2.setText(mBinding.editText.getText() + " - ");
                mBinding.editText.setText(null);

            }
        });
        mBinding.multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = MULTIPLICATION;
                computeCalc();
                mBinding.editText2.setText(mBinding.editText.getText() + " x ");
                mBinding.editText.setText(null);

            }
        });
        mBinding.division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CURRENT_ACTION = DIVISION;
                computeCalc();
                mBinding.editText2.setText(mBinding.editText.getText() + " / ");
                mBinding.editText.setText(null);

            }
        });
        mBinding.equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalc();
                mBinding.editText2.setText(mBinding.editText2.getText().toString() +
                        decimalFormat.format(secondValue) + " = " + decimalFormat.format(firstValue));
                firstValue = Double.NaN;
                CURRENT_ACTION = '0';
            }
        });
        mBinding.clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence text = mBinding.editText.getText();
                if (text.length() > 0) {
                    mBinding.editText.setText(text.subSequence(0, text.length() - 1));
                } else {
                    firstValue = Double.NaN;
                    secondValue = Double.NaN;
                    mBinding.editText.setText("");
                    mBinding.editText2.setText("");
                }
            }
        });
    }
    private void computeCalc() {
        if (!Double.isNaN(firstValue)) {
            secondValue = Double.parseDouble(mBinding.editText.getText().toString());
            mBinding.editText.setText(null);

            if (CURRENT_ACTION == ADDITION)
                firstValue = this.firstValue + secondValue;
            else if (CURRENT_ACTION == SUBTRACTION)
                firstValue = this.firstValue - secondValue;
            else if (CURRENT_ACTION == MULTIPLICATION)
                firstValue = this.firstValue * secondValue;
            else if (CURRENT_ACTION == DIVISION)
                firstValue = this.firstValue / secondValue;
        } else {
            try {
                firstValue = Double.parseDouble(mBinding.editText.getText().toString());
            } catch (Exception e) {
            }
        }
    }
}


