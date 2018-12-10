package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile
{
    public static void main(String[] args) throws IOException
    {
        String filename = "110701.json";
//        System.out.println(readJsonFile(filename));

          extracturl.createFile("json-extract",readJsonFile(filename));
//        JSON_writer(filename);


    }

    public static void JSON_writer(String filename){

        BufferedReader br = null;
        JSONParser parser = new JSONParser();
//        JSONObject json = new JSONObject();

        try {

            String sCurrentLine;
            br = new BufferedReader(new FileReader(filename));
            int i=1;
            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println("Record:\t" + sCurrentLine);
                String message;
                JSONObject json = new JSONObject();
                String key;

                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;

                    JSONArray array = new JSONArray();
                    JSONObject item = new JSONObject();

                    key = "V" + Integer.toString(i);

                    String url = (String) jsonObject.get("url");
                    String content = (String) jsonObject.get("content");

                    item.put("url:",url);
                    item.put("content:",content);
                    array.add(item);

                    json.put(key,array);


                    i=i+1;
                    System.out.println(json);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
//
//            // Create a new FileWriter object and write JSONObeject to file
//            FileWriter fileWriter = new FileWriter("/Users/beidan/Spider/writejson.json");
//            fileWriter.write(json.toString());
//            fileWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }

    }

    /** Process the malformat JSON file line by line, by adding a KEY each Line */
    public static List<String> readJsonFile(String filename) {
        BufferedReader br = null;
        JSONParser parser = new JSONParser();
        List<String> results = new ArrayList<>();
//        Object[] fresults = new Object[0];

        try {

            String sCurrentLine;
            br = new BufferedReader(new FileReader(filename));
           int i=1;
            while ((sCurrentLine = br.readLine()) != null) {
//                System.out.println("Record:\t" + sCurrentLine);
                String message;
                JSONObject json = new JSONObject();
                String key;
                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;

                    JSONArray array = new JSONArray();
                    JSONObject item = new JSONObject();

                    key = "V" + Integer.toString(i);

                    String url = (String) jsonObject.get("url");
                    String content = (String) jsonObject.get("content");

                    item.put("url:",url);
                    item.put("content:",content);
                    array.add(item);

                    json.put(key,array);
                    message = json.toString();

                    i=i+1;

                    results.add(message);
                    System.out.println(json);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();

            }
        }
        return results;
    }
}


