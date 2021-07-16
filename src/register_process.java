import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class register_process extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	Connection con1=null;
	ResultSet rs=null;
	Statement st=null;
	int x;

 
    public register_process() 
    {
        super();
    }

	public void init(ServletConfig config) throws ServletException
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/pro","root","PR1234567890@");
		
		}
		catch(Exception e)
		{
			System.out.println("no");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
		String a=request.getParameter("nm").trim();
		String b=request.getParameter("psw").trim();
		String c=request.getParameter("email").trim();
	if((a=="")||(b=="")||(c==""))
	{
		PrintWriter pw=response.getWriter();
		pw.print("Rewrite");
		 RequestDispatcher rd=request.getRequestDispatcher("register.html");
		  rd.include(request,response);
	}
	else if(a.contains("@gmail.com")==false)
	{
		System.out.println("no");
	}
	else {
				  try {
					  String sql = 
							  "insert into register values (?,?,?)";
							  PreparedStatement pst = 
							  con1.prepareStatement(sql);
							  pst.setString(1,a);
							  pst.setString(2,b);
							  pst.setString(3,c);
							  pst.executeUpdate();
							  RequestDispatcher rd=request.getRequestDispatcher("Home_pg.html");
							  rd.include(request,response);
				  		} 
				  catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

			
		
		
	}

}
