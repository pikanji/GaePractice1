package net.pikanji.gae.practice1;

import java.io.IOException;
import java.util.Enumeration;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class GaePractice1Servlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

          UserService userService = UserServiceFactory.getUserService();
          User user = userService.getCurrentUser();

          
          PersistenceManager pm = PersistenceManagerFactorySingleton.get().getPersistenceManager();
          try {
              pm.makePersistent(greeting);
          } finally {
              pm.close();
          }
          
          resp.setContentType("text/plain");
          resp.getWriter().println("Hello, world");
          Enumeration a = req.getParameterNames();
          while (a.hasMoreElements()) {
              resp.getWriter().println(a.nextElement().toString());
          }
    }
}
