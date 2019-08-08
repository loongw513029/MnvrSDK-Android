package com.sztvis.mnvrsdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.sztvis.mnvrlibrary.Msdk;
import com.sztvis.mnvrlibrary.domain.DeviceStatus;
import com.sztvis.mnvrlibrary.domain.GSensor;
import com.sztvis.mnvrlibrary.domain.GpsInfo;
import com.sztvis.mnvrlibrary.domain.HeartBeat;
import com.sztvis.mnvrlibrary.domain.IO;
import com.sztvis.mnvrlibrary.domain.NfcMsg;
import com.sztvis.mnvrlibrary.domain.Reply;
import com.sztvis.mnvrlibrary.domain.Rfid;
import com.sztvis.mnvrlibrary.domain.Sensor;
import com.sztvis.mnvrlibrary.domain.resp.ControlReplyResult;
import com.sztvis.mnvrlibrary.domain.resp.DeviceStatusResult;
import com.sztvis.mnvrlibrary.domain.resp.IoResult;
import com.sztvis.mnvrlibrary.domain.resp.ReplyStateResult;
import com.sztvis.mnvrlibrary.domain.resp.RespBase;
import com.sztvis.mnvrlibrary.domain.resp.RfidDistanceResult;
import com.sztvis.mnvrlibrary.listener.OnCommandResultListener;
import com.sztvis.mnvrlibrary.listener.OnConnectLinstener;
import com.sztvis.mnvrlibrary.listener.OnDataListener;

public class MainActivity extends AppCompatActivity {

    Msdk msdk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msdk = new Msdk("192.168.137.1",8001);
        msdk.init();
        msdk.setOnDataListener(new OnDataListener() {
            @Override
            public void OnHeartBeatMsgReceive(HeartBeat heartBeat) {
                Log.d("HeartBeat",JSON.toJSONString(heartBeat));
            }

            @Override
            public void OnGpsMsgReceive(GpsInfo gpsInfo) {
                Log.d("GpsInfo",JSON.toJSONString(gpsInfo));
            }

            @Override
            public void OnGsensorMsgReceive(GSensor gSensor) {
                Log.d("GSensor",JSON.toJSONString(gSensor));
            }

            @Override
            public void OnIoStateChange(IO io) {
                Log.d("IoState",JSON.toJSONString(io));
            }

            @Override
            public void OnReplyChange(Reply reply) {
                Log.d("Reply",JSON.toJSONString(reply));
            }

            @Override
            public void OnRfidMsgReceive(Rfid rfid) {
                Log.d("Rfid",JSON.toJSONString(rfid));
            }

            @Override
            public void OnDeviceStatusMsgReceive(DeviceStatus deviceStatus) {
                Log.d("DeviceStatus",JSON.toJSONString(deviceStatus));
            }

            @Override
            public void OnSensorMsgReceive(Sensor sensor) {
                Log.d("SensorAlarm",JSON.toJSONString(sensor));
            }

            @Override
            public void onNfcMsgReceive(NfcMsg nfcMsg) {
                Log.d("NfcMsg",JSON.toJSONString(nfcMsg));
            }
        });
        msdk.setOnConnectLinstener(new OnConnectLinstener() {
            @Override
            public void OnConnectFaild(int errorCode, String msg) {

            }

            @Override
            public void onConnectSuccess() {
                msdk.searchDeviceStatus();
                msdk.searchIOState();
                msdk.searchReplyState();
                msdk.searchRfidDistance();
            }
        });

        msdk.setOnCommandResultListener(new OnCommandResultListener() {
            @Override
            public void onRfidDistanceResult(RespBase result) {

            }

            @Override
            public void onSensorBindResult(RespBase result) {

            }

            @Override
            public void onSearchDeviceStatus(DeviceStatusResult result) {

            }

            @Override
            public void onSearchIoStatusResult(IoResult result) {

            }

            @Override
            public void onSearchRfidDistanceResult(RfidDistanceResult result) {

            }

            @Override
            public void onSearchReplyResult(ReplyStateResult result) {

            }

            @Override
            public void onControlLedResult(RespBase result) {

            }

            @Override
            public void onControlReplayResult(ControlReplyResult result) {

            }
        });
//        //search device status
          msdk.searchDeviceStatus();
//
//        //search io state
          msdk.searchIOState();
//
//        //search reply state
          msdk.searchReplyState();
//
//        //search rfid distance
          msdk.searchRfidDistance();
//
//        //control led (0: led went out 1:green 2:red 3:orange)
//        msdk.controlLed(int status);
//
//        //control reply (no: reply no   state:1 open  0 close)
//        msdk.controlReply(int no,int state);
//
//        //control buzzer
//        msdk.controlBuzzer();
//
//        //bind sensor
//        //type:
//        //64: Infra-red 65：sos button 66:temperature and humidity sensor 68:smoke sensor 77:door sensor  7:wireless alarm sensor
//        //val:
//        //sensor id
//        msdk.setSensorBind(int type,short val);
//
//
//        // set rfid distane level (1-4)
//        msdk.setRfidDistance(int level);
    }
}
