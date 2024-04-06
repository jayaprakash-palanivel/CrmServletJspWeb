package com.techymeet.crm.service;

import java.util.List;

import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.dao.ProductDao;
import com.techymeet.crm.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	ProductDao dao=new ProductDaoImpl();

	@Override
	public int createProduct(ProductBo productBo) {
	int status=dao.createProduct(productBo);
	if(0 < status) {
		return status;
	}else {
		return status;
	}
		
	}

	@Override
	public List<ProductBo> listProduct() {
		
		return dao.listProduct();
	}

	@Override
	public ProductBo viewProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.viewProduct(productId);
	}

	@Override
	public boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return dao.deleteProduct(productId);
	}

	@Override
	public int editProduct(ProductBo productBo) {
		int status = dao.editProduct(productBo);
		if (0 < status) {
			return status;
		} else {
			return status;
		}
	
	}

	@Override
	public List<ProductBo> searchProduct(ProductBo productBo) {
		// TODO Auto-generated method stub
		return dao.searchProduct(productBo);
	}

}
