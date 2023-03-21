import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebCrawler {

    public static void main(String[] args) {
        String url = "https://www.marketwatch.com/investing";

        try {
            Document doc = Jsoup.connect(url).get();


            String title = doc.title();
            System.out.println("Title: " + title);


            Elements links = doc.select("a[href]");
            for (Element link : links) {
                String linkUrl = link.attr("href");
                System.out.println("Link: " + linkUrl);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
