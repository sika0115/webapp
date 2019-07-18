package sk16100;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.k3_1", urlPatterns = { "/sk16100.k3_1" })

public class k3_1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>k3_1</title>");
		out.println("</head><body>");
		out.println("<h1>二項演算</h1><hr>");
		out.println("二つの数値と演算子を指定してください<br>");

		// この部分を完成させる
		Cookie [] cookies1= request.getCookies();
		if (cookies1 != null) {
		   for(int i=0; i<cookies1.length; i++) {
		   	String str = cookies1[i].getName();
		   	if (str.equals("number1")) {
		   		String value = cookies1[i].getValue();
		   		out.println(value);
		   	}
		   }
		}
		Cookie [] cookies2= request.getCookies();
		if (cookies2 != null) {
		   for(int i=0; i<cookies2.length; i++) {
		   	String str = cookies2[i].getName();
		   	if (str.equals("number1")) {
		   		String value = cookies2[i].getValue();
		   		out.println(value);
		   	}
		   }
		}
	//	out.println("<div style=display:inline-flex>");
		out.println("<form><input type=\"text\" name=\"number1\" size=2>");
		out.println("<form action=\"/webapps/sk16100.k3_2\" method=\"GET\">");
		out.println("<select name=\"operator\">");
		out.println("<option value=\"1\">+");
		out.println("<option value=\"2\">-");
		out.println("<option value=\"3\">*");
		out.println("<option value=\"4\">/</select>");
		out.println("<input type=\"text\" name=\"number2\" size=2></form>");
	//	out.println("<div style=display:inline-flex>");
		out.println("<form><input type=\"submit\" value=\"送信\">");
		out.println("<form><input type=\"reset\" value=\"クリア\"></form>");
		
		

		out.println("<hr>");
		out.println("No.19　庄司 果鈴<br>");
		out.println("</body></html>");
    }
}
