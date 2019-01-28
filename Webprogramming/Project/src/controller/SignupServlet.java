package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String spellCheck = request.getParameter("spellCheck");
		String userName = request.getParameter("userName");
		String strBirthday = ("birthday"+ "00:00:00");
		Date birthday = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		//birthday = Date.valueOf(strBirthday);

		//ログインID被りチェック
		UserDao userDao = new UserDao();
		String user = userDao.findByLoginId(loginId);

		if (user != null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力されたログインIDは既に存在します");
			// signupjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
			}
		//
		if(!(password.equals(spellCheck))) {
			request.setAttribute("errMsg", "パスワードをもう一度入力して下さい");
			// signupjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}

		userDao.setSignup(loginId,userName,password,birthday);
		response.sendRedirect("UserListServlet");
	}

}
