package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.Encryption;
import model.User;

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

		// ログインセッションがない場合、ログイン画面にリダイレクトさせる
				HttpSession session = request.getSession();
				User checkSession = (User)session.getAttribute("userInfo");
				if(checkSession == null) {
					response.sendRedirect("LoginServlet");
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
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
		String password = request.getParameter("password");
		String spellCheck = request.getParameter("spellCheck");
		String userName = request.getParameter("userName");
		String birthday = request.getParameter("birthday");
		//Date birthDate = Date.valueOf(birthday);

		//ログインID被りチェック
		UserDao userDao = new UserDao();
		String user = userDao.findByLoginId(loginId);

		if (user != null) {
			// リクエストスコープにエラーメッセージをセット
			request.setAttribute("errMsg", "入力されたログインIDは既に存在します");
			//入力内容をリクエストスコープにセット
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("birthday", birthday);

			// signupjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
			}
		//パスワード確認
		if(!(password.equals(spellCheck))) {
			request.setAttribute("errMsg", "パスワードをもう一度入力して下さい");
			//入力内容をリクエストスコープにセット
			request.setAttribute("loginId", loginId);
			request.setAttribute("userName", userName);
			request.setAttribute("birthday", birthday);
			// signupjspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
			dispatcher.forward(request, response);
			return;
		}
		//暗号化処理
		Encryption encryption = new Encryption();
		password = encryption.getEncryption(password);

		userDao.setSignup(loginId,userName,password,birthday);
		response.sendRedirect("UserListServlet");
	}
}
