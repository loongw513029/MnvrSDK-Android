package com.sztvis.mnvrlibrary.listener;

import com.sztvis.mnvrlibrary.Msdk;

/**
 * Created by Administrator on 2019/8/1.
 */

public interface OnConnectLinstener {

    public void OnConnectFaild(int errorCode,String msg);

    public void onConnectSuccess();
}
