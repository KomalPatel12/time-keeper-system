package edu.ssdi.controller;

 import java.io.IOException;
    import javax.servlet.*;
    import javax.servlet.ServletException;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import javax.sql.DataSource;
    import java.sql.Connection;
    import java.sql.ResultSet;
    import java.sql.PreparedStatement;
    import javax.naming.*;
    public class ChangePassword extends HttpServlet {
private static final long serialVersionUID = 1L;
public ChangePassword() {
    super();
}
protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    String employeeid = request.getParameter("employeeid");
    String Password = request.getParameter("Password");
    String CPassword = request.getParameter("Password");

    Connection con =   GetConnectToDb();
    boolean flag = CheckLogin(Password,CPassword,employeeid,con);
    if(flag==true){
        gotoPage("/LoginPage.jsp",request,response);
    }
    else{
        gotoPage("/ChangeError.jsp",request,response);
    }
}
public void gotoPage(String address, HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(address);
    dispatcher.forward(request, response);
}
public boolean CheckLogin(String Password, String CPassword,String employeeid, Connection con) {
    if (Password != null && CPassword != null && employeeid !=null) {
        try {
            PreparedStatement ps = con.prepareStatement("UPDATE PUBLIC.IAUSERS SET Password = ('"+Password+"') WHERE Email='"+employeeid+"'");
            ResultSet rs = ps.executeQuery();
        while(rs.next()) {
                return true;
            }
        } catch (Exception e) {
        }
    }
    return false;
}
public Connection GetConnectToDb() {

    try {
        InitialContext ctx = new InitialContext();
        Connection con = null;
        DataSource ds = (DataSource) ctx.lookup("java:/DefaultDS");
        con = ds.getConnection();
        return con;
    } catch (Exception e) {
        return null;
    }
}
protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    }}