package sk16100;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import javax.imageio.stream.*;

@WebServlet(name = "sk16100.ex3", urlPatterns = { "/sk16100.ex3" })

public class ex3 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws  IOException, ServletException {

		// 出力形式を設定する
		response.setContentType("image/jpeg; charset=UTF-8");

		// 画像用バッファの確保
		BufferedImage bi = new BufferedImage(300, 200, BufferedImage.TYPE_INT_RGB);

		// Graphicsオブジェクトの生成
		Graphics g = bi.getGraphics();

		// 描画命令
		g.setColor(Color.green);
		g.fillRect(0, 0, 300, 200);
		g.setColor(new Color(255, 255, 0));
		g.fillRect(20, 20, 260, 160);
		g.setColor(Color.pink);
		g.fillOval(110, 60, 80, 80);
		g.setFont(new Font("MS Gothic", Font.BOLD, 20));
		g.setColor(new Color(0, 100, 255));
		g.drawString("情報科学・工学実験 Ⅲ", 40, 170);

		// 画像出力に必要な処理
		ServletOutputStream sout = response.getOutputStream();
		Iterator ite = ImageIO.getImageWritersByFormatName("jpeg");
		ImageWriter w = (ImageWriter)ite.next();
		ImageOutputStream ios = ImageIO.createImageOutputStream(sout);
		w.setOutput(ios);
		w.write(bi);

		// 終了処理
		sout.close();
		g.dispose();
	}
}
