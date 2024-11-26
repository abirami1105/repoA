package com.funfit.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.models.Batch;
import com.funfit.opertions.BatchOperations;


/**
 * Servlet implementation class AddBatch
 */
@WebServlet("/AddBatch")
public class AddBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String time = req.getParameter("time");
		
		Batch batch=new Batch();
		batch.setName(name);
		batch.setTime(time);
		try {
			BatchOperations batchOperations=new BatchOperations();
			batchOperations.addNewBatch(batch);
			RequestDispatcher dispatcher = req.getRequestDispatcher("batch.html"); 
			dispatcher.forward(req, res);
		}catch(Exception e) {
			System.out.print("Exception occured"+e);
		}
		
		
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
