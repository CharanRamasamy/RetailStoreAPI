package com.project.retail.RetailProject.shop;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ShopResource {
	@Autowired
	private ShopRepository shopRepository;

	@GetMapping("/shops")
	public List<Shop> retrieveAllShops() {
		return shopRepository.findAll();
	}

	@GetMapping("/shops/{id}")
	public Shop retrieveShop(@PathVariable Integer id) {
		Optional<Shop> shop = shopRepository.findById(id);

		return shop.get();
	}

	@DeleteMapping("/shops/{id}")
	public void deleteShop(@PathVariable Integer id) {
		shopRepository.deleteById(id);
	}

	@PostMapping("/shops")
	public ResponseEntity<Object> createShop(@RequestBody Shop shop) {
		Shop savedShop = shopRepository.save(shop);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedShop.getShopId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/shops/{id}")
	public ResponseEntity<Object> updateShop(@RequestBody Shop shop, @PathVariable Integer id) {

		Optional<Shop> shopOptional = shopRepository.findById(id);

		if (!shopOptional.isPresent())
			return ResponseEntity.notFound().build();

		shop.setShopId(id);

		shopRepository.save(shop);

		return ResponseEntity.noContent().build();
	}
}
