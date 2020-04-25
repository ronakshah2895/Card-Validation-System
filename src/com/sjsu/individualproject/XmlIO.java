package com.sjsu.individualproject;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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

    @Override
    void write() throws ParserConfigurationException, TransformerException, IOException {
        File outFile = new File("out.xml");
        outFile.createNewFile();
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document dom = builder.newDocument();
        dom.setXmlStandalone(true);
        Element root = dom.createElement("root");
        for (Card card: validatedCards) {
            Element row = dom.createElement("row");
            Element cardNumber = dom.createElement("CardNumber");
            cardNumber.appendChild(dom.createTextNode(String.format("%.2E", Double.valueOf(card.cardNumber))));
            row.appendChild(cardNumber);
            Element cardType = dom.createElement("CardType");
            cardType.appendChild(dom.createTextNode(card.type));
            row.appendChild(cardType);
            Element error = dom.createElement("Error");
            error.appendChild(dom.createTextNode(card.error));
            row.appendChild(error);
            root.appendChild(row);
        }
        dom.appendChild(root);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, "");
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        DOMSource source = new DOMSource(dom);
        StreamResult result = new StreamResult(outFile);
        transformer.transform(source, result);
    }
}
