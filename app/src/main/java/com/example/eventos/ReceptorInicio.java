package com.example.eventos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by DTIC-Dir on 16/03/2018.
 */

public class ReceptorInicio extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        context.startService(new Intent(context, EventosFCMService.class));
    }
}
