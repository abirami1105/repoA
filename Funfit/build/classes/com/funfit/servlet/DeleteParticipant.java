package com.funfit.servlet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.opertions.ParticipantOperations;

@WebServlet("/DeleteParticipant")
public class DeleteParticipant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String participantIdString = request.getParameter("pid");

        if (participantIdString != null && !participantIdString.isEmpty()) {
            int pid = Integer.parseInt(participantIdString);

            // Call the deleteParticipant method
            ParticipantOperations participantOperations = null;
			try {
				participantOperations = new ParticipantOperations();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Replace with your actual class
            try {
                String result = participantOperations.deleteParticipant(pid);
                if ("Success".equals(result)) {
                    response.sendRedirect("update-participant"); // Redirect to the participants page after deletion
                } else {
                    // Handle error, e.g., show an error message
                    response.getWriter().println("Error deleting participant.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle SQLException, e.g., show an error message
                response.getWriter().println("Error deleting participant.");
            }
        } else {
            // Handle invalid or missing participantId parameter, e.g., show an error message
            response.getWriter().println("Invalid or missing participantId parameter.");
        }
	}
}
