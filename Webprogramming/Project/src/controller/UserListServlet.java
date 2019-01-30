package controller;

import java.io.IOException;
import java.util.List;
import java.util.StringJoiner;

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
		String birthday1 = request.getParameter("birthday1");
		String birthday2 = request.getParameter("birthday2");
		System.out.println(loginId);
		System.out.println(userName);
		System.out.println(birthday1);
		System.out.println(birthday2);
		//すべて空の場合はすべて表示する
		if(loginId.length()==0 && userName.length()==0 && birthday1.length()==0 && birthday2.length()==0) {
			response.sendRedirect("UserListServlet");
		}else {
			//検索文字列の結合
			StringJoiner joiner = new StringJoiner(" AND","SELECT * FROM user WHERE","AND login_id != 'admin';");
			joiner.setEmptyValue("");
			//ログインIDが入力
			if(loginId.length()!=0) {
				joiner.add(" login_id = \'" + loginId + "\'");
			}
			//ユーザ名が入力(部分一致)
			if(userName.length()!=0) {
				joiner.add(" name LIKE \'%" + userName + "%\'");
			}
			//生年月日が入力（指定範囲）
			if(birthday1.length()!=0 && birthday2.length()!=0) {

				joiner.add(" birth_date between \'" + birthday1 + "\' AND \'" + birthday2 + "\'");
				System.out.println("test");
				//下限のみ入力
			}else if(birthday1.length()!=0) {
				joiner.add(" birth_date between \'" + birthday1 + "\' AND \'99991231\'");
				//上限のみ入力
			}else if(birthday2.length()!=0) {
				joiner.add(" birth_date between \'10000101\' AND \'" + birthday2 + "\'");
			}

			String sqlCommand = joiner.toString();
			System.out.println(sqlCommand);
			UserDao userDao = new UserDao();
			List<User> userList = userDao.findSelect(sqlCommand);

			// リクエストスコープにユーザ一覧情報をセット
			request.setAttribute("userList", userList);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/userlist.jsp");
			dispatcher.forward(request, response);
		}
	}

}
