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

@WebServlet("/member/myPage/changePw")
public class ChangePwServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/member/myPage-changePw.jsp";
		req.getRequestDispatcher(path).forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			
			
		try {
			HttpSession session = req.getSession();
			
			String currentPw = req.getParameter("currentPw");
			String newPw = req.getParameter("newPw");
			String newPwConfirm = req.getParameter("newPwConfirm");
			
			Member loginMember = (Member)session.getAttribute("loginMember");
			
			
			
			MemberService service = new MemberService();
			
			int result = service.changePw(currentPw, newPw, newPwConfirm, loginMember);
			
			
			
			if(result > 0) {
				session.setAttribute("message", "변경 완료");
			} else {
				session.setAttribute("message", "변경 실패~");
			}
			
			resp.sendRedirect(req.getContextPath());
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	}
	
}
