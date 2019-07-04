package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.ex1", urlPatterns = { "/sk16100.ex1" })

public class ex1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");

		// 出力先 out を定義する
		PrintWriter out = response.getWriter();

		// HTMLドキュメントを出力する
		out.println("<html>\n<head>");
		out.println("<title>ex1</title>");
		out.println("</head>\n<body>");
		out.println("簡単なサーブレット");
		out.println("</body>\n</html>");
    }
}
