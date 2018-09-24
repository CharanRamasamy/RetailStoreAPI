package com.project.retail.RetailProject.Cart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query("select sum(itemTotal) from LineItems where orderId=:oid")
    Double find(@Param("oid") Integer oid);
}