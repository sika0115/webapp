package sk16100;

import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.k3_2", urlPatterns = { "/sk16100.k3_2" })

public class k3_2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// HTTPリクエストのエンコーディングを UTF-8 とする
		request.setCharacterEncoding("utf-8");

		// HTMLドキュメントを出力する
		out.println("<html><head>");
		out.println("<title>k3_2</title>");
		out.println("</head><body>");
		out.println("<h1>二項演算</h1><hr>");

		// この部分を完成させる
		String strnum1 = request.getParameter("number1");
		String strnum2 = request.getParameter("number2");
		
		//空欄の判定と文字列であるかどうかの判定
		if (strnum1.isEmpty()) {
			strnum1 = "1";
		}
		for (int i=0; i<strnum1.length(); i++) {
		   if (Character.isDigit(strnum1.charAt(i))) {
		   	continue;
		   } else {
		   	strnum1 = "1";
		   }
		}
		
		if (strnum2.isEmpty()) {
			strnum1 = "1";
		}
		for (int i=0; i<strnum2.length(); i++) {
		   if (Character.isDigit(strnum2.charAt(i))) {
		   	continue;
		   } else {
		   	strnum2 = "1";
		   }
		}
		
		//double型変換
		double num1 = Double.parseDouble(strnum1);
		double num2 = Double.parseDouble(strnum2);
		
		String optionstr = request.getParameter("operator");
		int optionnum = Integer.parseInt(optionstr);
		
		//演算
		double result = 0;
		if (optionnum == 1) {
			result = num1 + num2;
			out.println("<h1>("+ num1 + ")+(" + num2 + ")=" + result +"</h1>");
		}
		if (optionnum == 2) {
			result = num1 - num2;
			out.println("<h1>("+ num1 + ")-(" + num2 + ")=" + result +"</h1>");
		}
		if (optionnum == 3) {
			result = num1 * num2;
			out.println("<h1>("+ num1 + ")*(" + num2 + ")=" + result +"</h1>");
		}
		if (optionnum == 4) {
			result = num1 / num2;
			out.println("<h1>("+ num1 + ")/(" + num2 + ")=" + result +"</h1>");
		} 
		
	
		//String cnum1 = URLEncoder.encode(number1,"utf-8");
		Cookie cookie1 = new Cookie("cnum1",strnum1 );
		response.addCookie(cookie1);
	
		//String cnum2 = URLEncoder.encode(number2,"utf-8");
		Cookie cookie2 = new Cookie("cnum2", strnum2);
		response.addCookie(cookie2);
		
		
		
		out.println("<hr>");
		out.println("<form action=\"/webapps/sk16100.k3_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\"></form>");
		out.println("No.19　庄司 果鈴<br>");
		out.println("</body></html>");
    }
}
