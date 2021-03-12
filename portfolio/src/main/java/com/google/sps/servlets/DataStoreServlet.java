package com.google.sps.servlets;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.FullEntity;
import com.google.cloud.datastore.KeyFactory;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

@WebServlet("/form-handler")
public class DataStoreServlet extends HttpServlet {

  @Override
    public void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
        String nameValue = Jsoup.clean(request.getParameter("name-input"), Whitelist.none());
        String textValue = Jsoup.clean(request.getParameter("text-input"), Whitelist.none());
        // String nameValue = request.getParameter("name-input");
        // String textValue = request.getParameter("text-input");
        long timestamp = System.currentTimeMillis();
        // Print the value so you can see it in the server logs.
        System.out.println("You submitted your name as " + nameValue + "and the following message " + textValue);
        Datastore datastore = DatastoreOptions.getDefaultInstance().getService();
        KeyFactory keyFactory = datastore.newKeyFactory().setKind("Contact");
        FullEntity contactEntity =
        Entity.newBuilder(keyFactory.newKey())
            .set("timestamp", timestamp)
            .set("name", nameValue)
            .set("text-input", textValue)
            .build();
        datastore.put(contactEntity);
        //redirect 
        response.sendRedirect("thanks.html");
  }
}