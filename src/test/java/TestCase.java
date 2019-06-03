import ServiceConsumer.Application;
import ServiceConsumer.Category;
import ServiceConsumer.Coupon;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TestCase {
    Application application = new Application();

    //test to check appraisal
    @Test
    public void testGetValidCoupons() {
        Coupon[] coupons = new Coupon[3];
        Coupon[] expectedCoupons = new Coupon[2];

        //Test coupons
        coupons[0] = new Coupon("COUPON1", "2018-12-03");
        coupons[1] = new Coupon("COUPON2", "2019-12-03");
        coupons[2] = new Coupon("COUPON3", "2020-05-20");

        //Expected outputs
        expectedCoupons[0] = new Coupon("COUPON2", "2019-12-03");
        expectedCoupons[1] = new Coupon("COUPON3", "2020-05-20");

        Coupon[] outputCoupons = application.getValidCoupons(coupons);
        assertArrayEquals(expectedCoupons, outputCoupons);
    }

}
