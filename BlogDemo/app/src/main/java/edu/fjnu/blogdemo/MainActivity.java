package edu.fjnu.blogdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.DisplayMetrics;


public class MainActivity extends AppCompatActivity {
    CustomDrawableView customDrawableView;
    ConstraintLayout constraintLayout;

    private SensorManager sensorManager;
    private Sensor sensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics();
        customDrawableView = new CustomDrawableView(this,metrics.widthPixels,metrics.heightPixels);
        constraintLayout = new ConstraintLayout(this);
        constraintLayout.addView(customDrawableView);
        setContentView(constraintLayout);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                double x = event.values[0];
                double y = event.values[1];
                double z = event.values[2];
                customDrawableView.speed_x += -x;
                customDrawableView.speed_y += y;
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        },sensor,SensorManager.SENSOR_DELAY_NORMAL);
        MoveThread mt = new MoveThread(customDrawableView);
        mt.start();
    }
}
