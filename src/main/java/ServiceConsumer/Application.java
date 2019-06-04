package ServiceConsumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.StringWriter;

/**
 * API destinated to consume the Coupon and Category API.
 */
@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            getValidCoupons();
            getCategories("Top5");
            getCategories("Grid");
        };
    }

    /**
     * Rest service consuming the Coupon API.
     * @return array of non expired coupons
     */
    public static Coupon[] getValidCoupons() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Coupon[] coupons = restTemplate.getForObject("https://cs-hsa-api-coupons.herokuapp.com/coupons", Coupon[].class);

            Date actualDate = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            List<Coupon> upToDateCoupons = new ArrayList<>();

            for (int i = 0; i < coupons.length; i++) {
                Date couponDate = dateFormat.parse(coupons[i].getExpiresAt());
                if (actualDate.before(couponDate))
                    upToDateCoupons.add(coupons[i]);
            }

            for(Coupon coupon : upToDateCoupons)
                log.info(coupon.getId());

            return upToDateCoupons.toArray(new Coupon[upToDateCoupons.size()]);

        } catch (ParseException e) {
            log.info("PARSING ERROR");
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Rest service consuming the Category API.
     * @param categoryGroup "Top 5" to get the 5 most relevant categories, "Grid" to get the rest of the categories (case-sensitive)
     * @return an array of categories in accordance to the parameter passed. null if parameter doesn't coincide.
     */
    public static Category[] getCategories(String categoryGroup){
        try {
            RestTemplate restTemplate = new RestTemplate();
            Category rootCategory = restTemplate.getForObject("https://cs-hsa-api-categories.herokuapp.com/categories", Category.class);

            Category[] mobCategory = rootCategory.getSubcategories();
            Category[] principalCategories = mobCategory[0].getSubcategories();

            principalCategories = calculateCategoriesRelevance(principalCategories);
            principalCategories = orderCategoriesByRelevance(principalCategories);

            Category[] categories;
            if(categoryGroup.equalsIgnoreCase("Top5")) {
                //Generate a subarray with the first 5 categories
                categories = Arrays.copyOfRange(principalCategories, 0, 5);
                printCategories(categories);
            } else if (categoryGroup.equalsIgnoreCase("Grid")) {
                //Generate a subarray with the categories out of the top 5
                categories = Arrays.copyOfRange(principalCategories,5,principalCategories.length);
                printCategories(categories);
            } else {
                return null;
            }
            return categories;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Print the name of each category within an array.
     * @param categories an array of categories
     */
    private static void printCategories(Category[] categories) {
        if(categories != null)
        for (int i = 0; i < categories.length; i++) {
            log.info(categories[i].getName());
        }
    }

    /**
     * Print the json fetched from the Category API
     * @param category json extracted from the API
     */
    private static void printFetchedJSON(Category category) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            StringWriter stringEmp = new StringWriter();
            objectMapper.writeValue(stringEmp, category);
            System.out.println(stringEmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Calculate categories relevance as a sum of its subcategories's relevances.
     * @param principalCategories An array of categories
     * @return an array of categories with its relevances setted
     */
    private static Category[] calculateCategoriesRelevance(Category[] principalCategories) {
        //Calculate total relevance for each category
        for (int i = 0; i < principalCategories.length; ++i) {
            principalCategories[i].setRelevance(calculateTotalCategoryRelevance(principalCategories[i]));
        }
        return principalCategories;
    }

    /**
     * Order the categories by relevance.
     * @param principalCategories An array of categories
     * @return an array of categories in descending order
     */
    private static Category[] orderCategoriesByRelevance(Category[] principalCategories) {
        for (int i = 0; i < principalCategories.length - 1;i++) {
            for (int j = i + 1; j < principalCategories.length; j++) {
                if(principalCategories[i].getRelevance() < principalCategories[j].getRelevance()) {
                    Category temp = principalCategories[i];
                    principalCategories[i] = principalCategories[j];
                    principalCategories[j] = temp;
                }
            }
        }
        return principalCategories;
    }

    /**
     * Calculate the total relevance for a category.
     * @param category category object which relevance wants to be calculated
     * @return total relevance
     */
    private static int calculateTotalCategoryRelevance(Category category) {
        if(category.getSubcategories() != null && category.getSubcategories().length > 0)
            return category.getRelevance() + calculateTotalCategoryRelevance(category.getSubcategories()[0]);
        else
            return category.getRelevance();
    }

}