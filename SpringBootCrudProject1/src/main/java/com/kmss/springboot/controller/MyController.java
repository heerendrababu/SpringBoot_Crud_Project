package com.kmss.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kmss.springboot.entity.Product;
import com.kmss.springboot.service.MyService;

//url: http://localhost:8082/api/v1/Product
@RestController
@RequestMapping("/api")
public class MyController 
{
   private final MyService myService;
   
   @Autowired
   public MyController(MyService myService)
   {
	   this.myService= myService;
   }
   
   // let us insert a row into product table from controller
   // data getting from browser so we use Post Request
   @PostMapping("/product")
    public Product createProduct(@RequestBody Product p)
    {
	   return myService.saveProduct(p);
    }
 //Read data....
 	@GetMapping("/read")
 	public List<Product>getAllProductsData()
 	{
 		return myService.getAllProducts();
 	}
 	
 	//Updating....
// 	@PutMapping("/update/{pno}")
// 	public Product updateProductData(@PathVariable int pno, @RequestBody Product p)
// 	{
// 		return myService.updateProduct(pno, p);
//
// 	}
 	 @PutMapping("/update/{pno}")
     public ResponseEntity<Product> updateProductData(@PathVariable int pno, @RequestBody Product p) {
         try {
             Product updatedProduct = myService.updateProduct(pno, p);
             return ResponseEntity.ok(updatedProduct);
         } catch (Exception e) {
             e.printStackTrace(); // Print the stack trace to logs
             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
         }
     }
 	
 	//Deleting....
 	@DeleteMapping("/delete/{id}")
 	public void deleteProductData(@PathVariable int id)
 	{
 		 myService.deleteProduct(id);
 		
 	}
  }

