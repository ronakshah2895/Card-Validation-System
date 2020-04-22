package com.sjsu.individualproject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonIO extends CardIO {

    @Override
    void read() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        JSONArray cardsList = (JSONArray) jsonParser.parse(new FileReader("/Users/rony/Downloads/Sample.json"));
        for (Object cardValue : cardsList) {
            Card card = new Card((JSONObject) cardValue);
            this.validateCard(card);
        }
    }
}
