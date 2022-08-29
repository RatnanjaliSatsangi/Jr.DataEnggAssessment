package com.ratnanjali;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
// import org.jsoup.select.Elements;
import org.jsoup.select.Elements;

import java.io.IOException;
// import java.util.*; 
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        String url = "https://www.diariomunicipal.sc.gov.br/?r=site/index&q=abertura+categoria%3ALicita%C3%A7%C3%B5es&AtoASolrDocument_page=1";
        Document doc = getDocument(url);
        int index=1;
        for(int j=0;j<100;j++){
            String cssSelector = "#content > div.row.no-print.resultado-pesquisa > h4:nth-child("+j+") > a";
            String cssForTime = "#content > div.row.no-print.resultado-pesquisa > span:nth-child("+(j+1)+")";
            Element firstHeading = doc.selectFirst(cssSelector);
            Element timeHeading = doc.selectFirst(cssForTime);
            if(firstHeading!=null)
            {
                System.out.println("Entry-"+(index++));
                System.out.println("\tTitle is: "+firstHeading.text());
                System.out.println("\tPublish Date is: "+timeHeading.text().substring(0,16));
                System.out.println("\tLink is: "+ firstHeading.attr("href"));
            }
        }
    }

public static Document getDocument(String url) {
    Connection conn = Jsoup.connect(url);
    conn.userAgent("custom user agent");
    Document document = null;
    try {
        document = conn.get();
    } catch (IOException e) {
        e.printStackTrace();
    // handle error
    }
    return document;
    
}




}
