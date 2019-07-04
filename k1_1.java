package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.k1_1", urlPatterns = { "/sk16100.k1_1" })

public class k1_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>k1_1</title>");
		out.println("</head><body>");
		out.println("<h1>本校への求人企業数一覧</h1><hr>");
		out.println("開始年度（6～30）を入力してください。<br>");
		out.println("<form action=\"/webapps/sk16100.k1_2\" method=\"GET\">");
		out.println("<input type=\"text\" name=\"year1\" size=2>");
		out.println("<br>");
		out.println("終了年度（6～30）を入力してください。<br>");
		out.println("<input type=\"text\" name=\"year2\" size=2>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("<input type=\"reset\" value=\"クリア\">");
		out.println("</form>");
		out.println("<hr>");
		out.println("No.19　庄司果鈴<br>");
		out.println("</body></html>");
    }
}
