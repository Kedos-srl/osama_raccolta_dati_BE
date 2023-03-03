package it.grupposcai.osamard.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerJsonDateDeserializable extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        // TODO Auto-generated method stub
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataStr = jsonParser.getText();
        try {
            if (dataStr != null && !dataStr.equals("")) {
                return dateFormat.parse(dataStr);
            } else {
                return null;
            }

        } catch (ParseException e) {
            return null;
        }
    }


}
