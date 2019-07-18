package sk16100;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex5_1", urlPatterns = { "/sk16100.ex5_1" })

public class ex5_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();

		out.println("<html><head>");
		out.println("<title>ex5_1</title>");
		out.println("</head><body>");
		out.println("<h1>フォームからの入力をサーブレット ex5_2 へ渡します。</h1><hr>");

		// 全クッキーを取得
		Cookie [] cookies = request.getCookies();
		if (cookies != null) {
	    	for (int i = 0; i < cookies.length; i ++) {
				String str = cookies[i].getName();
				// クッキー username が存在する場合，その内容を表示する
				if (str.equals("username")) {
		    		String value = cookies[i].getValue();
					// 取得した文字列をUTF8でURLデコードする
		    		value = URLDecoder.decode(value, "utf-8");
		    		out.println(value + " さん、こんにちは。<br>");
				}
	    	}
		}

		out.println("お名前を入力してください。<br>");
		out.println("<form action=\"/webapps/sk16100.ex5_2\" method=\"GET\">");
		out.println("<input type=\"text\" name=\"username\" size=32>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("<input type=\"reset\" value=\"クリア\">");
		out.println("</form>");
		out.println("</body></html>");
    }
}
