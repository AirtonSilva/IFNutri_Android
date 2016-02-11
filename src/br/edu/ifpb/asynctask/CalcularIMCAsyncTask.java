package br.edu.ifpb.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;

import br.edu.ifpb.util.HTTPService;
import br.edu.ifpb.util.Response;


public class CalcularIMCAsyncTask extends AsyncTask<JSONObject, Void, Response>{

    Context context;

    public CalcularIMCAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected Response doInBackground(JSONObject... valores) {

        Response response = null;

        try {

            response = HTTPService.sendJSONPostResquest("calcularIMC", valores[0]);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String valor = json.getString("valor");
                Log.i("NotificationWearApp", "Nome: " + valor);
                Toast.makeText(context, valor, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}