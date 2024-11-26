package com.funfit.servlet;

import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.models.Participant;
import com.funfit.opertions.ParticipantOperations;

@WebServlet("/UpdateParticipant")
public class UpdateParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParticipantOperations participantOperations = null;
		try {
			participantOperations = new ParticipantOperations();
		} catch (Exception e) {
			e.printStackTrace();
		}
        try {
            
            List<Participant> participants = participantOperations.viewAllParticipants();

            
            request.setAttribute("participants", participants);

            // Forward the request to the update-participants.html page
            request.getRequestDispatcher("/update-participant.jsp").forward(request, response);
            

        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving participants");
        }

	}

}
