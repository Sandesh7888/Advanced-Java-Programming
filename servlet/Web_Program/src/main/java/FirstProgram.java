import javax.servlet.*;
import java.io.IOException;

public class FirstProgram implements Servlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Servlet initialized");
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("Service method called");
		System.out.println("ok done");
	}

	@Override
	public String getServletInfo() {
		return "FirstProgram Servlet";
	}

	@Override
	public void destroy() {
		System.out.println("Servlet destroyed");
	}
}
