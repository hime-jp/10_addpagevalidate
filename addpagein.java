package srv;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validate.Validator;

/**
 * Servlet implementation class addpagein
 */
@WebServlet("/src/srv/addpagein")
public class addpagein extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addpagein() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String title, writer, publisher, price, remarks;
		String[] genre;
		String[] stock;

		title = request.getParameter("title");
		writer = request.getParameter("writer");
		publisher = request.getParameter("publisher");
		price = request.getParameter("price");
		genre = request.getParameterValues("genre");
		stock = request.getParameterValues("stock");
		remarks = request.getParameter("remarks");

		Validator validator = new Validator();
		validator.requiredCheck(title, "タイトル");
		validator.maxlengthCheck(writer, "著者");
		validator.MinusCheck(price, "価格");

		String str = validator.getMessage();

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();      

		if(str.length() > 0){
			//エラーの文
			out.println("<h2><span style=color:#F00;>");
			out.println(str);
			out.println("</span></h2>");

		}else{
			//普通の画面    
			out.println("<html>");
			out.println("<head>");
			out.println("  <title>書籍登録確認画面</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("  <h2>■書籍在庫管理システム</h2>");
			out.println("    <h3>　【書籍登録確認画面】</h3>");
			out.println("      <table>");

			/*
		String title, writer, publisher, price, remarks;
		String[] genre;
		String[] stock;

		title = request.getParameter("title");
		writer = request.getParameter("writer");
		publisher = request.getParameter("publisher");
		price = request.getParameter("price");
		genre = request.getParameterValues("genre");
		stock = request.getParameterValues("stock");
		remarks = request.getParameter("remarks");

		Validator validator = new Validator();
		validator.requiredCheck(title, "タイトル");
		validator.minlengthCheck(writer, "著者");
		validator.IntegerCheck(price, "価格");
			 */

			// １：ジャンルのString配列型のデータを、List型に変換

			//		List<String> genrearray = new ArrayList<String>();
			//        
			//		  genrearray.add("0");
			//        genrearray.add("1");
			//        genrearray.add("2");
			//        genrearray.add("3");
			//        genrearray.add("4");

			List<String> genrelist = new ArrayList<String>();

			if(genre != null) {
				genrelist = Arrays.asList(stock);

			}

			List<String>stocklist = Arrays.asList(stock);

			out.println("        <tr><td>　　</td><td>タイトル</td><td><input type=\"text\" name=\"title\" disabled=\"disabled\" value=\"" + title + "\" /></td></tr>");
			out.println("        <tr><td></td><td>著者</td><td><input type=\"text\" name=\"writer\" disabled=\"disabled\" value=\"" + writer + "\" /></td></tr>");
			out.println("        <tr><td></td><td>出版社</td><td><input type=\"text\" name=\"publisher\" disabled=\"disabled\" value=\"" + publisher + "\" /></td></tr>");
			out.println("        <tr><td></td><td>価格</td><td><input type=\"text\" name=\"price\" disabled=\"disabled\" value=\"" + price + "\" /></td></tr>");
			out.println("        <tr><td></td><td>ジャンル</td><td>");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"0\" disabled=\"disabled\" ");

			if(genrelist.contains("0") ) {
				out.println("checked");
			}

			/* if(genrelistに"0"が入っている) {
			 *     out.println(" checked ");
	         }      */

			out.println(" />文芸");

			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"1\" disabled=\"disabled\" ");
			if(genrelist.contains("1") ) {
				out.println("checked");
			}
			/* if(genrelistに"1"が入っている) {
			 *     out.println(" checked ");
	         }      */
			out.println(" />実用");

			/*
			 * 1:文芸のための<input type="checkbox"...>出力
			 * 2:実用のための<input type="checkbox"...>出力
			 * 3:ビジネスのための<input type="checkbox"...>出力
			 * 4:教養のための<input type="checkbox"...>出力
			 * 5:趣味のための<input type="checkbox"...>出力
			 * 
			 * 
			 */


			// ２：ジャンルのListのデータに0が含まれるか
			// genrelist<="0", "2"
			// genrelist<="0", "1", "3"
			// genrelist<="3", "4"
			//genrelist.contains("0")


			//		for(int i = 0; i <= genrelist.size() - 1; i++) {
			//			String value = genrelist.get(i);
			//			if(i == 0) {
			//				out.println("checked />文芸");
			//			} else {
			//				out.println(" />文芸");
			//			}
			//		}

			// ２：ジャンルのListのデータに1が含まれるか

			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"2\" disabled=\"disabled\" ");
			if(genrelist.contains("2") ) {
				out.println("checked");
			}
			out.println("/>ビジネス");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"3\" disabled=\"disabled\" ");
			if(genrelist.contains("3")) {
				out.println("checked");
			}
			out.println("/>教養");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"4\" disabled=\"disabled\" ");
			if(genrelist.contains("4")) {
				out.println("checked");
			}
			out.println("/>趣味</td></tr>");


			out.println("        <tr><td></td><td>在庫</td><td>");
			out.println("          <input type=\"radio\" name=\"stock\" value=\"1\" checked disabled=\"disabled\" ");
			if(stocklist.contains("1")) {
				out.println("checked");
			}
			out.println("/>あり");


			out.println("          <input type=\"radio\" name=\"stock\" value=\"0\" disabled=\"disabled\" ");
			if(stocklist.contains("0")) {
				out.println("checked");
			}
			out.println("/>なし</td></tr>");    
			out.println("        <tr><td></td><td>備考</td><td><textarea name=\"remarks\" cols=\"40\" rows=\"4\" disabled=\"disabled\" value= \"" + remarks + "\" />"+ remarks +"</textarea></td></tr>");
			out.println("        <tr><td></td><td height=\"30\"></td><td></td></tr>");
			out.println("        <tr><td></td><td></td><td align=\"right\">");
			out.println("          <input type=\"submit\" onclick=\"window.history.back();\" value=\"キャンセル\" />");
			out.println("      </table>");
			out.println("    </form>");
			out.println("</body>");
			out.println("</html>");
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	//デバッグ用やで
	public static void main(String[] args) {
		System.out.println("aaa");
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("5");

		System.out.println("1が入っている：" + list.contains("1"));
		System.out.println("2が入っている：" + list.contains("2"));
	}

}
