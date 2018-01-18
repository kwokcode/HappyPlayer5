package com.zlm.hp.receiver;

import android.content.ComponentName;
import android.content.Context;
import android.media.AudioManager;

import base.utils.LoggerUtil;

/**
 * 耳机线控
 * Created by zhangliangming on 2017/9/1.
 */

public class PhoneReceiver {
    /**
     *
     */
    private LoggerUtil logger;

    private Context mContext;
    private AudioManager mAudioManager;
    private ComponentName mRemoteControlResponder;
    private MyPhoneReceiver mPhoneBroadcastReceiver;


    public PhoneReceiver(Context context) {
        this.mContext = context;
        logger = LoggerUtil.getZhangLogger(context);
        mPhoneBroadcastReceiver = new MyPhoneReceiver(context);

        //
        mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        mRemoteControlResponder = new ComponentName(context.getPackageName(), mPhoneBroadcastReceiver.getClass().getName());
    }

    /**
     * 注册广播
     *
     * @param context
     */
    public void registerReceiver(Context context) {
        mAudioManager
                .registerMediaButtonEventReceiver(mRemoteControlResponder);
    }

    /**
     * 取消注册广播
     */
    public void unregisterReceiver(Context context) {
        mAudioManager
                .unregisterMediaButtonEventReceiver(mRemoteControlResponder);
    }
}
