package ca.nait.dmit.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class HtmlFormFilter
 */
@WebFilter("/servlet/*")
public class HtmlFormFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HtmlFormFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// Log all parameter name/value pairs for debugging
		ServletContext application = request.getServletContext();
		Enumeration<String> iterator = request.getParameterNames();
		application.log("HTML Form submissions with the following name/value pairs:");
		while ( iterator.hasMoreElements() ) {
			String parameterName = iterator.nextElement();
			application.log(parameterName + ":" + request.getParameter(parameterName));
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
