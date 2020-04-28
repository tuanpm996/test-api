package viettel.vtcc.reputa.orm.api.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.Normalizer;

public class OrmCustomStringDeSerializer extends JsonDeserializer<String> {
    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String value = jsonParser.getText();
        if (StringUtils.isEmpty(value)) {
            return null;
        }
        if (!Normalizer.isNormalized(value, Normalizer.Form.NFC)) {
            value = Normalizer.normalize(value, Normalizer.Form.NFC);
        }
        return value;
    }
}
