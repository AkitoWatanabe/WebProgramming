package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserListServlet
 */
@WebServlet("/UserListServlet")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		// ログインセッションがない場合、ログイン画面にリダイレクトさせる
		HttpSession session = request.getSession();
		User checkSession = (User)session.getAttribute("userInfo");
		if(checkSession == null) {
			response.sendRedirect("LoginServlet");
		}else {

			// ユーザ一覧情報を取得
			UserDao userDao = new UserDao();
			List<User> userList = userDao.findAll();

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");

		String loginId = request.getParameter("loginId");
		String userName = request.getParameter("userName");
		Date birthday1 = Date.valueOf(request.getParameter("birthday1"));
		Date birthday2 = Date.valueOf(request.getParameter("birthday2"));


	}

}
