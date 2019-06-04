import ServiceConsumer.Application;
import ServiceConsumer.Category;
import ServiceConsumer.Coupon;
import org.junit.Test;

import java.util.concurrent.CopyOnWriteArrayList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestCase {
    Application application = new Application();

    //test to check appraisal
    @Test
    public void testGetValidCoupons() {
        Coupon[] expectedCoupons = new Coupon[3];

        Coupon coupon1 = new Coupon();
        coupon1.setId("COUPON_1");
        coupon1.setDescription("50% Discount");
        coupon1.setSeller("Crazy Seller");
        coupon1.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        coupon1.setExpiresAt("2045-12-01");
        expectedCoupons[0] = coupon1;

        Coupon coupon2 = new Coupon();
        coupon2.setId("COUPON_2");
        coupon2.setDescription("5% Discount");
        coupon2.setSeller("The Seller");
        coupon2.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        coupon2.setExpiresAt("2042-12-25");
        expectedCoupons[1] = coupon2;

        Coupon coupon3 = new Coupon();
        coupon3.setId("COUPON_4");
        coupon3.setDescription("1% Discount");
        coupon3.setSeller("Mega Discount");
        coupon3.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
        coupon3.setExpiresAt("2055-10-01");
        expectedCoupons[2] = coupon3;

        Coupon[] outputCoupons = application.getValidCoupons();
        assertArrayEquals(expectedCoupons, outputCoupons);
    }

    @Test
    public void testGenerateCategoryArray() {
        Category[] expectedCategories = new Category[5];
        Category[] categories = application.getCategories("Top5");
        assertArrayEquals(expectedCategories, categories);
    }

}
