// service implement -> DAO interface

package service;

import java.util.List;

import domain.ProductVO;
import repository.DAO;
import repository.ProductDAO;

public class ProductService implements Service {
	private DAO dao;
	
	public ProductService() {
		dao = new ProductDAO();
	}
	
	@Override
	public int register(ProductVO pvo) {
		// jsp에서 받은 pvo 객체를 가지고 DB에 넣어달라고 dao에게 요청
		// dao에게 연결할때는 db 구문으로 한느것이 일반적
		
		System.out.println("* ProductService > register() 호출");
		
		return dao.insert(pvo);
	}

	@Override
	public List<ProductVO> list() {
		return dao.selectList();
	}

	@Override
	public ProductVO detail(int pno) {
		return dao.selectDetail(pno);
	}

	@Override
	public int remove(int pno) {
		return dao.delete(pno);
	}

	@Override
	public int modify(ProductVO pvo) {
		return dao.update(pvo);
	}
}
