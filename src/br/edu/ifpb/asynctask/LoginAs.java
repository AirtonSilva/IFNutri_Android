package br.edu.ifpb.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;

import br.edu.ifpb.util.HTTPService;
import br.edu.ifpb.util.Response;


public class LoginAs extends AsyncTask<String, Void, Response>{

    Context context;

    public LoginAs(Context activity) {

        this.context = activity;
    }

    @Override
    protected void onPreExecute() {

        Log.i("NotificationWearApp", "OnPreExecute");
    }

    @Override
    protected Response doInBackground(String... valores) {

        Log.i("NotificationWearApp", "doInBackground: " + valores[0]);

        Response response = null;
        HttpURLConnection connection = null;

        try {

            connection = HTTPService.sendGetRequest("servicoservlet");

            int statusCodeHttp = connection.getResponseCode();
            String contentValue = HTTPService.getHttpContent(connection);

            response = new Response(statusCodeHttp, contentValue);

        } catch (MalformedURLException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } catch (IOException ex) {

            Log.e("NotificationWearApp","MalformedURLException");

        } finally {

            connection.disconnect();
        }

        return response;
    }

    @Override
    protected void onPostExecute(Response response) {

        try {

            int status = response.getStatusCodeHttp();

            if (status == HttpURLConnection.HTTP_OK) {

                JSONObject json = new JSONObject(response.getContentValue());

                String nome = json.getString("nome");
                Log.i("NotificationWearApp", "Nome: " + nome);
                Toast.makeText(context, nome, Toast.LENGTH_LONG).show();
            }

        } catch (JSONException e) {

            Log.e("NotificationWearApp", "JSONException: " + e);
        }
    }
}