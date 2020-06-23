package com.project.getshare;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.getshare.model.Cart;
import com.project.getshare.model.SoftwareHouse;
import com.project.getshare.model.User;
import com.project.getshare.services.CartService;
import com.project.getshare.services.SoftwareHouseService;
import com.project.getshare.services.UserService;

@SpringBootTest
class GetshareApplicationTests {

	/*@Autowired
	private UserService userService;
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private SoftwareHouseService softwarehouseService;
	
	@Test
	public void testSaveAdmin() {
		
		User admin = new User();
		admin.setFirstName("Marco");
		admin.setLastName("Verri");
		admin.setEmail("email@gmail.com");
		admin.setPassword("emailPass$");
		admin.setDOB("1998-07-15");
		admin.setRegistrationDate("1998-07-15");
		admin.setIsAdmin(true);
		
		User admin2 = new User();
		
		admin = userService.saveUser(admin);
		
		assertTrue(admin.isAdmin);
		
		admin2 = userService.getUser("email@gmail.com");
		
		assertEquals(admin, admin2);
	}
	
	@Test
	public void testCart() {
		Cart cart = new Cart();
		
		cart = cartService.saveCart(cart);
		
		assertNotNull(cart.getId());
	}
	
	@Test
	public void testSaveClient() {
		
		Cart cart = new Cart();
		
		User client = new User();
		client.setFirstName("Guido");
		client.setLastName("Cesarano");
		client.setEmail("email2@gmail.com");
		client.setPassword("email2Pass$");
		client.setDOB("1998-12-26");
		client.setRegistrationDate("2020-05-31");
		client.setIsAdmin(false);
		
		User client2 = new User();
		
		client = userService.saveUser(client, cart);
		
		assertFalse(client.isAdmin);
		
		client2 = userService.getUser("email2@gmail.com");
		
		assertEquals(client, client2);
	}
	
	@Test
	public void testAddSoftwarehouse() {
		
		User admin = new User();
		admin.setFirstName("Alessandro");
		admin.setLastName("Manzoni");
		admin.setEmail("email3@gmail.com");
		admin.setPassword("emailPass$");
		admin.setDOB("1998-07-15");
		admin.setRegistrationDate("1998-07-15");
		
		List<SoftwareHouse> lista = userService.getAllSoftwarehouse();
		
		admin.setSoftwarehouseList(lista);
		
		admin.addSoftwarehouse("CDProjectRed", "Polonia", "2000-03-26");
		admin.addSoftwarehouse("Ubisoft", "Canada", "2003-05-21");
		
		admin = userService.saveUser(admin);
	}
	
	@Test
	public void testLoadSoftwareHouse() {
		List<SoftwareHouse> lista = userService.getAllSoftwarehouse();
		assertEquals(lista.get(0).getName(), "CDProjectRed");
		assertEquals(lista.get(1).getName(), "Ubisoft");
	}
*/
}
