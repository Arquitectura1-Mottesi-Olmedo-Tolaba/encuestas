package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.csv.basicStructures.BasicProduct;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.model.Brand;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.BrandService;


@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles(profiles = "test")
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class ProductServiceTest {

	@Autowired
	private BrandService brandService;

	private BasicProduct basicProduct;
	
	private Brand aBrand;
	private Integer stockQuantity;
	private Double priceValue;
	private String productName;
	private String brandName;

	@Before
	public void setup() {
		productName = "Surtidas";
		brandName = "Bagley";
		stockQuantity = 10;
		priceValue = 15.00;
		
		aBrand = new Brand();
		
		brandService.save(aBrand);
		
		aBrand.setName(brandName);

		basicProduct = new BasicProduct();

	}

	@Test
	public void test_BuildAProductFromABasicProduct() {
		
	}
}
