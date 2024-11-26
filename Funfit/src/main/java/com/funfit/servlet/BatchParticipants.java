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
import com.funfit.opertions.BatchOperations;

@WebServlet("/BatchParticipants")
public class BatchParticipants extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Inside doGet method of BatchParticipantsServlet");

        BatchOperations batchOperations = null;
        List<Batch> batchesWithParticipants = null;

        try {
            batchOperations = new BatchOperations();
            batchesWithParticipants = batchOperations.getBatchesWithParticipants();
        } catch (SQLException e) {
            e.printStackTrace();
            // Redirect or handle the exception
        } catch (Exception e) {
            e.printStackTrace();
            // Handle other exceptions
        } finally {
            if (batchOperations != null) {
                
            }
        }

        request.setAttribute("batchesWithParticipants", batchesWithParticipants);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
