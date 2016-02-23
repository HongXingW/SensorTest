package com.example.sensortest;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements SensorEventListener{

	private SensorManager sensorManager;
	EditText orientation,magnetic,temperature,light,pressure;
	private int flag = 1;
	float x=0,y=0,z=0;

	Button chartBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		orientation = (EditText)findViewById(R.id.orientation);
		magnetic = (EditText)findViewById(R.id.magnetic);
		temperature = (EditText)findViewById(R.id.temperature);
		light = (EditText)findViewById(R.id.light);
		pressure = (EditText)findViewById(R.id.pressure);

		sensorManager= (SensorManager)getSystemService(SENSOR_SERVICE);

		chartBtn = (Button)findViewById(R.id.chart);
		chartBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,ChartActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	protected void onResume() {
		// TODO 自动生成的方法存根
		super.onResume();
		//为系统的方向传感器注册监听器
		sensorManager.registerListener(this, sensorManager.
				getDefaultSensor(Sensor.TYPE_ACCELEROMETER),sensorManager.SENSOR_DELAY_GAME);
		//为系统的磁场传感器注册监听器
		sensorManager.registerListener(this, sensorManager.
				getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),sensorManager.SENSOR_DELAY_GAME);
		//为系统的温度传感器注册监听器
		sensorManager.registerListener(this, sensorManager.
				getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE),sensorManager.SENSOR_DELAY_GAME);
		//为系统的光强传感器注册监听器
		sensorManager.registerListener(this, sensorManager.
				getDefaultSensor(Sensor.TYPE_LIGHT),sensorManager.SENSOR_DELAY_GAME);
		//为系统的压力传感器注册监听器
		sensorManager.registerListener(this, sensorManager.
				getDefaultSensor(Sensor.TYPE_PRESSURE),sensorManager.SENSOR_DELAY_GAME);
	}
	@Override
	protected void onStop() {
		// TODO 自动生成的方法存根
		//程序退出时取消注册传感器监听器
		sensorManager.unregisterListener(this);
		super.onStop();
	}
	@Override
	protected void onPause() {
		// TODO 自动生成的方法存根
		//程序暂停时取消注册传感器监听器
		sensorManager.unregisterListener(this);
		super.onPause();
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO 自动生成的方法存根
		float[] values = event.values;
		//获取触发event的传感器类型
		int sensorType = event.sensor.getType();
		StringBuilder sb = null;

		switch(sensorType){
			case Sensor.TYPE_ACCELEROMETER:
				sb = new StringBuilder();

				float detaX=0,detaY=0,detaZ=0;
				if(flag == 1){
					x = values[0];
					y = values[1];
					z = values[2];

					flag = 0;
					Log.d("-------","fuck"+x+"   "+y+"   "+z);
				}else{
					detaX = Math.abs(values[0]-x);
					detaY = Math.abs(values[1]-y);
					detaZ = Math.abs(values[2]-z);
				}

				sb.append("x轴方向的变化");
				sb.append(detaX);
				sb.append("\ny轴方向的变化");
				sb.append(detaY);
				sb.append("\nz轴方向的变化");
				sb.append(detaZ);
				orientation.setText(sb);
				break;
			case Sensor.TYPE_MAGNETIC_FIELD:
				sb = new StringBuilder();
				sb.append("x方向上的角度");
				sb.append(values[0]);
				sb.append("\ny方向上的角度");
				sb.append(values[1]);
				sb.append("\nz方向上的角度");
				sb.append(values[2]);
				magnetic.setText(sb);
				break;
			case Sensor.TYPE_AMBIENT_TEMPERATURE:
				sb = new StringBuilder();
				sb.append("当前温度为");
				sb.append(values[0]);
				temperature.setText(sb);
				break;
			case Sensor.TYPE_LIGHT:
				sb = new StringBuilder();
				sb.append("当前光强为");
				sb.append(values[0]);
				light.setText(sb);
				break;
			case Sensor.TYPE_PRESSURE:
				sb = new StringBuilder();
				sb.append("当前压力为");
				sb.append(values[0]);
				pressure.setText(sb);
				break;
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自动生成的方法存根

	}

}
