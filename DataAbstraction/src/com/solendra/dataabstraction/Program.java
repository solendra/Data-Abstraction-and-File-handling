/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.solendra.dataabstraction;

import com.solendra.dataabstraction.Scrapper.JobScrapper;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author solendra
 */
public class Program {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            JobScrapper js = new JobScrapper();
            Scanner input = new Scanner(System.in);
            while (true) {
                System.out.println("Enter the file path to import :");

                String link = js.readFile(input.next());
                //System.out.print(link);

                String[] tokens = link.split("\n");
                
                //System.out.println(tokens.length);
                
                for (int i = 0; i < tokens.length; i++) {
                    //System.out.println(tokens[i]);
                    String content = js.grabContent(tokens[i]);
                    //System.out.println(content);
                System.out.println("enter the location to save :");
                
                
                    js.saveWebPage(input.next(), content);
                    //System.out.println("successful");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }

}
