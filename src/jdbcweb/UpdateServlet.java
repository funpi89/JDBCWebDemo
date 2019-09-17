package jdbcweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String employeeid = request.getParameter("employeeid");
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String birthdate = request.getParameter("birthdate");
		
		if (lastname == null) {
			lastname = "";
		}
		if (firstname == null) {
			firstname = "";
		}
		if (birthdate == null) {
			birthdate = "";
		}
		
		
		Service service = new Service();
		if(employeeid != null )
			service.updateEmp(employeeid, lastname, firstname, birthdate);
		
		List<String[]> list = service.findAllEmp();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/update.jsp").forward(request, response);
	}

}
