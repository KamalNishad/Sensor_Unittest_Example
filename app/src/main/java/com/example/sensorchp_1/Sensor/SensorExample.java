package com.example.sensorchp_1.Sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sensorchp_1.R;
import com.google.gson.Gson;

import java.util.List;

public class SensorExample extends AppCompatActivity {

    SensorManager sensorManager = null;
    TextView sensor_tv;
    List list;

    SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float[] value = event.values;
            Log.d("aaaaaaaaaaaaaa","Sens:"+new Gson().toJson(event));
            Log.d("aaaaaaaaaaaaaa","Sensvalue:"+new Gson().toJson(value));
            //sensor_tv.setText("X:"+value[0]+"\ny:"+value[0]+"\nz:"+value[0]);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        list=sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER);

        if (list.size()>0){
            sensorManager.registerListener(sensorEventListener,(Sensor) list.get(0),SensorManager.SENSOR_DELAY_NORMAL);
        }else {
            Toast.makeText(this, "Error: No Accelerometer.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onStop() {
        if (list.size()>0){
            sensorManager.unregisterListener(sensorEventListener);
        }
        super.onStop();
    }
}
