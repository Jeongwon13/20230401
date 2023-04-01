package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/myPage/info")
public class InfoServlet extends HttpServlet {
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    
	    try {
	        MemberService service = new MemberService();
	        
	        HttpSession session = req.getSession();
	        
	        // 세션에 저장된 로그인 멤버 객체를 가져옴
	        Member loginMember = (Member)session.getAttribute("loginMember");

	        String memberNickname = req.getParameter("memberNickname");
	        String memberTel = req.getParameter("memberTel");
	        
	        int result = service.info(loginMember, memberNickname, memberTel);
	        
	        if(result > 0) {
	            session.setAttribute("message", "수정이 완료!");
	        } else {
	            session.setAttribute("message", "수정 실패ㅋ");
	        }
	        
	        resp.sendRedirect(req.getContextPath() + "/member/myPage/info");
	        
	    } catch(Exception e) {
	        e.printStackTrace();
	    }
	}
}
