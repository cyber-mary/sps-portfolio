package com.google.sps.servlets;

// import java.io.IOException;
// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet("/form-handler")
// public class FormHandlerServlet extends HttpServlet {

//   @Override
//   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

//     // Get the value entered in the form.
//     String nameValue = request.getParameter("name-input");
//     String textValue = request.getParameter("text-input");

//     // Print the value so you can see it in the server logs.
//     System.out.println("You submitted your name as " + nameValue + "and the following message " + textValue);

//     //redirect 
//     response.sendRedirect("thanks.html");
//     // Write the value to the response so the user can see it.
//     response.getWriter().println("You submitted your name as: " + nameValue + "\n And the following message: " + textValue);
//   }
// }