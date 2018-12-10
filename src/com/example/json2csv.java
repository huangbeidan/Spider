package com.example;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class json2csv {

    public static String Json2Csv(String json) throws JSONException {

        org.json.JSONArray jsonArray = new JSONArray(json);
        String csv = CDL.toString(jsonArray);
        return csv;
    }

    public static void writejsontxt2csv(String filename)throws IOException {
        List<String> urls = new ArrayList<String>();
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;

        File newpath = new File("/Users/beidan/Spider/json22csv.csv");
        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter(newpath);
        bw = new BufferedWriter(fw);

       try {
           while ((line = br.readLine()) != null) {
               // process the line.

               try {
                   bw.write(line);
                   bw.newLine();
                   System.out.println("Done!");
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }
       }
       catch (IOException ex){
           }

            finally
            {
                try{
                    if (bw != null) bw.close();
                    if (fw !=null) fw.close();
                } catch (IOException ex){
                    ex.printStackTrace();
                }
            }






        }






    public static void main(String[] args) throws IOException {
//
//        String after = Json2Csv(json);
//        File filename = new File("/Users/beidan/Spider/json22csv.csv");
//        BufferedWriter bw = null;
//        FileWriter fw = null;
//
//        try{
//            String json =  "{\"V1\" :[{\"url:\":\"http:\\/\\/cloud.connect.scpr.org\\/kpcc_sub\",\"content:\":\"KPCC Newsletter Sign-up\\nTell us a little about yourself.\\nEmail Address\\n*\\nPostal Code\\nWhich newsletters would you like to subscribe to?\\nThe Frame\\nThe Frame Newsletter is movies, music, TV, arts and entertainment, straight from Southern California in your email inbox weekly.\\nKPCC Insider\\nInside information about your favorite programs, community event highlights, and exclusive benefits for members like you.\\nKPCC Breaking News\\nWhenever major news breaks on-air or on KPCC.org, we'll send you email alerts to connect you to news that's important to you.\\nKPCC In Person\\nStay up to date with the latest information about our events.\\nThe Short List\\nWhether you have 30 seconds to spare or 30 minutes to explore\\u2014 The Short List allows you catch up on the news. It's a snapshot of stories from KPCC and around the web that our staff hand selects and summarizes for you.\\nSubscribe\\nYou must be 13 or older to submit any information to Southern California Public Radio. The personally identifying information you provide will not be sold, shared, or used for purposes other than to communicate with you about Southern California Public Radio programs and activities. See SCPR Terms of Use and Privacy .\\n\"}]}";
//
//            fw = new FileWriter(filename);
//            bw = new BufferedWriter(fw);
//            bw.write(json);
//
//            System.out.println("Done!");
//        } catch (IOException e){
//            e.printStackTrace();
//        } finally {
//            try{
//                if (bw != null) bw.close();
//                if (fw !=null) fw.close();
//            } catch (IOException ex){
//                ex.printStackTrace();
//            }
//        }
        writejsontxt2csv("json-extract-1114.txt");




//
//        FileUtils.writeStringToFile(filename, json,encoding,false);
    }




}
