package com.example.eventos;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.example.eventos.Comun.guardarIdRegistro;

/**
 * Created by DTIC-Dir on 15/03/2018.
 */

public class EventosFCMInstanceIDService extends FirebaseInstanceIdService {
    URL url = null;
    HttpURLConnection conexion;
    @Override
    public void onTokenRefresh() {
        String idPush;
        idPush = FirebaseInstanceId.getInstance().getToken();
        guardarIdRegistro(getApplicationContext(), idPush);
        Log.i("el token",idPush);
        try {
            url=new URL("http://franz.usfx.bo/mensajeria/registrar.php?iddevice="+idPush);
            conexion = (HttpURLConnection) url.openConnection();
            if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {

                Log.i("Resp","Registro en BD");

            } else {

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
