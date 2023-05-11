// controller -> service

package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ProductService;
import service.Service;

// @WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 상품등록, 상품 리스트, 상품 상세, 상품 수정, 상품 삭제
	// 컨트롤러 -> 서비스(interface -> implement), 서비스 -> DAO(interface -> implement), DAO -> DBconnection
	
	private Service svc;
     
	// 생성자
    public ProductController() {
    	svc = new ProductService();
    }

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// get, post 메소드의 처리는 service에서 처리함
		// request : 클라이언트 -> 서버, response : 서버 -> 클라이언드 
		
		// post 방식으로 데이터처리를 할 때 한글이 깨지는 것을 방지
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		
		String uri = req.getRequestURI();		// 요청 경로 (원하는 서비스) 컨트롤러주소/요청서비스
		System.out.println("* ProductController > service() > uri : " + uri);
		String context = req.getContextPath();		// 프로젝트 명
		System.out.println("* ProductController > service() > context : " + context);
		
		// 객체를 내야하는 목적지 주소
		String destPage = "";
		
		// 오는 요청에 대한 분기 처리
		switch (uri) {
		case "/register.pd":
			break;
		case "/list.pd":
			break;
		default:
			break;
		}
		
		// 웹의 목적지 주소로 연결해주는 객체
		// destPage로 이동시 응답 객체를 싣고 가야 함.
		RequestDispatcher rdp = req.getRequestDispatcher(destPage);
		rdp.forward(req, res);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		service(request, response);
	}
}
