package com.example.myapplication;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    SensorManager sm;
    Sensor mysensor;
    TextView  outputX, outputY;
    LinearLayout ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        outputX = findViewById(R.id.textView);
        outputY = findViewById(R.id.textView2);
                ln = findViewById(R.id.mylayout);

        sm =(SensorManager)getSystemService(SENSOR_SERVICE);
        mysensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sm.registerListener(this,mysensor,sm.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float [] values = event.values;
        float accX = values[0];
        float accY = values[1];



        outputX.setText("X: " + accX);
        outputY.setText("Y: " + accY);


        if (accX>2) {ln.setBackgroundResource(R.mipmap.ic_g63);};
        if (accY>9 && accX == 0) {ln.setBackgroundResource(R.mipmap.ic_glc);};
        if (accY<-1) {ln.setBackgroundResource(R.mipmap.ic_ml350);};
        if (accX<-1) {ln.setBackgroundResource(R.mipmap.ic_slk63);};

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}

