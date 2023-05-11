// controller -> service

package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
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
		String context = req.getContextPath();		// 프로젝트 명
		System.out.println("* ProductController > service() > uri : " + uri);
		System.out.println("* ProductController > service() > context : " + context);
		
		// 객체를 내야하는 목적지 주소
		String destPage = "";
		
		// 오는 요청에 대한 분기 처리
		switch (uri) {
		case "/register.pd":
			destPage = "/register.jsp";
			
			break;
		case "/insert.pd":
			// DB 연결, 등록 처리
			// JSP에서 가져온 객체(이름, 가격, 정보)를 가지고 왔다.
			// service에게 가져온 데이터를 객체화 하여 DB에 저장해달라고 요청
			
			// 1. 객체를 생성
			String pname = req.getParameter("pname");
			int price = Integer.parseInt(req.getParameter("price"));	// req.getParameter()로 가져온 값은 String 형식, 형변환 필요
			String madeby = req.getParameter("madeby");
			ProductVO pvo = new ProductVO(pname, price, madeby);
			/* 생성자 없을 경우
			 * ProductVO pvo = new ProductVO();
			 * pvo.setPname(pname);
			 * pvo.setPrice(price);
			 * pvo.setMadeby(madeby);
			 */
			
			// 2. service에게 객체주고 요청
			int isOk = svc.register(pvo);
			System.out.println("* 상품 등록 : " + (isOk > 0 ? "성공" : "실패"));
			destPage = "/index.jsp";			
			
			break;
		case "/list.pd":
			List<ProductVO> list = svc.list();
			req.setAttribute("list", list);
			System.out.println("* 상품 리스트");
			destPage = "/list.jsp";
			
			break;
		case "/detail.pd" :
			int pno = Integer.parseInt(req.getParameter("pno"));
			
			pvo = svc.detail(pno);
			req.setAttribute("pvo", pvo);
			destPage = "detail.jsp";
			
			break;
		case "/modify.pd":
			pno = Integer.parseInt(req.getParameter("pno"));
			
			req.setAttribute("pvo", svc.detail(pno));			
			destPage = "modify.jsp";
			
			break;
		case "/edit.pd":
			pno = Integer.parseInt(req.getParameter("pno"));
			pname = req.getParameter("pname");
			price = Integer.parseInt(req.getParameter("price"));
			madeby = req.getParameter("madeby");
			
			pvo = new ProductVO(pno, pname, price, madeby);
			isOk = svc.modify(pvo);
			System.out.println("* 상품 수정 : " + (isOk > 0 ? "성공" : "실패"));
			
			destPage = "list.pd";
			
			break;
		case "/remove.pd":
			pno = Integer.parseInt(req.getParameter("pno"));
			
			isOk = svc.remove(pno);
			System.out.println("* 상품 삭제 : " + (isOk > 0 ? "성공" : "실패"));
			
			destPage = "/list.pd";
			
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
