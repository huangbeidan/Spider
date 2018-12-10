package com.example;
import com.example.HttpTest;

import javax.imageio.IIOException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.io.BufferedReader;



public class GoogleCSErequest {

    public static void main(String[] args) throws IOException {
//        List<String> seeds = GETgenerator.readurl("urls.txt");
//        String[] urls = seeds.toArray(new String[0]);
//
          List<String> seeds = GETgenerator.GETseeds(GETgenerator.readurl("rawurl.txt"));

        for (String url:seeds){
            String json = HttpTest.getHttpResult(url);
            Random rand = new Random();
            int i = rand.nextInt(100)+1;
            String name = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

            OutJson.createJsonFile(json,"/Users/beidan/Spider/results",name);
        }

    }



}
