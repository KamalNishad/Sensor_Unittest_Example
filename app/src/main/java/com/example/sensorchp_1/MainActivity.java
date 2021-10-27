package com.example.sensorchp_1;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String mUid;
    private String mPassword;
    private EditText username_edt,password_edt;
    private String TAG = "MainActivity";
    private Button sumbit_btn;
    private TextInputLayout username_txtinput,userpassword_txtinput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username_edt = findViewById(R.id.username_edt);
        username_txtinput = findViewById(R.id.username_txtinput);
        password_edt = findViewById(R.id.password_edt);
        userpassword_txtinput = findViewById(R.id.userpassword_txtinput);
        sumbit_btn = findViewById(R.id.sumbit_btn);

        sumbit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validateUsername() && validatePassword()){
                    Toast.makeText(MainActivity.this, "SuccessFull", Toast.LENGTH_SHORT).show();
                }else { }
            }
        });
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private boolean validateUsername()
    {
        if (username_edt.getText().toString().trim().isEmpty()) {
            username_txtinput.setError(getString(R.string.err_msg_username));
            requestFocus(username_txtinput);
            return false;
        } else {
            username_txtinput.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validatePassword(){
        if (password_edt.getText().toString().trim().isEmpty()) {
            userpassword_txtinput.setError(getString(R.string.err_msg_userPasswprd));
            requestFocus(userpassword_txtinput);
            return false;
        } else {
            userpassword_txtinput.setErrorEnabled(false);
        }
        return true;
    }
}