package it.grupposcai.osamard.util.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomerJsonLocalDateTimeDeserializable extends JsonDeserializer<LocalDateTime>{
    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String dataStr = p.getText();
        if(dataStr != null && !dataStr.equals("")){
            return  LocalDateTime.parse(dataStr, DateTimeFormatter.ISO_DATE_TIME);
        } else {
            return null;
        }

    }
}
