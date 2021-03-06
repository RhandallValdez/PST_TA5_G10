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
                httpURLConnection.setDoOutput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("usuarioIngresado", "UTF-8")+"="+URLEncoder.encode(usuarioIngresado, "UTF-8")+"&"+URLEncoder.encode("contraIngresada", "UTF-8")+"="+URLEncoder.encode(contraIngresada, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();


                InputStream iStr = httpURLConnection.getInputStream();
                BufferedReader bR = new BufferedReader(new InputStreamReader(iStr,"UTF-8"));
                String resultado="";
                String line="";

                while((line = bR.readLine()) != null){
                    resultado += line + System.getProperty("line.separator") ;
                }
                bR.close();
                iStr.close();
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
        else if(type.equals("registrar")){
            try {
                String nombre = datos[0][2];
                String apellido = datos[0][3];
                String correo = datos[0][4];
                String celular = datos[0][5];
                String categoria = datos[0][6];
                String usuario = datos[0][7];
                String contrasena = datos[0][8];
                String SQL = nombre+","+apellido+","+correo+","+celular+","+categoria+","+usuario+","+contrasena;
                System.out.println(SQL);
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

                InputStream iStr = httpURLConnection.getInputStream();
                BufferedReader bR = new BufferedReader(new InputStreamReader(iStr,"UTF-8"));
                String resultado="";
                String line="";

                while((line = bR.readLine()) != null){
                    resultado += line + System.getProperty("line.separator") ;
                }
                bR.close();
                iStr.close();
                httpURLConnection.disconnect();

                totalResultadoSQL = new String[]{
                        resultado
                };

                httpURLConnection.disconnect();

            } catch (MalformedURLException e ) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("categoria")){
            try {
                String categoria = datos[0][2];

                String SQL = categoria;
                System.out.println(SQL);
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


                httpURLConnection.disconnect();//se te olvido desconectar la conexion a internet

            } catch (MalformedURLException e ) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return totalResultadoSQL;

    }
}
