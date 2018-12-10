package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GETgenerator {

    // read the url list file line by line
    public static List<String> readurl(String filename)throws IOException {
        List<String> urls = new ArrayList<String>();
       BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                urls.add(line);
            }

      return urls;
    }

    // Generate the request url
    public static List<String> GETseeds(List<String> urls){
        String APIsite = "https://www.googleapis.com/customsearch/v1?";
        String APIkey = "AIzaSyA2i3EhSg33fmu8xniH46F-FHZRn3NcDOU";
        String cx = "002464989021538692093:kwh17neen_y";
        String q;
        String dateRestrict = "d1";


        List<String> GETseeds = new ArrayList<>();
        for (String seed : urls){
            String GETurl = APIsite + "key=" + APIkey + "&" + "cx=" + cx + "&q=site:"+seed+"&dateRestrict="+dateRestrict;
            GETseeds.add(GETurl);
        }
        System.out.println("Successfully get seeds!");
        return GETseeds;
    }


    public static void main(String[] args) throws IOException{
        List<String> urls = new ArrayList<>();
        List<String> seeds = new ArrayList<>();
        urls = readurl("rawurl.txt");
        seeds = GETseeds(urls);
        System.out.println(seeds);
//        String test = "abcdeee";
//        System.out.println(test.substring(2,4));


    }

}
