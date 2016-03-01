package com.example.sensortest;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by whx on 2016/2/19.
 */
public class ChartActivity extends Activity{

    private GridChart gridchart;
    private LineChart linechart;
    private MsgReciver msgReciver;
    private Button stopBtn,startBtn;
    private Intent intent;

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what == 1){

                startService(intent);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_test);

        //initdata();

        initGridChart();
        initLineChart();

        intent = new Intent(this,DService.class);

        msgReciver = new MsgReciver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.whx.RECIVER");
        registerReceiver(msgReciver, intentFilter);


        stopBtn = (Button)findViewById(R.id.stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        startBtn = (Button)findViewById(R.id.start);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessageDelayed(1,10000);
            }
        });
    }
    private void initGridChart() {
        this.gridchart = (GridChart) findViewById(R.id.grid_chart);

        List<String> ytitle = new ArrayList<>();
        ytitle.add("241");
        ytitle.add("242");
        ytitle.add("243");
        ytitle.add("244");
        ytitle.add("245");
        List<String> xtitle = new ArrayList<>();
        xtitle.add("9:00");
        xtitle.add("10:00");
        xtitle.add("11:00");
        xtitle.add("13:00");
        xtitle.add("14:00");
        xtitle.add("15:00");

        gridchart.setAxisXColor(Color.LTGRAY);
        gridchart.setAxisYColor(Color.LTGRAY);
        gridchart.setBorderColor(Color.LTGRAY);
        gridchart.setLatitudeNum(5);
        gridchart.setLongitudeNum(6);
        gridchart.setDataQuadrantPaddingTop(5);
        gridchart.setDataQuadrantPaddingBottom(5);
        gridchart.setDataQuadrantPaddingLeft(5);
        gridchart.setDataQuadrantPaddingRight(5);
        gridchart.setAxisYTitleQuadrantWidth(50);
        gridchart.setAxisXTitleQuadrantHeight(20);
        gridchart.setAxisXPosition(GridChart.AXIS_X_POSITION_BOTTOM);
        gridchart.setAxisYPosition(GridChart.AXIS_Y_POSITION_RIGHT);
        gridchart.setLatitudeTitles(ytitle);
        gridchart.setLongitudeTitles(xtitle);
        gridchart.setLongitudeFontSize(14);
        gridchart.setLatitudeFontSize(14);
        gridchart.setLongitudeFontColor(Color.WHITE);
        gridchart.setLatitudeColor(Color.GRAY);
        gridchart.setLatitudeFontColor(Color.WHITE);
        gridchart.setLongitudeColor(Color.GRAY);
        gridchart.setDisplayLongitudeTitle(true);
        gridchart.setDisplayLatitudeTitle(true);
        gridchart.setDisplayLatitude(true);
        gridchart.setDisplayLongitude(true);
        gridchart.setCrossLinesColor(Color.BLUE);
        gridchart.setCrossLinesFontColor(Color.GREEN);
        gridchart.setBorderWidth(1);
        gridchart.setAxisWidth(1);
    }
    private void initLineChart() {
        this.linechart = (LineChart) findViewById(R.id.line_chart);

//        List<LineEntity<DateValueEntity>> lines = new ArrayList<>();
//
//        LineEntity<DateValueEntity> data = new LineEntity<>();
//        data.setTitle("MA");
//        data.setLineColor(Color.GREEN);
//        data.setLineData(initData());
//        lines.add(data);

        linechart.setAxisXColor(Color.LTGRAY);
        linechart.setAxisYColor(Color.LTGRAY);
        linechart.setBorderColor(Color.LTGRAY);
        linechart.setLongitudeFontSize(14);
        linechart.setLongitudeFontColor(Color.WHITE);
        linechart.setLatitudeColor(Color.GRAY);
        linechart.setLatitudeFontColor(Color.WHITE);
        linechart.setLongitudeColor(Color.GRAY);
        linechart.setMaxValue(280);
        linechart.setMinValue(240);
        linechart.setMaxPointNum(10);
        linechart.setDisplayLongitudeTitle(true);
        linechart.setDisplayLatitudeTitle(true);
        linechart.setDisplayLatitude(true);
        linechart.setDisplayLongitude(true);
        linechart.setLatitudeNum(5);
        linechart.setLongitudeNum(6);
        linechart.setDataQuadrantPaddingTop(5);
        linechart.setDataQuadrantPaddingBottom(5);
        linechart.setDataQuadrantPaddingLeft(5);
        linechart.setDataQuadrantPaddingRight(5);
        linechart.setAxisYTitleQuadrantWidth(50);
        linechart.setAxisXTitleQuadrantHeight(20);
        linechart.setAxisXPosition(GridChart.AXIS_X_POSITION_BOTTOM);
        linechart.setAxisYPosition(GridChart.AXIS_Y_POSITION_RIGHT);

        // 为chart1增加均线
        //linechart.setLinesData(lines);
    }
