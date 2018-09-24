package com.project.retail.RetailProject.lineitem;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
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
public class LineItemsResource {

	@Autowired
	private LineItemsRepository lineitemRepository;

	@GetMapping("/lineitems")
	public List<LineItems> retrieveAllLineItems() {
		return lineitemRepository.findAll();
	}

	@GetMapping("/lineitems/{id}")
	public LineItems retrieveLineItem(@PathVariable Integer id) {
		Optional<LineItems> lineitem = lineitemRepository.findById(id);
		return lineitem.get();
	}

	@DeleteMapping("/lineitems/{id}")
	public void deleteLineItem(@PathVariable Integer id) {
		lineitemRepository.deleteById(id);
	}

	@PostMapping("/lineitems")
	public ResponseEntity<Object> createLineItem(@RequestBody LineItems lineitem) {

		Integer quantity = lineitem.getItemQuantity();

		Double price = lineitemRepository.find(lineitem.getProducts().getProductId());
		lineitem.setItemTotal(quantity * price);

		/*Double currentTotal = lineitemRepository.findTotal(lineitem.getOrders().getOrderId());
		Double newTotal = currentTotal + lineitem.getItemTotal();
		
		lineitemRepository.change(lineitem.getOrders().getOrderId(), newTotal);*/
		
		LineItems savedLineItem = lineitemRepository.save(lineitem);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedLineItem.getItemId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/lineitems/{id}")
	public ResponseEntity<Object> updateLineItem(@RequestBody LineItems lineitem, @PathVariable Integer id) {

		Optional<LineItems> lineitemOptional = lineitemRepository.findById(id);

		if (!lineitemOptional.isPresent())
			return ResponseEntity.notFound().build();

		lineitem.setItemId(id);
		Integer quantity = lineitem.getItemQuantity();

		Double price = lineitemRepository.find(lineitem.getProducts().getProductId());
		lineitem.setItemTotal(quantity * price);

		lineitemRepository.save(lineitem);

		return ResponseEntity.noContent().build();
	}
}
