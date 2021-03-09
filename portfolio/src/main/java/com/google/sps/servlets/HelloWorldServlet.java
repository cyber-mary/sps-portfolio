package com.google.sps.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {
    private final ArrayList<String> messages = new ArrayList<String>();

    
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    messages.add("Bad Bunny");
    messages.add("SZA");
    messages.add("Rico Nasty");
    messages.add("Frank Ocean");
    messages.add("Joyce Manor");

    String json = convertToJsonUsingGson(messages);

    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
    private String convertToJsonUsingGson(ArrayList<String> messageList) {
    Gson gson = new Gson();
    String json = gson.toJson(messageList);
    return json;
  }
}
