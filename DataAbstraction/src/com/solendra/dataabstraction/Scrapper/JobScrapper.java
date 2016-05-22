/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solendra.dataabstraction.Scrapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author solendra
 */
public class JobScrapper {

    //public abstract void scrap();
    public String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String readLink = "";
        StringBuilder builder=new StringBuilder();
        while ((readLink = reader.readLine()) != null) {
            //System.out.println(readLink);
            builder.append(readLink+"\r\n");
            
        }

        reader.close();
        return builder.toString();
    }

    public String grabContent(String link) throws IOException {

        URL url = new URL(link);
        URLConnection conn = url.openConnection();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line = "";
        StringBuilder builder=new StringBuilder();
        
        while ((line = br.readLine()) != null) {
            builder.append(line);
        }
        br.close();
        return builder.toString();
    }
    
    public void saveWebPage(String fileName,String content) throws IOException{
        FileWriter writer =new FileWriter(fileName);
        writer.write(content);
        writer.close();
        
        
    }

}
