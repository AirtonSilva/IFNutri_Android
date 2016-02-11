package br.edu.ifpb.listener;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import br.edu.ifpb.R;
import br.edu.ifpb.asynctask.CalcularIMCAsyncTask;
import br.edu.ifpb.asynctask.LoginAs;

/**
 * Created by Rhavy on 02/02/2016.
 */
public class CalcularIMCListener implements View.OnClickListener {

    @Override
    public void onClick(View v) {

        // Calcular o IMC.
        Log.i("NotificationWearApp", "Clique no botão da AsyncTask");

        JSONObject geral = new JSONObject();

        try {
            // Peso
            EditText pesoEditText = (EditText) v.findViewById(R.id.pesoEditText);
            String peso = pesoEditText.getText().toString();
            geral.put("peso", peso);

            // Altura
            EditText alturaEditText = (EditText) v.findViewById(R.id.alturaEditText);
            String altura = alturaEditText.getText().toString();
            geral.put("altura", altura);

            CalcularIMCAsyncTask calcularIMCAsyncTask = new CalcularIMCAsyncTask(v.getContext());
            calcularIMCAsyncTask.execute(geral);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}