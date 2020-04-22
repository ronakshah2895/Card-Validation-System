package com.sjsu.individualproject;

import org.json.simple.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlIO extends CardIO {

    @Override
    void read() throws IOException, ParserConfigurationException, SAXException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dom = builder.parse(new File("/Users/rony/Downloads/Sample.xml"));
        dom.normalizeDocument();
        Element root = dom.getDocumentElement();
        NodeList cardsList = root.getElementsByTagName("row");
        for (int i=0; i<cardsList.getLength(); i++) {
            Map<String, String> cardValue = new HashMap<>();
            Element cardEl = (Element) cardsList.item(i);
            cardValue.put("CardNumber", cardEl.getElementsByTagName("CardNumber").item(0).getTextContent());
            cardValue.put("ExpirationDate", cardEl.getElementsByTagName("ExpirationDate").item(0).getTextContent());
            cardValue.put("NameOfCardholder", cardEl.getElementsByTagName("NameOfCardholder").item(0).getTextContent());
            Card card = new Card(cardValue);
            this.validateCard(card);
        }
    }
}
