package com.google.sps.servlets;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    private final List messages = new ArrayList<>(Arrays.asList("Bad Bunny", "SZA", "Rico Nasty", "Frank Ocean", "Joyce Manor"));

    
  @Override
  public void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {

     String json = convertToJsonUsingGson(messages);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  //Converts elements to JSON using Gson Library
    private String convertToJsonUsingGson(List<String> messageList) {
    final Gson gson = new Gson();
    final String json = gson.toJson(messageList);
    return json;
  }
}
