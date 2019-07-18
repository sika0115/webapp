package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex4_2", urlPatterns = { "/sk16100.ex4_2" })

public class ex4_2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// HTTPリクエストのエンコーディングを UTF-8 とする
		request.setCharacterEncoding("utf-8");
		// フォームから渡されたパラメータ username の内容を取得する
		String username = request.getParameter("username");
		// セッション session を取得する
		HttpSession session = request.getSession(true);

		out.println("<html><head>");
		out.println("<title>ex4_2</title>");
		out.println("</head><body>");
		out.println("<h1>名前をセッション変数に保存し、サーブレット ex4_1 に戻ります。</h1><hr>");

		// username が空欄でない場合，セッション変数に保存する
		if ( ! username.equals("") ) {
			// セッション変数 username に値を格納する
			session.setAttribute("username", username);
			// メッセージ出力
			out.println(username + " さんの名前をセッション変数に保存しました。");
		}

		out.println("<form action=\"/webapps/sk16100.ex4_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\">");
		out.println("</form>");
		out.println("</body></html>");
    }
}
