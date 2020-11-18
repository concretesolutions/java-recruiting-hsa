package test.concrete;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.accenture.concrete.client.IClienteCategorias;
import com.accenture.concrete.client.IClienteCupones;
import com.accenture.concrete.domain.Categories;
import com.accenture.concrete.domain.Coupon;
import com.accenture.concrete.domain.SubCategoriaN2;
import com.accenture.concrete.domain.SubCategoriaN3;
import com.accenture.concrete.domain.SubCategoriaN4;
import com.accenture.concrete.service.impl.ConcreteServiceImpl;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ConcreteApplication {

	@InjectMocks
	private ConcreteServiceImpl concreteServiceImpl;

	@Mock
	IClienteCupones iClienteCupones;

	@Mock
	IClienteCategorias iClienteCategorias;

	String responseCoupons = new String();
	String responseCategory = new String();
	List<Categories> rsGetCategorias;
	ResponseEntity<List<SubCategoriaN2>> lstSubCatn2Rs;
	List<SubCategoriaN2> assertGetCategorias;
	List<Coupon> allCouponRs;
	List<Coupon> assertRetorno;

	@Before
	public void beforeGetCategorias() {

		assertGetCategorias = new ArrayList<>();
		List<SubCategoriaN3> lstCategoriaN3 = new ArrayList<>();
		List<SubCategoriaN4> lstCategoriaN4 = new ArrayList<>();

		SubCategoriaN2 subCategoriesN2 = new SubCategoriaN2();
		subCategoriesN2.setId("food");
		subCategoriesN2.setName("Food");
		subCategoriesN2.setRelevance(4);
		subCategoriesN2
				.setIconImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN2.setSubcategories(lstCategoriaN3);
		assertGetCategorias.add(subCategoriesN2);

		SubCategoriaN3 subCategoriesN3 = new SubCategoriaN3();
		subCategoriesN3.setId("hamburger");
		subCategoriesN3.setName("Hamburger");
		subCategoriesN3.setRelevance(350);
		subCategoriesN3
				.setLargeImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3
				.setSmallImageUrl("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		subCategoriesN3.setSubcategories(lstCategoriaN4);
		lstCategoriaN3.add(subCategoriesN3);

		SubCategoriaN4 subCategoriaN4 = new SubCategoriaN4();
		lstCategoriaN4.add(subCategoriaN4);

		rsGetCategorias = new ArrayList<Categories>();

		Categories Categories = new Categories();
		Categories.setSubcategories(assertGetCategorias);
		Categories.setId("otros");
		Categories.setName("otros");
		Categories.setRelevance(0);
		rsGetCategorias.add(Categories);

	}


	
	@Before
	public void beforeOtherCategory() {
		allCouponRs = new ArrayList<Coupon>();
		assertRetorno = new ArrayList<Coupon>();
		
		Coupon coupon1 = new Coupon();
		coupon1.setDescription("50% Discount");
		coupon1.setExpiresAt("2045-12-01");
		coupon1.setId("COUPON_1");
		coupon1.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		coupon1.setSeller("Crazy Seller");
		allCouponRs.add(coupon1);
		assertRetorno.add(coupon1);
		
		Coupon coupon2 = new Coupon();
		coupon2.setDescription("50% Discount");
		coupon2.setExpiresAt("2035-12-01");
		coupon2.setId("COUPON_1");
		coupon2.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		coupon2.setSeller("Crazy Seller");
		allCouponRs.add(coupon2);
		assertRetorno.add(coupon2);
		
		Coupon coupon3 = new Coupon();
		coupon3.setDescription("50% Discount");
		coupon3.setExpiresAt("2060-12-01");
		coupon3.setId("COUPON_1");
		coupon3.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		coupon3.setSeller("Crazy Seller");
		allCouponRs.add(coupon3);
		assertRetorno.add(coupon3);
		
		Coupon coupon4 = new Coupon();
		coupon4.setDescription("50% Discount");
		coupon4.setExpiresAt("2012-12-01");
		coupon4.setId("COUPON_1");
		coupon4.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		coupon4.setSeller("Crazy Seller");
		allCouponRs.add(coupon4);
		
		Coupon coupon5 = new Coupon();
		coupon5.setDescription("50% Discount");
		coupon5.setExpiresAt("2011-12-01");
		coupon5.setId("COUPON_1");
		coupon5.setImage("https://i4.visitchile.com/img/GalleryContent/8822/slider/Torres_del_Paine.jpg");
		coupon5.setSeller("Crazy Seller");
		allCouponRs.add(coupon5);
		
		

	}

	@Test
	public void testGetCategorias() {
		Mockito.when(iClienteCategorias.getCategorias()).thenReturn(rsGetCategorias);

		List<SubCategoriaN2> retorno = concreteServiceImpl.getTopCategorias();

		assertEquals(retorno, assertGetCategorias);
	}

	@Test
	public void testGetCupones() {
		Mockito.when(iClienteCupones.getCupones()).thenReturn(allCouponRs);

		List<Coupon> retorno = concreteServiceImpl.getCupones();

		assertEquals(retorno, assertRetorno);
	}

}
