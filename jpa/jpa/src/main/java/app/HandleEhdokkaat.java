package app;

import java.io.*;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import data.Ehdokkaat;

@WebServlet(urlPatterns = {"/addehdokkaat", "/deleteehdokkaat","/updateehdokkaat","/readehdokkaat","/readtoupdateehdokkaat"})
public class HandleEhdokkaat extends HttpServlet {

	  @Override
	  public void doPost(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
		  doGet(request, response);
	  }
	  
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response) 
	      throws IOException, ServletException {
	  String action = request.getServletPath();
	  List<Ehdokkaat> list=null;
	  switch (action) {
	  case "/addehdokkaat":
		  list=addehdokkaat(request);break;
	  case "/deleteehdokkaat":
		  String ehdokasId=request.getParameter("ehdokasId");
		  list=deleteehdokkaat(request);break;
	  case "/updateehdokkaat":
		  list=updateehdokkaat(request);break;
	  case "/readehdokkaat":
		  list=readehdokkaat(request);break;
	  case "/readtoupdateehdokkaat":
		  Ehdokkaat f=readtoupdateehdokkaat(request);
		  request.setAttribute("ehdokkaat", f);
		  RequestDispatcher rd=request.getRequestDispatcher("./jsp/ehdokkaattoupdateform.jsp");
		  rd.forward(request, response);
		  return;
	  }
	  request.setAttribute("ehdokkaatlist", list);
	  RequestDispatcher rd=request.getRequestDispatcher("./jsp/readehdokkaat.jsp");
	  rd.forward(request, response);
  }

	private Ehdokkaat readtoupdateehdokkaat(HttpServletRequest request) {
		String ehdokasId=request.getParameter("ehdokasId");
		String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/readtoupdateehdokkaat/"+ehdokasId;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		Ehdokkaat ehdokkaat=b.get(Ehdokkaat.class);
		return ehdokkaat;
	}

	private List<Ehdokkaat> addehdokkaat(HttpServletRequest request) {
		Ehdokkaat f = new Ehdokkaat(request.getParameter("ammatti"),request.getParameter("etunimi"),request.getParameter("ika"),request.getParameter("kotipaikkakunta"),request.getParameter("miksiEduskuntaan"),request.getParameter("mitaAsioitaHaluatEdistaa"),request.getParameter("puolue"),request.getParameter("sukunimi"));
		System.out.println(f);
		String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/addehdokkaat";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		// Ehdokkaasta Entity tekstimuodossa
		Entity<Ehdokkaat> e=Entity.entity(f,MediaType.APPLICATION_JSON);
		GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
		List<Ehdokkaat> returnedList=b.post(e, genericList);
		return returnedList;
	}
	
	private List<Ehdokkaat> readehdokkaat(HttpServletRequest request) {
		String ehdokasId=request.getParameter("ehdokasId");
		String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/readehdokkaat";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
		List<Ehdokkaat> returnedList=b.get(genericList);
		return returnedList;
	}
	
	private List<Ehdokkaat> updateehdokkaat(HttpServletRequest request) {
		Ehdokkaat f=new Ehdokkaat(request.getParameter("ehdokasId") ,request.getParameter("ammatti"), request.getParameter("etunimi"), request.getParameter("ika"), request.getParameter("kotipaikkakunta"), request.getParameter("miksiEduskuntaan"), request.getParameter("mitaAsioitaHaluatEdistaa"), request.getParameter("puolue"), request.getParameter("sukunimi"));
		System.out.println(f);
		String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/updateehdokkaat";
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Here we create an Entity of a Fish object as JSON string format
		Entity<Ehdokkaat> e=Entity.entity(f,MediaType.APPLICATION_JSON);
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Ehdokkaat> returnedList=b.put(e, genericList);
		return returnedList;
	}
	
	private List<Ehdokkaat> deleteehdokkaat(HttpServletRequest request) {
		String ehdokasId=request.getParameter("ehdokasId");
		String uri = "http://127.0.0.1:8080/rest/ehdokkaatservice/deleteehdokkaat/"+ehdokasId;
		Client c=ClientBuilder.newClient();
		WebTarget wt=c.target(uri);
		Builder b=wt.request();
		//Create a GenericType to be able to get List of objects
		//This will be the second parameter of post method
		GenericType<List<Ehdokkaat>> genericList = new GenericType<List<Ehdokkaat>>() {};
		
		//Posting data (Entity<ArrayList<DogBreed>> e) to the given address
		List<Ehdokkaat> returnedList=b.delete(genericList);
		return returnedList;
	}
}
