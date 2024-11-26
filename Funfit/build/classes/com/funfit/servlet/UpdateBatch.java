package com.funfit.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.opertions.BatchOperations;

@WebServlet("/UpdateBatch")
public class UpdateBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String batchIdString = request.getParameter("updateId");
	     String updatedName = request.getParameter("updateName");
	     String updatedTime = request.getParameter("updateTime");

	     if (batchIdString != null && !batchIdString.isEmpty()) {
	         int batchId = Integer.parseInt(batchIdString);

	         // Call the updateBatch method
	         BatchOperations batchOperations = null;
	         try {
	             batchOperations = new BatchOperations();
	         } catch (Exception e) {
	             e.printStackTrace();
	         }
	         try {
	             String result = batchOperations.updateBatch(batchId, updatedName, updatedTime);
	             if ("Success".equals(result)) {
	                 response.sendRedirect("batchList"); // Redirect to the batch-list page after update
	             } else {
	                 // Handle error, e.g., show an error message
	                 response.getWriter().println("Error updating batch.");
	             }
	         } finally {
	             
	         }
	     } else {
	         // Handle invalid or missing batchId parameter, e.g., show an error message
	         response.getWriter().println("Invalid or missing batchId parameter.");
	     }
	}

}
