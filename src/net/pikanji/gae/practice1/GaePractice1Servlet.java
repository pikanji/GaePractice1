package net.pikanji.gae.practice1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GaePractice1Servlet extends HttpServlet {
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello, world");
    Enumeration a = req.getParameterNames();
    while (a.hasMoreElements()) {
      resp.getWriter().println(a.nextElement().toString());
    }
  }
}
