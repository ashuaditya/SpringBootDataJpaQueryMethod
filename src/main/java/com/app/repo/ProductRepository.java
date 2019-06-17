package com.app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
	@Query(" select p from com.app.model.Product p ")
	public List<Product> getMyData();
	
	@Query(" select p.prodCost from Product p ")
	public List<Double> getCostOnly();
	
	@Query(" select p.prodCost, p.prodCode from Product p ")
	public List<Object[]> getInfo();
	
	@Query(" select p from Product p where p.prodId=?1 or prodCost <?2 ")
	public List<Product> getNewData(Integer pid, Double cost);
	
	@Query(" select p from Product p where p.prodId=:a or prodCost<:b  ")
	public List<Product> getNewDataName(Integer a, Double b);
	
	
}
