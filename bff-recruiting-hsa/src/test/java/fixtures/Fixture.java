package fixtures;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import feign.Request;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import static java.nio.charset.StandardCharsets.UTF_8;

public final class Fixture {

    private static final String PATH = "src/test/resources/json/";

    public static <T> T readFileFromResources(String fileName, Class<T> clase) {
        try {
            FileInputStream fis = new FileInputStream(PATH + fileName);
            var jsonText = IOUtils.toString(fis, UTF_8.name());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonText, clase);
        } catch (Exception e) {
            return null;
        }
    }

    public static FeignException.FeignClientException getMockFeignClientException(int status, String mensaje, String body) {
        return new FeignException.FeignClientException(status, mensaje, getMockRequest(),
                body.getBytes(StandardCharsets.UTF_8), null);
    }

    public static Request getMockRequest() {
        return Request.create(Request.HttpMethod.GET, "http://test.url",
                new HashMap<>(), Request.Body.create(new byte[0], Charset.defaultCharset()), null);
    }

}