package com.example.jose.contactsstudents.Control.Helper;

/**
 * Created by jose on 05/11/2017.
 */

import android.widget.TextView;

import com.example.jose.contactsstudents.Control.Activity.ContactDisplayActivity;
import com.example.jose.contactsstudents.Model.Classes.Contato;
import com.example.jose.contactsstudents.R;



public class ContactDisplayHelper {
    private Contato contato;
    private TextView nameField;
    private TextView addressField;
    private TextView phoneNumberField;
    private TextView siteField;
    private TextView emailField;

    public ContactDisplayHelper(ContactDisplayActivity activity){
        addressField = (TextView) activity.findViewById(R.id.contact_display_address);
        phoneNumberField = (TextView) activity.findViewById(R.id.contact_display_phone);
        siteField = (TextView) activity.findViewById(R.id.contact_display_site);
        emailField = (TextView) activity.findViewById(R.id.contact_display_email);
        contato = new Contato();
    }

    public Contato getContato(){
        contato.setNome(nameField.getText().toString());
        contato.setEndereco(addressField.getText().toString());
        contato.setTelefone(phoneNumberField.getText().toString());
        contato.setSite(siteField.getText().toString());
        contato.setEmail(emailField.getText().toString());

        return contato;
    }

    public void fillForm(Contato contato){
        addressField.setText(contato.getEndereco());
        phoneNumberField.setText(contato.getTelefone());
        siteField.setText(contato.getSite());
        emailField.setText(contato.getEmail());
        this.contato = contato;
    }
}
