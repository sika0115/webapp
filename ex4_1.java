package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex4_1", urlPatterns = { "/sk16100.ex4_1" })

public class ex4_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// セッション session を取得する
		HttpSession session = request.getSession(true);
		// セッション変数 username の値を取得する
        String username = (String)session.getAttribute("username");

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>ex4_1</title>");
		out.println("</head><body>");
		out.println("<h1>フォームからの入力をサーブレット ex4_2 へ渡します。</h1><hr>");

		// セッション変数 username が存在した場合，名前を表示する
		if ( username != null )
			out.println(username + "さん、こんにちは。<br>");

		out.println("お名前を入力してください。<br>");
		out.println("<form action=\"/webapps/sk16100.ex4_2\" method=\"GET\">");
		out.println("<input type=\"text\" name=\"username\" size=32>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("<input type=\"reset\" value=\"クリア\">");
		out.println("</form>");
		out.println("</body></html>");
    }
}
