package ServiceConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.StringWriter;



public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        RestTemplate restTemplate = new RestTemplate();
        Coupon[] coupons = restTemplate.getForObject("https://cs-hsa-api-coupons.herokuapp.com/coupons", Coupon[].class);
        Category category = restTemplate.getForObject("https://cs-hsa-api-categories.herokuapp.com/categories", Category.class);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            StringWriter stringEmp = new StringWriter();
            objectMapper.writeValue(stringEmp, category);
            System.out.println(stringEmp);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            List<Coupon> upToDateCoupons = new ArrayList<>();

            for (int i = 0; i < coupons.length; i++) {
                Date couponDate = dateFormat.parse(coupons[i].getExpiresAt());
                if (date.before(couponDate))
                    upToDateCoupons.add(coupons[i]);
            }

            for(Coupon coupon : upToDateCoupons)
                log.info(coupon.getId());

        } catch (ParseException e) {
            log.info("PARSING ERROR");
            e.printStackTrace();
        }
    }

}