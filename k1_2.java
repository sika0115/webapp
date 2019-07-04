package sk16100;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "sk16100.k1_2", urlPatterns = { "/sk16100.k1_2" })

public class k1_2 extends HttpServlet {
	private int [][] kdata = {
	//   年度　M    A    J    S    K
		{ 30, 746, 788, 629, 461, 547 },
		{ 29, 742, 775, 540, 422, 525 },
		{ 28, 702, 727, 476, 416, 518 },
		{ 27, 640, 631, 523, 415, 512 },
		{ 26, 509, 487, 429, 297, 425 },
		{ 25, 435, 383, 333, 213, 261 },
		{ 24, 235, 236, 287,  95, 113 },
		{ 23, 332, 350, 242, 156, 137 },
		{ 22, 332, 350, 254, 156, 133 },
		{ 21, 381, 400, 288, 160, 137 },
		{ 20, 540, 590, 412, 200, 179 },
		{ 19, 579, 603, 430, 270, 200 },
		{ 18, 504, 480, 344, 208, 155 },
		{ 17, 321, 330, 256, 130, 105 },
		{ 16, 279, 301, 220, 126,  73 },
		{ 15, 190, 233, 169,  74,  49 },
		{ 14, 213, 231, 172,  93,  85 },
		{ 13, 269, 270, 207, 135, 106 },
		{ 12, 237, 235, 189, 129, 161 },
		{ 11, 203, 242, 162, 106, 130 },
		{ 10, 262, 288, 195, 125, 120 },
		{  9, 268, 326, 206, 142, 171 },
		{  8, 200, 244, 149, 105, 215 },
		{  7, 175, 213, 102,  75,  94 },
		{  6, 187, 198,  81,  86, 209 }
	};

    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("text/html; charset=UTF-8");
		// 出力先 out を定義する
		PrintWriter out = response.getWriter();
		// HTTPリクエストのエンコーディングを UTF-8 とする
		request.setCharacterEncoding("utf-8");

		// この部分を完成させる
		
		String year1string = request.getParameter("year1"); 
		String year2string = request.getParameter("year2");

 		if (year1string.isEmpty()) {
			year1string = "6";
		}
		if (year2string.isEmpty()) {
			year2string = "30";
		}

		out.println("<html><head>");
		out.println("<title>k1_2</title>");
		out.println("</head><body>");
		out.println("<h1>本校への求人企業数一覧</h1><hr>");
		out.println("平成" + year1string + "年度～平成" + year2string+ "年度の求人企業数を表示します<br>");
		out.println("<table border = 1 style = border-collapse: collapse>");
		out.println("<tr><th>年度</th> <th>M</th> <th>A</th> <th>J</th> <th>S</th> <th>K</th></tr>");
		
		int year1 =  Integer.parseInt(year1string);
		int year2 =  Integer.parseInt(year2string);

		if (year1 < 6) {
			year1 = 6;
		}
		if (year1 > 30) {
			year1 = 30;
		}
		if (year2 < 6) {
			year2 = 6;
		}
		if (year2 > 30) {
			year2 = 30;
		}


		for (int i = 0; i < 30; i++) {
			out.println("<tr><td>" + kdata[30-year1][0] + "</td> <td> " + kdata[30-year1][1] + "</td> <td> " + kdata[30-year1][2] + " </td> <td> " + kdata[30-year1][3] + "</td> <td>" + kdata[30-year1][4] + "</td> <td> " + kdata[30-year1][5] + "</td>");
			year1 = year1 + 1;
			if(year1 > year2) {
				break;
			}
		}
		

		out.println("</table>");

		out.println("<hr>");
		out.println("<form action=\"/webapps/sk16100.k1_1\" method=\"GET\">");
		out.println("<input type=\"submit\" value=\"もどる\">");
		out.println("</form>");
		out.println("No.19　庄司果鈴<br>");
		out.println("</body></html>");
    }
}
