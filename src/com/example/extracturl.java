package com.example;
//import org.json.*;

import java.io.*;
import java.util.*;

//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.json.simple.parser.JSONParser;

public class extracturl {

    /**
     * get the links from a specific json file
     */

    public static List<String> links(String filename) {
        JsonParser parser = new JsonParser();
        List<String> links = new ArrayList<>();

        try {
            JsonObject json = (JsonObject) parser.parse(new FileReader(filename));

            JsonArray items = json.get("items").getAsJsonArray();

            if (!items.isJsonNull()) {

                for (int i = 0; i < items.size(); i++) {
                    System.out.println("---------------");
                    JsonObject subObject = items.get(i).getAsJsonObject();
                    String link = subObject.get("link").getAsString();
                    System.out.println("link" + subObject.get("link").getAsString());

                    links.add(link);
                }
            } else {
                System.out.println("has no items records!");
            }


//            String city = (String) jsonObject.get("city");
//            System.out.println(city);
//
//            String job = (String) jsonObject.get("job");
//            System.out.println(job);

//            // loop array
//            JSONArray links = (JSONArray) jsonObject.get("links");
//            Iterator<String> iterator = links.iterator();
//            while (iterator.hasNext()) {
//                System.out.println(iterator.next());
//            }
        } catch (FileNotFoundException e) {
//                e.printStackTrace();
        } catch (IOException e) {
//                e.printStackTrace();
        } catch (NullPointerException e) {

        } finally {
            System.out.println("well done");
        }

        return links;
    }

    /**
     * because we have many links, we have many json files, so we need to list all the files
     * and send the resutlts to getalllinkds for iteration
     */

    public static List<String> getnames(String dir) {
        List<String> results = new ArrayList<String>();

        File[] files = new File(dir).listFiles();

        for (File file : files) {
            if (file.isFile()) {
                results.add(file.getName());
            }
        }
        return results;
    }


    // get all links from all the json files
    public static List<String> getalllinks(String dir) {

        List<String> names = getnames(dir);
        List<String> alllinks = new ArrayList<>();


        ListIterator<String> namesitr = names.listIterator();

        while (namesitr.hasNext()) {
            String path = dir + namesitr.next();

            List<String> links = extracturl.links(path);
            alllinks.addAll(links);

        }
        return alllinks;
    }


    /**
     * create a txt file for all the returned links
     */

    public static void createFile(String file, List<String> arrData) throws IOException {
        FileWriter writer = new FileWriter(file + ".txt");
        int size = arrData.size();
        for (int i = 0; i < size; i++) {
            String str = arrData.get(i).toString();
            writer.write(str);
            if (i < size - 1) {//This prevent creating a blank like at the end of the file**
                writer.write("\n");
            }
        }
        writer.close();
    }

    public static List<String> URL_filter(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        List<String> after = new ArrayList<>();

        while ((line = br.readLine()) != null) {
            // process the line.

//
            String[] elements = line.split("\\/");


            List<String> criterias = new ArrayList<>();
            criterias.add("2018");
            criterias.add("blog");
            criterias.add("blogs");
            criterias.add("news");
            criterias.add("article");
            criterias.add("fact-check");
            criterias.add("politics");
            criterias.add("atpropublica");
            criterias.add("punditfact");

            if (elements[1].equals("www.politifact.com")){
                if (elements.length>=6){
                    after.add(line);
                    System.out.println(line);
                }
            }

            else{
                if (elements.length>=5 && criterias.contains(elements[3])|criterias.contains(elements[4])){
                    after.add(line);
                    System.out.println(line);}
            }

        }
        return after;

    }


    public static void main(String[] args) throws IOException {

//        String dir = "/Users/beidan/Spider/results/";
//        List<String> alllinks = getalllinks(dir);
//
//        createFile("result",alllinks);
//        System.out.println(alllinks);

//
//        List<String> links = extracturl.links(file);
//        Object[] seedlinks = links.toArray();

        List<String> after = new ArrayList<>();
        after = URL_filter("/Users/beidan/Spider/result.txt");
        createFile("final_urls",after);

    }
}


