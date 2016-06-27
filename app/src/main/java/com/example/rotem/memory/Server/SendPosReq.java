package com.example.rotem.memory.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Rotem on 10/05/2016.
 */
public class SendPosReq implements Runnable {
    String url="https://memogame1.herokuapp.com/api/newUser";
    String url_Parameters ;

    public SendPosReq(String url_Parameters) {
        this.url_Parameters = url_Parameters;
    }



    @Override
    public void run() {
        try {
            URL obj = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Java");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            String urlParameters= url_Parameters;
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line=reader.readLine())!=null){
                builder.append(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
