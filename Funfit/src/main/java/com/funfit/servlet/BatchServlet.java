package com.funfit.servlet;

import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.funfit.models.Batch;
import com.funfit.opertions.BatchOperations;

@WebServlet("/BatchServlet")
public class BatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
            BatchOperations batchOperations = new BatchOperations();
            List<Batch> batchList = batchOperations.viewAllBatches();
            request.setAttribute("batchList", batchList);
            request.getRequestDispatcher("batchList.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
         
        }
	}

	

}
