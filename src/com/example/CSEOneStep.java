package com.example;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.example.ReadJsonFile;

import static com.example.extracturl.getalllinks;
import static com.example.json2csv.writejsontxt2csv;
import static com.example.str2json.strtojson;

import java.util.Date;

public class CSEOneStep {

    public static void main(String[] args) throws IOException {

        /** This will read the rawurl.txt in the directory and return result.txt (urls extracted from Google CSE */

         //Step one: send requests and return JSON files and save them into local disk
         //Delete the existing json files in the directory first
        File directory = new File("/Users/beidan/Spider/results");
        File[] files = directory.listFiles();
        int j=0;
        for (File f : files)
        {
                f.delete();
                j+=1;
                String message= String.format("Successfully delete %d files",j);
                System.out.println(message);
        }

//
//         //MODIFY the get parameters at GETgenerator
        List<String> seeds = GETgenerator.GETseeds(GETgenerator.readurl("rawurl.txt"));

        for (String url:seeds){
            String json = HttpTest.getHttpResult(url);
            Random rand = new Random();
            int i = rand.nextInt(100)+1;
            String name = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
            OutJson.createJsonFile(json,"/Users/beidan/Spider/results",name);
        }
////
////
////        // Step two: extract all the links from all the JSON files
        String dir = "/Users/beidan/Spider/results/";
        List<String> alllinks = getalllinks(dir);

        // Step 2.1 Clean-up to filter out the unwanted urls
        // This step is for SOLR, if it is for spider_news, skip it!
//        List<String> cleaned_links = extracturl.URL_filter("result.txt");
//        extracturl.createFile("final_urls",cleaned_links);

////
//        // Step three: write the file to local disk
        // delete the .DS_store first: find . -name ".DS_Store" -delete (in directory)
        extracturl.createFile("result",alllinks);

//         Step four: nutch craw result, do it in terminal, remember to point the path to spider
//         bin/crawl -i -s /Users/beidan/Spider/final_urls.txt 10Facts/  1
//         Step five: Convert the index result into Json in terminal
//         cd solr-import-export-json
//         ./run.sh -s http://localhost:8983/solr/nutch -a export -o /Users/beidan/Spider/111401.json --skipFields tstamp,anchor,digest,boost,id,_version_,search

        // Step six: Cleanup the Json file
//        DateFormat dateFormat = new SimpleDateFormat("yyMMddHHmmssZ");
//        Date date = new Date();

//        String json_namer = String.format("%s",dateFormat.format(date));
//        String indexname = "/Users/beidan/apache-nutch-1.15/data/solrindexjson/111801.json";
//        extracturl.createFile("json-extract-1118",ReadJsonFile.readJsonFile(indexname));

         //Step seven: Convert the Json file into CSV for topic models
//        strtojson("json-extract-1118.txt");

         //Step eight: Write Json to csv
//        writejsontxt2csv("json-extract-1118.txt");
//

    }


}
