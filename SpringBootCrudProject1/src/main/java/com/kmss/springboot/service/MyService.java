package com.kmss.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kmss.springboot.entity.Product;
import com.kmss.springboot.repository.MyRepository;

@Service // it tells that this is business logic
public class MyService 
{
   private final MyRepository myRepository;
   
   @Autowired
   public MyService(MyRepository myRepository)
   {
	   this.myRepository = myRepository;
   }
   // CRUD Operations:-
   public Product saveProduct(Product p)
   {
	   return myRepository.save(p);// save()is a method of JpaRepository used to insert data into table with the help of Hibernate.
   }
   // Read all rows from the product table.
   public List<Product> getAllProducts()
   {
	  return myRepository.findAll();// finAll() method of JpaRepository used to read all rows from Table then convert into each row into each object.and return List(of Products).
   }
   
   // Update a row(Product) with new product based on pno
   public Product updateProduct(int pno,Product newProduct)
   {
	  Optional<Product> existingProduct  = myRepository.findById(pno);
	  if(existingProduct.isPresent()==true)
	  {	
		  Product p=existingProduct.get();
		  p.setPname(newProduct.getPname());
		  p.setPprice(newProduct.getPprice());
		  p.setPqty(newProduct.getPqty());
		  return myRepository.save(p);
	  }
	  else
		  throw new RuntimeException("Product not availble");
   }
   // delete a row based on pno
   public void deleteProduct(int pno)
   {
	   myRepository.deleteById(pno);
   }
}
