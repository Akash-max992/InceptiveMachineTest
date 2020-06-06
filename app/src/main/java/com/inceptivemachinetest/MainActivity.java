package com.inceptivemachinetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.sip.SipSession;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @BindView(R.id.ButtonRegister)
    Button mButtonRegister;
    @BindView(R.id.TextInput_FirstName)
    TextInputLayout mTextInputFirstName;
    @BindView(R.id.TextInput_LastName)
    TextInputLayout mTextInputLastName;
    @BindView(R.id.TextInput_Email)
    TextInputLayout mTextInputEmail;
    @BindView(R.id.TextInput_MobileNumber)
    TextInputLayout mTextInputLastMobileNumber;
    @BindView(R.id.TextInput_State)
    TextInputLayout mTextInputTextState;
    @BindView(R.id.TextInput_City)
    TextInputLayout mTextInputCity;
    @BindView(R.id.TextInput_Password)
    TextInputLayout mTextInputPassword;
    @BindView(R.id.TextInput_ConfirmPassword)
    TextInputLayout mTextInputConfirmPassword;
    @BindView(R.id.SpinnerState)
    Spinner mSpinnerState;
    @BindView(R.id.SpinnerCity)
    Spinner mSpinnerCity;

    String name,mail,phoneNumber;
    List<String> mStateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mStateList = new ArrayList<String>();
        mStateList.add("Select State");
        mStateList.add("Maharashtra");
        mStateList.add("Uttar Pradesh");
        mStateList.add("Tamil Nadu");
        ArrayAdapter<String> mAdapterState = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, mStateList);
        mAdapterState.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        mSpinnerState.setAdapter(mAdapterState);

        mSpinnerState.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {

                String SpinnerState= String.valueOf(mSpinnerState.getSelectedItem());
                if(SpinnerState.contentEquals("Maharashtra")) {
                    List<String> mMaharashtraList = new ArrayList<String>();
                    mMaharashtraList.add("Select City");
                    mMaharashtraList.add("Pune");
                    mMaharashtraList.add("Mumbai");
                    mMaharashtraList.add("Latur");
                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, mMaharashtraList);
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter.notifyDataSetChanged();
                    mSpinnerCity.setAdapter(dataAdapter);
                }
                if(SpinnerState.contentEquals("Tamil Nadu")) {
                    List<String> mTamilNaduList = new ArrayList<String>();
                    mTamilNaduList.add("Select City");
                    mTamilNaduList.add("Chennai");
                    mTamilNaduList.add("Coimbatore");
                    mTamilNaduList.add("Madurai");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, mTamilNaduList);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    mSpinnerCity.setAdapter(dataAdapter2);
                }
                if(SpinnerState.contentEquals("Uttar Pradesh")) {
                    List<String> mUttarPradeshList = new ArrayList<String>();
                    mUttarPradeshList.add("Select City");
                    mUttarPradeshList.add("Lucknow");
                    mUttarPradeshList.add("Agra");
                    mUttarPradeshList.add("Kanpur");
                    ArrayAdapter<String> dataAdapter2 = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_spinner_item, mUttarPradeshList);
                    dataAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    dataAdapter2.notifyDataSetChanged();
                    mSpinnerCity.setAdapter(dataAdapter2);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });

        mSpinnerCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int arg2, long arg3) {


            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });


    }
    @OnClick(R.id.ButtonRegister)
    public void mRegister() {

        phoneNumber=mTextInputLastMobileNumber.getEditText().getText().toString().trim();

       if(!validateusername()|!validatelastname()|!validateEmail()|!validatemobilenumber()|!validatepassword()|!validateConfirmaPassword()){


       }
       else {
           Intent intent=new Intent(MainActivity.this,HomePageActivity.class);
           name = mTextInputFirstName.getEditText().getText().toString().trim();

           mail=mTextInputEmail.getEditText().getText().toString().trim();
           intent.putExtra("UserName",name);

           startActivity(intent);
       }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private boolean validateusername() {
        String username = mTextInputFirstName.getEditText().getText().toString().trim();
        if (username.isEmpty()) {
            mTextInputFirstName.setError("Field can not be empty");
            return false;
        } else {
            mTextInputFirstName.setError(null);
            return true;
        }
    }

    private boolean validatelastname() {
        String username = mTextInputLastName.getEditText().getText().toString().trim();
        if (username.isEmpty()) {
            mTextInputLastName.setError("Field can not be empty");
            return false;
        } else {
            mTextInputLastName.setError(null);
            return true;
        }
    }
    private boolean validatemobilenumber() {
        String mobileNumber = mTextInputLastMobileNumber.getEditText().getText().toString().trim();
        if (mobileNumber.isEmpty()) {
            mTextInputLastMobileNumber.setError("Field can not be empty");
            return false;
        }
        else if (mTextInputLastMobileNumber.equals("") || mTextInputLastMobileNumber.equals(null)||mobileNumber.length()<10 || mobileNumber.length()>10) {
            mTextInputLastMobileNumber.setError("Enter  10 digit mobile number");
            return false;
        }else {
            mTextInputLastMobileNumber.setError(null);
            return true;
        }
    }
    private boolean validatepassword() {
        String password = mTextInputPassword.getEditText().getText().toString().trim();
        if (password.isEmpty()) {
            mTextInputPassword.setError("Field can not be empty");
            return false;
        } else {
            mTextInputPassword.setError(null);
            return true;
        }
    }
    private boolean validateEmail() {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        String email = mTextInputEmail.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            mTextInputEmail.setError("Field can not be empty");
            return false;
        }
        else if(mTextInputEmail.equals("") || mTextInputEmail.equals(null)||!email.matches(emailPattern)) {
            mTextInputEmail.setError("Please enter right email Address");
            return false;

        } else {
            mTextInputEmail.setError(null);
            return true;
        }
    }
    private boolean validateConfirmaPassword() {
        String confirmpassword = mTextInputConfirmPassword.getEditText().getText().toString().trim();
        String password=mTextInputPassword.getEditText().getText().toString().trim();
        if (confirmpassword.isEmpty()) {
            mTextInputConfirmPassword.setError("Field can not be empty");
            return false;
        }
        else if(!confirmpassword.equals(password)){
            mTextInputConfirmPassword.setError("Password not matching");
            return false;
        }  else {
            mTextInputConfirmPassword.setError(null);
            return true;
        }
    }

    }






