package com.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class urltest {

    @Test
    public void testlink(){
        String file = "/Users/beidan/results/20181107104414.json";
        List<String> links = extracturl.links(file);
        System.out.println(links);
    }

    @Test
    public void testgetnames(){
        String dir = "/Users/beidan/Spider/results";
        List<String> results = extracturl.getnames(dir);
        System.out.println(results);
    }

    @Test
    public void testgetalllinks(){
        String dir = "/Users/beidan/Spider/results/";
        List<String> alllinks = extracturl.getalllinks(dir);
        System.out.println(alllinks);
    }


    }



