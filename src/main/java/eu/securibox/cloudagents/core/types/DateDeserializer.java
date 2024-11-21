package eu.securibox.cloudagents.core.types;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class DateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
        // The actual format we are looking at is 
        // "yyyy-MM-dd'T'HH:mm:ss.fffffff'Z'"
        // but java can't handle .NET 7 decimals.
        String date = jsonparser.getText();
        
        String[] dateParts = date.split("T");
        if(dateParts.length == 2) {
        	String[] timeParts = dateParts[1].split(":");
        	String seconds = timeParts[timeParts.length - 1];
        	if(seconds.indexOf('.') > -1) {
        		seconds = seconds.substring(0,seconds.indexOf('.')+4) + "Z";
        	}else {
        		seconds = seconds.replaceFirst("Z", ".000Z");
        	}
        	timeParts[timeParts.length - 1] = seconds;
        	dateParts[1] = String.join(":", timeParts);
        	date = String.join("T", dateParts);
        }else {
        	throw new RuntimeException("Invalid date format");
        }
        try {
            return format.parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

}
