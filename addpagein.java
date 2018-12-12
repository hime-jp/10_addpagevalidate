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
		validator.requiredCheck(title, "�^�C�g��");
		validator.maxlengthCheck(writer, "����");
		validator.MinusCheck(price, "���i");

		String str = validator.getMessage();

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();      

		if(str.length() > 0){
			//�G���[�̕�
			out.println("<h2><span style=color:#F00;>");
			out.println(str);
			out.println("</span></h2>");

		}else{
			//���ʂ̉��    
			out.println("<html>");
			out.println("<head>");
			out.println("  <title>���Гo�^�m�F���</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("  <h2>�����Ѝ݌ɊǗ��V�X�e��</h2>");
			out.println("    <h3>�@�y���Гo�^�m�F��ʁz</h3>");
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
		validator.requiredCheck(title, "�^�C�g��");
		validator.minlengthCheck(writer, "����");
		validator.IntegerCheck(price, "���i");
			 */

			// �P�F�W��������String�z��^�̃f�[�^���AList�^�ɕϊ�

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

			out.println("        <tr><td>�@�@</td><td>�^�C�g��</td><td><input type=\"text\" name=\"title\" disabled=\"disabled\" value=\"" + title + "\" /></td></tr>");
			out.println("        <tr><td></td><td>����</td><td><input type=\"text\" name=\"writer\" disabled=\"disabled\" value=\"" + writer + "\" /></td></tr>");
			out.println("        <tr><td></td><td>�o�Ŏ�</td><td><input type=\"text\" name=\"publisher\" disabled=\"disabled\" value=\"" + publisher + "\" /></td></tr>");
			out.println("        <tr><td></td><td>���i</td><td><input type=\"text\" name=\"price\" disabled=\"disabled\" value=\"" + price + "\" /></td></tr>");
			out.println("        <tr><td></td><td>�W������</td><td>");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"0\" disabled=\"disabled\" ");

			if(genrelist.contains("0") ) {
				out.println("checked");
			}

			/* if(genrelist��"0"�������Ă���) {
			 *     out.println(" checked ");
	         }      */

			out.println(" />���|");

			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"1\" disabled=\"disabled\" ");
			if(genrelist.contains("1") ) {
				out.println("checked");
			}
			/* if(genrelist��"1"�������Ă���) {
			 *     out.println(" checked ");
	         }      */
			out.println(" />���p");

			/*
			 * 1:���|�̂��߂�<input type="checkbox"...>�o��
			 * 2:���p�̂��߂�<input type="checkbox"...>�o��
			 * 3:�r�W�l�X�̂��߂�<input type="checkbox"...>�o��
			 * 4:���{�̂��߂�<input type="checkbox"...>�o��
			 * 5:��̂��߂�<input type="checkbox"...>�o��
			 * 
			 * 
			 */


			// �Q�F�W��������List�̃f�[�^��0���܂܂�邩
			// genrelist<="0", "2"
			// genrelist<="0", "1", "3"
			// genrelist<="3", "4"
			//genrelist.contains("0")


			//		for(int i = 0; i <= genrelist.size() - 1; i++) {
			//			String value = genrelist.get(i);
			//			if(i == 0) {
			//				out.println("checked />���|");
			//			} else {
			//				out.println(" />���|");
			//			}
			//		}

			// �Q�F�W��������List�̃f�[�^��1���܂܂�邩

			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"2\" disabled=\"disabled\" ");
			if(genrelist.contains("2") ) {
				out.println("checked");
			}
			out.println("/>�r�W�l�X");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"3\" disabled=\"disabled\" ");
			if(genrelist.contains("3")) {
				out.println("checked");
			}
			out.println("/>���{");


			out.println("          <input type=\"checkbox\" name=\"genre\" value=\"4\" disabled=\"disabled\" ");
			if(genrelist.contains("4")) {
				out.println("checked");
			}
			out.println("/>�</td></tr>");


			out.println("        <tr><td></td><td>�݌�</td><td>");
			out.println("          <input type=\"radio\" name=\"stock\" value=\"1\" checked disabled=\"disabled\" ");
			if(stocklist.contains("1")) {
				out.println("checked");
			}
			out.println("/>����");


			out.println("          <input type=\"radio\" name=\"stock\" value=\"0\" disabled=\"disabled\" ");
			if(stocklist.contains("0")) {
				out.println("checked");
			}
			out.println("/>�Ȃ�</td></tr>");    
			out.println("        <tr><td></td><td>���l</td><td><textarea name=\"remarks\" cols=\"40\" rows=\"4\" disabled=\"disabled\" value= \"" + remarks + "\" />"+ remarks +"</textarea></td></tr>");
			out.println("        <tr><td></td><td height=\"30\"></td><td></td></tr>");
			out.println("        <tr><td></td><td></td><td align=\"right\">");
			out.println("          <input type=\"submit\" onclick=\"window.history.back();\" value=\"�L�����Z��\" />");
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


	//�f�o�b�O�p���
	public static void main(String[] args) {
		System.out.println("aaa");
		ArrayList<String> list = new ArrayList<String>();
		list.add("0");
		list.add("1");
		list.add("5");

		System.out.println("1�������Ă���F" + list.contains("1"));
		System.out.println("2�������Ă���F" + list.contains("2"));
	}

}
