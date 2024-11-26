package com.funfit.servlet;

import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.models.Batch;
import com.funfit.models.Participant;
import com.funfit.opertions.BatchOperations;

/**
 * Servlet implementation class BatchDetails
 */
@WebServlet("/BatchDetails")
public class BatchDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
   	 String bidString = req.getParameter("bid");	
   	 if(bidString != null && !bidString.isEmpty()) {
            try {
                int batchId = Integer.parseInt(bidString);
                
                BatchOperations batchOperations = null;
				try {
					batchOperations = new BatchOperations();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Batch batch = batchOperations.getBatchById(batchId);

               if (batch != null) {
                   List<Participant> participants = batchOperations.getParticipantsForBatch(batchId);

                   // Set attributes in the request
                   req.setAttribute("batch", batch);
                   req.setAttribute("participants", participants);
                   req.getRequestDispatcher("/batchlist.html").forward(req, res);
                   
               } else {
                   // Handle case when batch is not found
                   res.getWriter().println("Batch not found for ID: " + batchId);
               }
           } catch (NumberFormatException e) {
               // Handle invalid batchId parameter (not a number)
               res.getWriter().println("Invalid batchId parameter. Please provide a valid number.");
           } catch (SQLException e) {
               e.printStackTrace();
               // Handle SQLException, e.g., show an error message
               res.getWriter().println("Error fetching batch details.");
           } finally {
               // Close resources (if necessary)
               
           }
       } else {
           // Handle missing batchId parameter
           res.getWriter().println("Missing batchId parameter. Please provide a batchId.");
       }
   }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
