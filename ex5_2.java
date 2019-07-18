package sk16100;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex5_2", urlPatterns = { "/sk16100.ex5_2" })

public class ex5_2 extends HttpServlet {
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

		out.println("<html><head>");
		out.println("<title>ex5_2</title>");
		out.println("</head><body>");
		out.println("<h1>名前をクッキーに保存し、サーブレット ex5_1 に戻ります。</h1><hr>");

		// username が空欄でない場合，クッキーに保存する
		if ( ! username.equals("") ) {
			// 取得した username をUTF8でURLエンコードする
			String ename = URLEncoder.encode(username, "utf-8");
			// 新しいクッキー cookie を作成する
			Cookie cookie = new Cookie("username", ename);
			// クッキー cookie を発行（書き込み）する
			response.addCookie(cookie);
			// クッキー発行のメッセージ出力
			out.println(username + " さんの名前をクッキーに保存しました。<br>");
		}

		out.println("<form action=\"/webapps/sk16100.ex5_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\">");
		out.println("</form>");
		out.println("</body></html>");
    }
}
