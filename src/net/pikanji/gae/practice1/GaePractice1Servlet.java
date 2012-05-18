package net.pikanji.gae.practice1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
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

          if (user != null) {
              resp.setContentType("text/plain");
              resp.getWriter().println("Hello, " + user.getNickname());
          } else {
              resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
          }
//          TkgBmAccount tkgBmUser = new TkgBmAccount(user);

//          PersistenceManager pm = PersistenceManagerFactorySingleton.get().getPersistenceManager();
//          try {
//              pm.makePersistent(tkgBmUser);
//          } finally {
//              pm.close();
//          }
              
          Enumeration a = req.getParameterNames();
          while (a.hasMoreElements()) {
              resp.getWriter().println(a.nextElement().toString());
          }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        
        userService.isUserLoggedIn();
        
        resp.setContentType("application/json; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("{name:'kanji',age:'32'}");
    }
    
    
}
