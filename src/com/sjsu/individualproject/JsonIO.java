package com.sjsu.individualproject;

import com.google.gson.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JsonIO extends CardIO {

    @Override
    void read(String inputFile) throws IOException {
        Gson jsonBuilder = new Gson();
        JsonArray cardsList = jsonBuilder.fromJson(new FileReader(inputFile), JsonArray.class);
        for (JsonElement cardObject : cardsList) {
            Map<String, String> cardValue = new HashMap<>();
            JsonObject jsonCardObject = cardObject.getAsJsonObject();
            cardValue.put("CardNumber", jsonCardObject.get("CardNumber").toString());
            cardValue.put("ExpirationDate", jsonCardObject.get("ExpirationDate").toString());
            cardValue.put("NameOfCardholder", jsonCardObject.get("NameOfCardholder").toString());
            Card card = new Card(cardValue);
            this.validateCard(card);
        }
    }

    @Override
    void write() throws IOException {
        File outFile = new File("out.json");
        outFile.createNewFile();
        FileWriter jsonWriter = new FileWriter(outFile, false);
        Gson jsonBuilder = new GsonBuilder().setPrettyPrinting().create();
        JsonArray jsonList = new JsonArray();
        for (Card card: validatedCards) {
            JsonObject cardObj = new JsonObject();
            cardObj.addProperty("CardNumber", card.initialCardNumber);
            cardObj.addProperty("CardType", card.type);
            cardObj.addProperty("Error", card.error);
            jsonList.add(cardObj);
        }
        jsonWriter.write(jsonBuilder.toJson(jsonList));
        jsonWriter.close();
    }
}
