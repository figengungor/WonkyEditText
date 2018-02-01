package com.figengungor.wonkyedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AppCompatEditText firstNameEt;
    AppCompatEditText lastNameEt;
    AppCompatEditText emailEt;

    String strFirstName, strLastName, strEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEt = findViewById(R.id.firstNameEt);
        lastNameEt = findViewById(R.id.lastNameEt);
        emailEt = findViewById(R.id.emailEt);

        firstNameEt.addTextChangedListener(textWatcher);
        lastNameEt.addTextChangedListener(textWatcher);
        emailEt.addTextChangedListener(textWatcher);

    }

    public void submit(View view) {
        if(checkInputs()) {
            //You shall pass
        }
    }

    private boolean checkInputs() {
        if (!TextUtils.isEmpty(strFirstName)
                && !TextUtils.isEmpty(strLastName)
                && !TextUtils.isEmpty(strEmail)) {
            return true;
        }
        else {

            if (strFirstName == null || strFirstName.length() == 0) {
                firstNameEt.setError("First name can't be empty");
            }
            if (strLastName == null || strLastName.length() == 0) {
                lastNameEt.setError("Last name can't be empty");
            }
            if (strEmail == null || strEmail.length() == 0) {
                emailEt.setError("Email can't be empty");
            }

            return false;
        }
    }




    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            // TODO Auto-generated method stub
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            // TODO Auto-generated method stub
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (firstNameEt != null && firstNameEt.getText().hashCode() == editable.hashCode())
                getAfterText(firstNameEt, editable);
            if (lastNameEt != null && lastNameEt.getText().hashCode() == editable.hashCode())
                getAfterText(lastNameEt, editable);
            if (emailEt != null && emailEt.getText().hashCode() == editable.hashCode())
                getAfterText(emailEt, editable);
        }
    };

    private void getAfterText(AppCompatEditText editText, Editable s) {
        switch (editText.getId()) {

            case R.id.firstNameEt:
                firstNameEt.setError(null);
                strFirstName = "";
                if (null != s && s.length() > 0) {
                    strFirstName = s.toString();
                }
                break;

            case R.id.lastNameEt:
                lastNameEt.setError(null);
                strLastName = "";
                if (null != s && s.length() > 0) {
                    strLastName = s.toString();
                }
                break;

            case R.id.emailEt:
                emailEt.setError(null);
                strEmail = "";
                if (null != s && s.length() > 0) {
                    strEmail = s.toString();
                }
                break;

        }
    }
}
