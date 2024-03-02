package ru.syn.quotes.services;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

@Component
public class BashParser {

    public Map<Long, String> getPage(long page) {
        Map<Long, String> quotes = null;
        try {
            Document doc = Jsoup.connect("http://ibash.org.ru/?page=" + page).get();
            Elements sourceQuotes = doc.select(".quote");
            quotes = new HashMap<>();
            for (Element quoteElement : sourceQuotes) {
                long id = Long.parseLong(quoteElement.select("b").first().text().substring(1));
                String text = quoteElement.select("quotbody").first().text();
                quotes.put(id, text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return quotes;
    }

    public Map.Entry<Long, String> getRandom() {
        try {
            Document doc = Jsoup.connect("http://ibash.org.ru/random.php").get();
            Element quoteElement = doc.select(".quote").first();
            String realId = quoteElement.select("b").first().text();
            if (realId.equals("#???")) return null;

            String text = quoteElement.select("quotbody").first().text();
            return new AbstractMap.SimpleEntry<>(Long.parseLong(realId.substring(1)), text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public AbstractMap.Entry<Long, String> getById(long id) {
        try {
            Document doc = Jsoup.connect("http://ibash.org.ru/quote.php?id=" + id).get();
            Element quoteElement = doc.select(".quote").first();
            String realId = quoteElement.select("b").first().text();
            if (realId.equals("#???")) return null;

            String text = quoteElement.select("quotbody").first().text();
           return new AbstractMap.SimpleEntry<>(id, text);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
