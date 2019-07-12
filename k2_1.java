package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.k2_1", urlPatterns = { "/sk16100.k2_1" })

public class k2_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");

		// 出力先 out を定義する
		PrintWriter out = response.getWriter();

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>k2_1</title>");
		out.println("</head><body>");
		out.println("<h1>本校への求人企業数一覧</h1><hr>");
		out.println("専門学科（M,A,J,S,K）を選択してください。<br>");
		out.println("<form action=\"/webapps/sk16100.k2_2\" method=\"GET\">");
		out.println("<select name=\"gakka\">");
		out.println("<option value=\"1\">Ｍ");
		out.println("<option value=\"2\">Ａ");
		out.println("<option value=\"3\">Ｊ");
		out.println("<option value=\"4\">Ｓ");
		out.println("<option value=\"5\">Ｋ");
		out.println("</select><br>");
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("</form>");
		out.println("<hr>");
		out.println("No.19　庄司 果鈴<br>");
		out.println("</body></html>");
    }
}
