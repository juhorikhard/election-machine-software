package app;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;



@WebServlet("/loginServlet")

public class loginServlet extends HttpServlet {

	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
	}
	
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    	
    	String username2 = ("admin");
    	String username = request.getParameter("username");
    	
    	
    	String password2 = ("admin");
    	String password = request.getParameter("password");
    	
    	
    	boolean test1 = username.equals(username2);
    	boolean test2 = password.equals(password2);
    	PrintWriter writer = response.getWriter();
    	
    	if (test1 == true && test2 == true){
    		 
    	      System.out.println("Tervetuloa admin");
    	      String htmlRespone = "<html>";
    	        htmlRespone += "<link rel=\"stylesheet\" href=\"/css/style.css\">";
    	        htmlRespone += "<div class=\"topnav\">\r\n"
    	        		+ "  <a href=\"/index.html\">Etusivu</a>\r\n"
    	        		+ "</div>";
    	        htmlRespone += "<div class=\"content\">";
    	        htmlRespone += "<h1>Muokkaa</h1>";
    	        htmlRespone += "<a href='/showquestion'>Näytä Kysymykset</a><br><br>";   
    	        htmlRespone += "<a href='/jsp/readehdokkaat.jsp'>Näytä Ehdokkaat</a><br>";
    	        htmlRespone += "</div>";
    	        htmlRespone += "</html>";
    	        
    	        writer.println(htmlRespone);
    	}
    	else {
    		System.out.println("Kirjautuminen epäonnistui");
    	}
    	

    }
}
