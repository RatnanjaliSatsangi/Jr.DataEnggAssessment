import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;

Document doc = Jsoup.connect("https://www.diariomunicipal.sc.gov.br/?r=site/index&q=abertura+categoria%3ALicita%C3").get();
public static Document getDocument(String url) {
    Connection conn = Jsoup.connect(url);
    Document document = null;
    try {
        document = conn.get();
    } catch (IOException e) {
        e.printStackTrace();
    // handle error
    }
    return document;
}
