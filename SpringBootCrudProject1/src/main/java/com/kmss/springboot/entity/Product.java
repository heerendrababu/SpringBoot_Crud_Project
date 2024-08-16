package com.kmss.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product 
{
	// Each variable will become one column.
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// requesting hibernate to generate automatic increamented values for id column.
   private int pno;
   private String pname;
   private float pprice;
   private int pqty;
   
   
public Product()
{
	super();
}


public Product(int pno, String pname, float pprice, int pqty) {
	super();
	this.pno = pno;
	this.pname = pname;
	this.pprice = pprice;
	this.pqty = pqty;
}


public int getPno() {
	return pno;
}


public void setPno(int pno) {
	this.pno = pno;
}


public String getPname() {
	return pname;
}


public void setPname(String pname) {
	this.pname = pname;
}


public float getPprice() {
	return pprice;
}


public void setPprice(float pprice) {
	this.pprice = pprice;
}


public int getPqty() {
	return pqty;
}


public void setPqty(int pqty) {
	this.pqty = pqty;
}
   
   
   
   
   
}
