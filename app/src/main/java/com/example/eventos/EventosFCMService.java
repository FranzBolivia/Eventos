package com.example.eventos;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.example.eventos.Comun.mostrarDialogo;

/**
 * Created by DTIC-Dir on 15/03/2018.
 */

public class EventosFCMService extends FirebaseMessagingService {

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {
            String idevento="";
            idevento =remoteMessage.getData().get("evento");
            String evento = "";
            evento = "Evento: " + remoteMessage.getData().get("evento") + "\n";
            evento = evento + "Día: " + remoteMessage.getData().get("dia") + "\n";
            evento = evento + "Ciudadela: " + remoteMessage.getData().get("ciudad") + "\n";
            evento = evento + "Comentario: " + remoteMessage.getData().get("comentario");
            mostrarDialogo(getApplicationContext(), evento,idevento);
        } else {
            if (remoteMessage.getNotification() != null) {
                mostrarDialogo(getApplicationContext(), remoteMessage.getNotification().getBody(),null);
            }
        }
    }


}