//    private List<DateValueEntity> initMA(int days) {
//
//        if (days < 2) {
//            return null;
//        }
//
//        List<DateValueEntity> MA5Values = new ArrayList<>();
//
//        float sum = 0;
//        float avg = 0;
//        for (int i = 0; i < this.data.size(); i++) {
//            float close = (float) ((DateValueEntity) data.get(i)).getClose();
//            if (i < days) {
//                sum = sum + close;
//                avg = sum / (i + 1f);
//            } else {
//                sum = sum + close
//                        - (float) ((DateValueEntity) data.get(i - days)).getClose();
//                avg = sum / days;
//            }
//            MA5Values.add(new DateValueEntity(avg, data.get(i).getDate()));
//        }
//
//        return MA5Values;
//    }
    
    private List<DateValueEntity> initData() {
        List<DateValueEntity> data = new ArrayList<>();
        
        data.add(new DateValueEntity(0, 20130424));
        data.add(new DateValueEntity(5, 20130425));
        data.add(new DateValueEntity(10, 20130426));
        data.add(new DateValueEntity(20, 20130502));
        data.add(new DateValueEntity(30, 20130503));
        data.add(new DateValueEntity(40, 20130506));
        data.add(new DateValueEntity(30, 20130507));
        data.add(new DateValueEntity(50, 20130508));
        data.add(new DateValueEntity(100, 20130509));
        data.add(new DateValueEntity(20, 20130510));
//        data.add(new DateValueEntity(50, 20130513));
//        data.add(new DateValueEntity(80, 20130514));
//        data.add(new DateValueEntity(90, 20130515));
//        data.add(new DateValueEntity(70, 20130516));
//        data.add(new DateValueEntity(200, 20130517));
//        data.add(new DateValueEntity(150, 20130520));
//        data.add(new DateValueEntity(180, 20130521));
//        data.add(new DateValueEntity(110, 20130522));
//        data.add(new DateValueEntity(100, 20130523));
//        data.add(new DateValueEntity(80, 20130524));
//        data.add(new DateValueEntity(60, 20130527));
//        data.add(new DateValueEntity(90, 20130528));
//        data.add(new DateValueEntity(100, 20130529));
//        data.add(new DateValueEntity(120, 20130530));
//        data.add(new DateValueEntity(130, 20130531));
//        data.add(new DateValueEntity(160, 20130603));
//        data.add(new DateValueEntity(200, 20130604));
//        data.add(new DateValueEntity(250, 20130605));
//        data.add(new DateValueEntity(200, 20130606));
//        data.add(new DateValueEntity(180, 20130607));
//        data.add(new DateValueEntity(170, 20130613));
//        data.add(new DateValueEntity(150, 20130614));
//        data.add(new DateValueEntity(130, 20130617));
//        data.add(new DateValueEntity(50, 20130618));
//        data.add(new DateValueEntity(30, 20130619));
//        data.add(new DateValueEntity(0, 20130620));


        return data;
    }

    public class MsgReciver extends BroadcastReceiver{

        public MsgReciver(){

        }
        @Override
        public void onReceive(Context context, Intent intent) {

            //List<DateValueEntity> sData = intent.getExtras();

            List<LineEntity<DateValueEntity>> lines = new ArrayList<>();

            LineEntity<DateValueEntity> dataX = new LineEntity<>();
            dataX.setTitle("X-A");
            dataX.setLineColor(Color.GREEN);
            dataX.setLineData(Work1.datas.get(0));
            lines.add(dataX);

            LineEntity<DateValueEntity> dataY = new LineEntity<>();
            dataY.setTitle("Y-A");
            dataY.setLineColor(Color.RED);
            dataY.setLineData(Work1.datas.get(1));
            lines.add(dataY);

            LineEntity<DateValueEntity> dataZ = new LineEntity<>();
            dataZ.setTitle("Z-A");
            dataZ.setLineColor(Color.BLUE);
            dataZ.setLineData(Work1.datas.get(2));
            lines.add(dataZ);

            linechart.setLinesData(lines);

            linechart.invalidate();

            for (int i = 0;i<Work1.datas.get(0).size();i++){
                Log.d("-----------",Work1.datas.get(0).get(i).getDate()+"->"+Work1.datas.get(0).get(i).getValue());
            }

        }
    }
    @Override
    protected void onDestroy() {

        Intent intent = new Intent(this,DService.class);
        stopService(intent);

        unregisterReceiver(msgReciver);
        Work.datas.clear();

        super.onDestroy();
    }
}
