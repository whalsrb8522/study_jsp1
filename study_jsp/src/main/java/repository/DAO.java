package repository;

import java.util.List;

import domain.ProductVO;

public interface DAO {
	int insert(ProductVO pvo);
	List<ProductVO> selectList();
	ProductVO selectDetail(int pno);
	int delete(int pno);
	int update(ProductVO pvo);
}
