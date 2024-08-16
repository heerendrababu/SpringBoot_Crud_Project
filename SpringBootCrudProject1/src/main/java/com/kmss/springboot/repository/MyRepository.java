package com.kmss.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmss.springboot.entity.Product;

@Repository
public interface MyRepository extends JpaRepository<Product, Integer> 
{
	   // the above angular brackets represents a collection
	//<classname, primary key pno type is int type,but here it is collection's generics so Integer>
}
