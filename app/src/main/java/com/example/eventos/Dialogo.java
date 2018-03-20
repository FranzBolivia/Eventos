package com.example.eventos;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by DTIC-Dir on 15/03/2018.
 */

public class Dialogo extends AppCompatActivity {
    Bundle extras = null;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        extras = getIntent().getExtras();
        if (getIntent().hasExtra("mensaje")) {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Mensaje:");
            alertDialog.setMessage(extras.getString("mensaje"));
//            Log.i("Mostramos evento",extras.getString("idmensaje"));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "CERRAR", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Context context= getApplicationContext();
                    Intent intent = new Intent (context,EventoDetalles.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intent.putExtra("evento",extras.getString("idmensaje"));
                //   Log.i("Enviasmos evento",extras.getString("idmensaje"));
                    context.startActivity(intent);
                    finish();
                }
            });
            alertDialog.show();
            extras.remove("mensaje");
        }
    }
}