package com.techymeet.crm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.techymeet.crm.bo.ProductBo;
import com.techymeet.crm.db.DatabaseConnection;

public class ProductDaoImpl implements ProductDao{

	@Override
	public int createProduct(ProductBo productBo) {
		
		try {
			Connection con=DatabaseConnection.getConnection();
			Statement st=con.createStatement();
			String query="insert into product (productId,productName,productSpecification,minimumStocks,maximumStocks,availableStocks,price) values('"+productBo.getProductId()+"','"+productBo.getProductName()+"','"+productBo.getProductSpecification()+"','"+productBo.getMinimumStocks()+"','"+productBo.getMaximumStocks()+"','"+productBo.getAvailableStocks()+"','"+productBo.getPrice()+"')";
			int status=st.executeUpdate(query);
			st.close();
			con.close();
			
			if (0 < status) {
				return status;
			} else {
				return status;
			}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
	
		return 0;
	}

	@Override
	public List<ProductBo> listProduct() {
		Connection con=DatabaseConnection.getConnection();
		List<ProductBo> productList=new ArrayList<>();
		try {
			Statement st=con.createStatement();
			String query="select *from product ";
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				ProductBo productBo=new ProductBo();
				productBo.setProductId(Integer.parseInt(rs.getString("productId")));
				productBo.setProductName(rs.getString("productName"));
				productBo.setProductSpecification(rs.getString("productSpecification"));
				productBo.setMinimumStocks(rs.getString("minimumStocks"));
				productBo.setMaximumStocks(rs.getString("maximumStocks"));
				productBo.setAvailableStocks(rs.getString("availableStocks"));
				productBo.setPrice(Integer.parseInt(rs.getString("price")));
				productList.add(productBo);
		}
			st.close();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productList;

		
	}

	@Override
	public ProductBo viewProduct(int productId) {
		ProductBo productBo=new ProductBo();

		try {
			Connection con=DatabaseConnection.getConnection();
			Statement st=con.createStatement();
			String query="select *from product where  productId="+productId;
			ResultSet rs=st.executeQuery(query);
			while(rs.next()){
		        productBo.setProductId(rs.getInt("productId"));
				productBo.setProductName(rs.getString("productName"));
				productBo.setProductSpecification(rs.getString("productSpecification"));
				productBo.setMinimumStocks(rs.getString("minimumStocks"));
				productBo.setMaximumStocks(rs.getString("maximumStocks"));
				productBo.setAvailableStocks(rs.getString("availableStocks"));
				productBo.setPrice(rs.getInt("price"));
				
				
				
			}
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return productBo;
	}

	@Override
	public boolean deleteProduct(int productId) {
		try {
			Connection con=DatabaseConnection.getConnection();
			Statement st=con.createStatement();
			String query="delete from product where productId="+ productId;
		int status=	st.executeUpdate(query);
		
		
			if (0 < status) {
				 return true;
			} else {
				 return false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
	}
		return false;

	
	}

	@Override
	public int editProduct(ProductBo productBo) {
		ProductBo product=new ProductBo(); 
		try {
			Connection con=DatabaseConnection.getConnection();
			Statement st=con.createStatement();
			String query="update  product set productName='"+productBo.getProductName()+"', productSpecification='"+productBo.getProductSpecification()+"',minimumStocks='"+productBo.getMinimumStocks()+"',maximumStocks="+productBo.getMaximumStocks()+",availableStocks='"+productBo.getAvailableStocks()+"',price='"+productBo.getPrice()+"' where productId="+productBo.getProductId();
		    int s = st.executeUpdate(query);
		    if (0 < s) {
				 return s;
			} else {
				 return s;
			}
		    
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	
	}


	@Override
	public List<ProductBo> searchProduct(ProductBo productBo) {

		List<ProductBo> productList=new ArrayList<ProductBo>();
		
		String productNameQuery = null;
		String wholeSearchQuery = null;
		ResultSet rs = null;
		
		try {
			Connection con = DatabaseConnection.getConnection();
			Statement st = con.createStatement();
			
			if (null != productBo.getProductName()) {
				wholeSearchQuery = "select * from product where (productName like '" + productBo.getProductName()	+ "%'  )";
				rs = st.executeQuery(wholeSearchQuery);
				
			} else if (null != productBo.getProductName()) {
				
				if (null != productBo.getProductName()) {
					productNameQuery = "select * from product where productName like '" + productBo.getProductName() + "%'";
					rs = st.executeQuery(productNameQuery);
				}
			}
			while(rs.next()){
		        productBo.setProductId(rs.getInt("productId"));
				productBo.setProductName(rs.getString("productName"));
				productBo.setProductSpecification(rs.getString("productSpecification"));
				productBo.setMinimumStocks(rs.getString("minimumStocks"));
				productBo.setMaximumStocks(rs.getString("maximumStocks"));
				productBo.setAvailableStocks(rs.getString("availableStocks"));
				productBo.setPrice(rs.getInt("price"));
				
				productList.add(productBo);
				
			}
			st.close();
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return productList;
           
	}
		
}
