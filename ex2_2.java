package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex2_2", urlPatterns = { "/sk16100.ex2_2" })

public class ex2_2 extends HttpServlet {
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

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>ex2_2</title>");
		out.println("</head><body>");
		out.println("<h1>名前を表示し、サーブレット ex2_1 に戻ります。</h1><hr>");

		// username が空欄でない場合，名前を表示する
		if ( ! username.equals("") )
			out.println(username + " さん，こんにちは。");

		out.println("<form action=\"/webapps/sk16100.ex2_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\">");
		out.println("</form>");
		out.println("</body></html>");
    }
}
