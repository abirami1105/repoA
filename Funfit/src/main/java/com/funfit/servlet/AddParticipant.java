package com.funfit.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


import com.funfit.models.Batch;
import com.funfit.models.Participant;
import com.funfit.opertions.BatchOperations;
import com.funfit.opertions.ParticipantOperations;

@WebServlet("/AddParticipant")
public class AddParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    // Retrieve participant details from the request
	    String name = req.getParameter("name");
	    String gender = req.getParameter("gender");
	    String batchId = req.getParameter("batchId");
	    
	    Participant participant = new Participant();
        participant.setName(name);
        participant.setGender(gender);
        participant.setBatchId(Integer.parseInt(batchId));

	    try {
	    	
	        ParticipantOperations participantOperations = new ParticipantOperations();
	        participantOperations.addNewParticipant(participant);

	        // Forward the request to a confirmation page
	        RequestDispatcher dispatcher = req.getRequestDispatcher("display.html");
	        dispatcher.forward(req, res);

	    } catch (NumberFormatException e) {
	        // Handle invalid age input
	        res.getWriter().println("Invalid age format. Please provide a valid number for age.");
	    } catch (Exception e) {
	        // Handle other exceptions
	        System.out.print("Exception occurred: " + e);
	        res.getWriter().println("An error occurred while adding the participant. Please try again.");
	    }
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
	

	
}
