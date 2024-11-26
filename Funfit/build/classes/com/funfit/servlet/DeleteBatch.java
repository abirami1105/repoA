package com.funfit.servlet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.opertions.BatchOperations;

@WebServlet("/DeleteBatch")
public class DeleteBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchIdString = request.getParameter("bid");

		   if (batchIdString != null && !batchIdString.isEmpty()) {
		       int batchId = Integer.parseInt(batchIdString);

		       // Call the deleteBatch method
		       BatchOperations batchOperations = null;
		       try {
		           batchOperations = new BatchOperations();
		       } catch (Exception e) {
		           e.printStackTrace();
		       }
		       try {
		           String result = batchOperations.deleteBatch(batchId);
		           if ("Success".equals(result)) {
		               response.sendRedirect("batchList"); // Redirect to the batch-list page after deletion
		           } else {
		               // Handle error, e.g., show an error message
		               response.getWriter().println("Error deleting batch.");
		           }
		       } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		           
		       }
		   } else {
		       // Handle invalid or missing batchId parameter, e.g., show an error message
		       response.getWriter().println("Invalid or missing batchId parameter.");
		   }
	}

}
