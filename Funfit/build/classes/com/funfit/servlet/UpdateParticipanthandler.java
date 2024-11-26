package com.funfit.servlet;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.opertions.ParticipantOperations;


@WebServlet("/UpdateParticipanthandler")
public class UpdateParticipanthandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int updatedId = Integer.parseInt(request.getParameter("updateId"));
        String updatedName = request.getParameter("updateName");
        String updatedGender = request.getParameter("updateGender");
        int updatedBatchId = Integer.parseInt(request.getParameter("updateBatchId"));

        
        ParticipantOperations participantOperations = null;
		try {
			participantOperations = new ParticipantOperations();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        try {
        	
           
            String result = participantOperations.updateParticipant(updatedId, updatedName, updatedGender, updatedBatchId);

            
            if ("Success".equals(result)) {
                
                response.sendRedirect(request.getContextPath() + "/update-participant");
            } else {
                
                response.sendRedirect("error.html");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Redirect to an error page or handle accordingly
            response.sendRedirect("error.html");
        }
	}

}
