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
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
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
			request.setCharacterEncoding("UTF-8");

			int id =Integer.parseInt(request.getParameter("id"));

			// ユーザ一覧情報を取得
			UserDao userDao = new UserDao();

			User user= userDao.findById(id);


			// リクエストスコープにユーザ情報をセット
			request.setAttribute("userData", user);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
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
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		UserDao userDao = new UserDao();

		//パスワード確認
		if(!(password.equals(spellCheck))) {
			request.setAttribute("errMsg", "パスワードをもう一度入力して下さい");

			User user= new User(loginId, name, birthday);

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userData", user);
			//updatejspにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userupdate.jsp");
			dispatcher.forward(request, response);
			return;
		}
		if(password.equals(null)){
			userDao.setUpdate(name,birthday,loginId);
			response.sendRedirect("UserListServlet");
		}else {
			//暗号化処理
			Encryption encryption = new Encryption();
			password = encryption.getEncryption(password);

			//更新
			userDao.setUpdate(name,birthday,password,loginId);
			response.sendRedirect("UserListServlet");
		}
	}

}
