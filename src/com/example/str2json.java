package com.example;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class str2json {

    public static void main(String[] args) throws IOException{
       strtojson("json-extract-1114.txt");
    }




    public static JSONObject strtojson(String filename) throws IOException {
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();

        try{
            Reader reader = new FileReader(filename);
            json = (JSONObject) parser.parse(reader);
            String url = (String) json.get("V1");
            System.out.println(url);


        }
        catch(IOException e){

        }
        catch (ParseException e){

        }
        return json;

    }

}
