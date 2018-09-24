package com.project.retail.RetailProject.lineitem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LineItemsRepository extends JpaRepository<LineItems, Integer> {
	@Query("select productPrice from Product where productId=:pid")
    Double find(@Param("pid") Integer pid);
	
	@Query("select sum(itemTotal) from LineItems where orderId=:oid")
    Double findTotal(@Param("oid") Integer oid);
	
	@Query("update Cart set orderTotal=:tot where orderId=:oid")
	void change(@Param("oid") Integer oid, @Param("tot") Double tot);
}