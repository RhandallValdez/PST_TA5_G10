package com.example.amst10;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class AsyncQuery extends AsyncTask<String[],Void,String[]> {
    @Override
    protected String[] doInBackground(String[]... datos) {
        String[] totalResultadoSQL = null;
        String type = datos[0][0];
        String login_url = datos[0][1];

        if(type.equals("login")){
            try {
                String usuarioIngresado = datos[0][2];
                String contraIngresada = datos[0][3];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String mandarUsuario = URLEncoder.encode("usuarioIngresado","UTF-8")+"="+URLEncoder.encode(usuarioIngresado,"UTF-8");
                bufferedWriter.write(mandarUsuario);
                bufferedWriter.write("&");
                String mandarContra = URLEncoder.encode("contraIngresada","UTF-8")+"="+URLEncoder.encode(contraIngresada,"UTF-8");
                bufferedWriter.write(mandarContra);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream iStr = httpURLConnection.getInputStream();
                BufferedReader bR = new BufferedReader(new InputStreamReader(iStr,"UTF-8"));
                String resultado="";
                String line="";
                String infoObtenida = resultado.split("\n")[0];

                while((line = bR.readLine()) != null){
                    resultado += line + System.getProperty("line.separator") ;
                }
                bR.close();
                iStr.close();
                httpURLConnection.disconnect();

                totalResultadoSQL = new String[]{
                        infoObtenida
                };

            } catch (MalformedURLException e ) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("query")){
            try {
                String tabla = datos[0][2];
                String condicion = datos[0][3];
                String SQL = tabla+","+condicion;
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String tablaPost = URLEncoder.encode("SQL","UTF-8")+"="+URLEncoder.encode(SQL,"UTF-8");
                bufferedWriter.write(tablaPost);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String resultado="";
                String line="";

                while((line = bufferedReader.readLine()) != null){
                    resultado += line + System.getProperty("line.separator");
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                totalResultadoSQL = new String[]{
                        resultado
                };

            } catch (MalformedURLException e ) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return totalResultadoSQL;

    }
}
