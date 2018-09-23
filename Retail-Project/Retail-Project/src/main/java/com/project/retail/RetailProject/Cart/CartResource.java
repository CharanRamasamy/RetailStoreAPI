package com.project.retail.RetailProject.Cart;

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

import com.project.retail.RetailProject.Cart.Cart;
import com.project.retail.RetailProject.Cart.CartRepository;

@RestController
public class CartResource {
	@Autowired
	private CartRepository orderRepository;

	@GetMapping("/orders")
	public List<Cart> retrieveAllOrders() {
		return orderRepository.findAll();
	}

	@GetMapping("/orders/{id}")
	public Cart retrieveOrder(@PathVariable Integer id) {
		Optional<Cart> order = orderRepository.findById(id);
		return order.get();
	}

	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable Integer id) {
		orderRepository.deleteById(id);
	}

	@PostMapping("/orders")
	public ResponseEntity<Object> createOrder(@RequestBody Cart order) {
		Cart savedOrder = orderRepository.save(order);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedOrder.getOrderId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@PutMapping("/orders/{id}")
	public ResponseEntity<Object> updateOrder(@RequestBody Cart order, @PathVariable Integer id) {

		Optional<Cart> orderOptional = orderRepository.findById(id);

		if (!orderOptional.isPresent())
			return ResponseEntity.notFound().build();

		order.setOrderId(id);

		orderRepository.save(order);

		return ResponseEntity.noContent().build();
	}
}

