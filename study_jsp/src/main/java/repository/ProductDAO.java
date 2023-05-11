package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.ProductVO;
import orm.DatabaseConnector;

public class ProductDAO implements DAO {
	// DB connector
	private Connection conn;
	private PreparedStatement pst;
	private String query = "";
	
	public ProductDAO() {
		DatabaseConnector dbc = DatabaseConnector.getInstance();
		conn = dbc.getConnection();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		System.out.println("* ProductDAO > insert() 호출");
		
		query = "insert into product(pname, price, madeby) values(?, ?, ?)";
		
		try {
			pst = conn.prepareStatement(query);	
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("* ProductDAO > insert() 에러 발생");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		System.out.println("* ProductDAO > selectList() 호출");
		
		query = "select * from product order by pno desc";
		
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getString("regdate")));
			}
			return list;
		}catch (Exception e) {
			System.out.println("* ProductDAO > selectList() 에러 발생");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public ProductVO selectDetail(int pno) {
		System.out.println("* ProductDAO > selectDetail() 호출");
		
		query = "select * from product where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price"), rs.getString("regdate"), rs.getString("madeby"));
			}
		}catch (Exception e) {
			System.out.println("* ProductDAO > selectDetail() 에러 발생");
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int delete(int pno) {
		System.out.println("ProductDAO > delete() 호출");
		
		query = "delete from product where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("ProductDAO > delete() 에러 발생");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(ProductVO pvo) {
		System.out.println("* ProductDAO > update() 호출");
		
		query = "update product set pname = ?, price = ?, madeby =? where pno = ?";
		
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeby());
			pst.setInt(4, pvo.getPno());
			return pst.executeUpdate();
		}catch (Exception e) {
			System.out.println("* ProductDAO > update() 에러 발생");
			e.printStackTrace();			
		}
		return 0;
	}
}
