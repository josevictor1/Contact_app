package com.example.jose.contactsstudents.Model.Reciver;

/**
 * Created by jose on 05/11/2017.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;
import com.example.jose.contactsstudents.Model.Classes.Contato;
import com.example.jose.contactsstudents.Model.DAO.ContatoDAO;

import java.util.List;



public class PhoneReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {

        try {
            // TELEPHONY MANAGER class object to register one listner
            TelephonyManager tmgr = (TelephonyManager) context
                    .getSystemService(Context.TELEPHONY_SERVICE);

            //Create Listner
            MyPhoneStateListener PhoneListener = new MyPhoneStateListener(context);

            // Register listener for LISTEN_CALL_STATE
            tmgr.listen(PhoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        } catch (Exception e) {
            Log.e("Phone Receive Error", " " + e);
        }

    }

    private class MyPhoneStateListener extends PhoneStateListener {

        Context pcontext;
        List<Contato> contatos;

        public MyPhoneStateListener(Context context){
            pcontext = context;
            ContatoDAO contatoDAO = new ContatoDAO(pcontext);
            contatos = contatoDAO.fetchContato();
        }

        public void onCallStateChanged(int state, String incomingNumber) {

            String msg = "Um aluno esta ligando: ";
            int duration = Toast.LENGTH_LONG;
            Log.d("MyPhoneListener",state+"   incoming no:"+incomingNumber);

            if (state == 1) {
                for (int i = 0; i < contatos.size(); i++) {
                    if (incomingNumber.equals(contatos.get(i).getTelefone())){
                        Toast toast = Toast.makeText(pcontext, msg+contatos.get(i).getNome(), duration);
                        toast.show();
                    }
                }


            }
        }
    }
}
