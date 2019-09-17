package jdbcweb;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/QueryServlet")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String[]> list = null;
		String msg = null;
		String id = request.getParameter("id");
		Service service = new Service();
		if(id != null ) {
			list = service.getEmp(id);
			if (list.size() == 0) {
				msg = "員工ID編號"+id+"不存在";
				request.setAttribute("msg", msg);
			}else {
				msg = "員工ID編號"+id+"的資料";
				request.setAttribute("msg", msg);
			}
		}
		if (id == "") {
			msg = "請輸入員工ID";
			request.setAttribute("msg", msg);
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/query.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
