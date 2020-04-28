package viettel.vtcc.reputa.orm.api.utils.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import viettel.vtcc.reputa.orm.api.define.Constant;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrmCustomDateSerializer extends JsonSerializer<Date> {

    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constant.SDF_FORMAT);
        dateFormat.setLenient(false);
        String formattedDate = dateFormat.format(date);
        jsonGenerator.writeString(formattedDate);
    }
}