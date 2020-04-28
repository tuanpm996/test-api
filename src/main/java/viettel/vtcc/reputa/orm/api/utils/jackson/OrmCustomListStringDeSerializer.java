package viettel.vtcc.reputa.orm.api.utils.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.Normalizer;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class OrmCustomListStringDeSerializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        List<String> list = new LinkedList<>();
        try {
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                String text = jsonParser.getText();
                if (StringUtils.isEmpty(text)) {
                    continue;
                }
                if (!Normalizer.isNormalized(text, Normalizer.Form.NFC)) {
                    text = Normalizer.normalize(text, Normalizer.Form.NFC);
                }
                list.add(text);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return list;
    }
}
