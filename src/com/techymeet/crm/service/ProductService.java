package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.ProductBo;

public interface ProductService {
	
	public int createProduct(ProductBo productBo);
	public List<ProductBo> listProduct();
	public ProductBo viewProduct(int productId);
	public boolean deleteProduct(int productId);
	public int editProduct(ProductBo productBo);
	
	public List<ProductBo> searchProduct(ProductBo productBo);
	

}
