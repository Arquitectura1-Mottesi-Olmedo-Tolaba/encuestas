package edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.arquitecture.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.BrandService;
import edu.unq.arqsoft.mottesi_olmedo_tolaba.backend.service.provider.BrandFactory;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ActiveProfiles(profiles = "test")
//@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class TransactionalTest {
/*
	@Autowired
	private BrandService brandService;
	
	@Test
	public void test_givenANewBrand_whenSavingBrandWithATransactionalMethodAndThrowingAnException_thenTheNewBrandShouldNotBeSaved() {
		String brandName = "Brand to Fail";
		Brand brandToFail = BrandFactory.newElem(brandName);
		try {
			brandService.saveBrandWithErrorForTransactionalTest(brandToFail);
		} catch (Exception e) {
			// Caught the exception thrown on purpose.
		} finally {
			Brand brandFetchedFromDatabase = brandService.findByName(brandName);
			assertTrue(brandFetchedFromDatabase == null);
		}
	}
	
	@Test
	public void test_givenANewBrand_whenSavingBrandWithATransactionalMethodAndNotThrowingAnException_thenTheNewBrandShouldBeSaved() {
		String brandName = "Brand to Pass";
		Brand brandToFail = BrandFactory.newElem(brandName);
		try {
			brandService.save(brandToFail);
		} catch (Exception e) {
			fail("No exception should have been caught");
		} finally {
			Brand brandFetchedFromDatabase = brandService.findByName(brandName);
			assertTrue(brandFetchedFromDatabase != null);
		}
	}
*/
}
