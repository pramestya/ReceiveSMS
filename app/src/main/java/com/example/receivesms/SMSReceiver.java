package com.example.receivesms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        Bundle bundle = intent.getExtras();
        SmsMessage[] msgs = null;
        String str = "SMS from";
        if(bundle != null){
            msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            for (int i = 0 ; i < msgs.length ; i++){
                str += msgs[i].getMessageBody().toString();
            }
            Toast.makeText(context,str,Toast.LENGTH_SHORT).show();
            Log.d("SMSReceiver", str);
        }
    }
}
