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
		String num1 = null;
		String num2 = null;
		String opestr = null;
		
		Cookie [] cookies= request.getCookies();
		if (cookies != null) {
		   for(int i=0; i<cookies.length; i++) {
		   	String str = cookies[i].getName();
		   	if (str.equals("cnum1")) {
		   		num1 = cookies[i].getValue();
		   	}
		   	if (str.equals("cnum2")) {
		   		num2 = cookies[i].getValue();
		   	}
		   	if (str.equals("ope")) {
		   		opestr = cookies[i].getValue();
		   	}
		   }
		}
		
		out.println("<form action=\"/webapps/sk16100.k3_2\" method=\"GET\">");
		if (cookies != null) {
		   out.println("<input type=\"text\" name=\"number1\" size=5 value=" + num1+ " >");
		} else {
		   out.println("<input type=\"text\" name=\"number1\" size=5>");
		}
		
		out.println("<select name=\"operator\">");
		if (cookies != null && opestr.equals("1")) {
		   out.println("<option value=\"1\"selected>+");
		} else {
		   out.println("<option value=\"1\">+");
		}
		if (cookies != null && opestr.equals("2")) {
		   out.println("<option value=\"2\"selected>-");
		} else {
		   out.println("<option value=\"2\">-");
		}
		if (cookies != null && opestr.equals("3")) {
		   out.println("<option value=\"3\"selected>*");
		} else {
		   out.println("<option value=\"3\">*");
		}
		if (cookies != null && opestr.equals("4")) {
		   out.println("<option value=\"4\"selected>/");
		} else {
		   out.println("<option value=\"4\">/");
		}
		
		if (cookies != null) {
		   out.println("<input type=\"text\" name=\"number2\" size=5 value=" + num2 + " ><br>");
		} else {
		   out.println("<input type=\"text\" name=\"number2\" size=5><br>");
		}
		out.println("<input type=\"submit\" value=\"送信\">");
		out.println("</form>");
		
		out.println("<hr>");
		out.println("No.19　庄司 果鈴<br>");
		out.println("</body></html>");
    }
}
