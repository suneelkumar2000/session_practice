package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cys.session.dao.CustomerImpl;


@WebServlet("/LoginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		CustomerImpl cus = new CustomerImpl();
		
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		try (PrintWriter out = response.getWriter()) {
			boolean result = cus.customerLogin(uname,pass);
		if(result == true) {
			
			HttpSession session=request.getSession(true);
			session.putValue("username",uname);
			
			response.sendRedirect(request.getContextPath()+"/Second");
			out.println("success");
			
		}else {
			
	    	response.sendRedirect("Login.jsp");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
