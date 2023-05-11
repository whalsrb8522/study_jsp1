// service interface -> service implement

package service;

import java.util.List;

import domain.ProductVO;

public interface Service {
	int register(ProductVO pvo);
	List<ProductVO> list();
	ProductVO detail(int pno);
	int remove(int pno);
	int modify(ProductVO pvo);
}
