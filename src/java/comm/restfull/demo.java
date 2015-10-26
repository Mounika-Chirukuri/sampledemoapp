/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comm.restfull;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * REST Web Service
 *
 * @author miracle
 */
@XmlRootElement

@Path("generic")
public class demo {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of demo
     */
    public demo() {
    }

    /**
     * Retrieves representation of an instance of comm.restfull.demo
     *
     * @return an instance of java.lang.String
     */
    //@FormParam("name") String name,@FormParam("pwd") String pwd
    @GET
    @Path("/employee")
    @Produces("application/xml")
    public String getHtml() {
        String output = null;
        String response1 = null;
        try {

            URL url = new URL("http://www.webservicex.net/CurrencyConvertor.asmx/ConversionRate?FromCurrency=USD&ToCurrency=INR");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            //  String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                response1 = output;

                //System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        //  return "<rss version='2.0'><channel><title>RSS Title</title></channel></rss>";
        //return "<hello>"+"hi sample data"+"</hello>";//+name+pwd;
// end of switch
        return response1;

    } // end of 

    @GET
    @Path("/employee1")
    @Produces("application/xml")
    public String getHtml1() {

        return "<rss version='2.0'><channel><title>RSS Title</title></channel></rss>";
        //return "<hello>"+"hi sample data"+"</hello>";//+name+pwd;
// end of switch

    }

    @GET
    @Path("/sap")
    public String getUsers() {
        String output = null;
        String response1 = null;

        try {

            URL url = new URL("https://api.apim.ibmcloud.com/miracle-software-systems-inc2/sb/sapapi/V1/sapoperation?Kunnr=0000903030&Siteid=SCANSOURCE&SsItem=AVA-237703,LO-E632206&client_id=f82d7870-fd04-4979-8b50-11a9061dea32" );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            //  String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                response1 = output;
                //System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        //  return "<rss version='2.0'><channel><title>RSS Title</title></channel></rss>";
        //return "<hello>"+"hi sample data"+"</hello>";//+name+pwd;
// end of switch
        return response1;
        //return "<rss version='2.0'><channel><id>" + id + "</id><cmp>" + cmp.toArray()[0] + "</cmp></channel></rss>";

    }
       @GET
    @Path("/CI")
    @Produces("application/xml")
    public String getUsers1() {
        String output = null;
        String response1 = null;
       final String userid = "admin@eval579364";
		 final String pwd = "changeIt!";
         String addressXML="";
        

        try {
           /* Authenticator.setDefault(new Authenticator() {

                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(name, password.toCharArray());
                }
            });*/
            URL url = new URL("https://eval-provide.castiron.com/env/Development/DEMO");
            HttpURLConnection myURLConnection = (HttpURLConnection)url.openConnection();
String userCredentials = "name:password";

myURLConnection.setRequestProperty ("Authorization", userCredentials);
myURLConnection.setRequestMethod("POST");
myURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//myURLConnection.setRequestProperty("Content-Length", "" + Integer.toString(postData.getBytes().length));
myURLConnection.setRequestProperty("Content-Language", "en-US");
myURLConnection.setUseCaches(false);
myURLConnection.setDoInput(true);
myURLConnection.setDoOutput(true);
            //String authStringEnc = new BASE64Encoder().encode(authString.getBytes());
            // System.out.println("Base64 encoded auth string: " + authStringEnc);
            System.out.println(url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            
            //     conn.setRequestProperty("Authorization", "Basic " + authString);
            // conn.setRequestMethod("POST");
         //   conn.setRequestProperty("Accept", "application/xml");
            conn.connect();
            System.out.println("1");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));
            //  String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                response1 = output;
                //System.out.println(output);
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        //  return "<rss version='2.0'><channel><title>RSS Title</title></channel></rss>";
        //return "<hello>"+"hi sample data"+"</hello>";//+name+pwd;
// end of switch
        return response1;
        //return "<rss version='2.0'><channel><id>" + id + "</id><cmp>" + cmp.toArray()[0] + "</cmp></channel></rss>";

    }
    
    @POST
    @Path("query1")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register(@FormParam("name1") String name, @FormParam("cmp1") String cmp1) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            pst.setString(1, name);
            pst.setString(2, cmp1);

            int result = pst.executeUpdate();
            System.out.println(result);

            /*Customer cust = new Customer();
             cust.setName(na);
             cust.setMail(email);
            
             custMap.put(na, cust);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    /* 
     @POST
     @Path("insertion")
     @Produces(MediaType.TEXT_HTML)
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public String register(@FormParam("passhash") String passhash, @FormParam("email") String email,@FormParam("$pswdhash") String pwd, @FormParam("phno") String phno) {
     try {
     Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
     PreparedStatement pst = con.prepareStatement("insert  into  MMX_REGISTRATION(name,email,pswd,phno) values(?,?,?,?)");
     pst.setString(1, passhash);
     pst.setString(2, email);
     pst.setString(3, pwd);
     pst.setString(4, phno);

     int result = pst.executeUpdate();
     System.out.println(result);

     /*Customer cust = new Customer();
     cust.setName(na);
     cust.setMail(email);
            
     custMap.put(na, cust);*/
    /*} catch (Exception e) {
     e.printStackTrace();
     }
     return "success";
     //return "listform.html";
     }
     */
    @POST
    @Path("image")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String image(@FormParam("passhash") String passhash) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            PreparedStatement pst = con.prepareStatement("insert  into  image(image) values(?)");
            pst.setString(1, passhash);

            int result = pst.executeUpdate();
            System.out.println(result);

            /*Customer cust = new Customer();
             cust.setName(na);
             cust.setMail(email);
            
             custMap.put(na, cust);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
        //return "listform.html";
    }

    @POST
    @Path("insertion1")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register22(@FormParam("passhash") String passhash, @FormParam("email") String email, @FormParam("$pswdhash") String pwd, @FormParam("phno") String phno, @FormParam("lname") String lname, @FormParam("address") String address, @FormParam("country") String country, @FormParam("state") String state, @FormParam("account") String bankaccno) {
        try {
            //System.out.println(bank_account);
            System.out.println(bankaccno);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            PreparedStatement pst = con.prepareStatement("insert  into  MMX_REGISTRATION(name,email,pswd,phno,lastname,address,country,state,bankaccno) values(?,?,?,?,?,?,?,?,?)");
            pst.setString(1, passhash);
            pst.setString(2, email);
            pst.setString(3, pwd);
            pst.setString(4, phno);
            pst.setString(5, lname);
            pst.setString(6, address);
            pst.setString(7, country);
            pst.setString(8, state);
            pst.setString(9, bankaccno);
            System.out.println(bankaccno);
            int result = pst.executeUpdate();
            System.out.println(result);

            /*Customer cust = new Customer();
             cust.setName(na);
             cust.setMail(email);
            
             custMap.put(na, cust);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
        //return "listform.html";
    }

    public UriInfo getContext() {
        return context;
    }

    public void setContext(UriInfo context) {
        this.context = context;
    }
    /*   
     @GET
     @Path("query2")
     @Produces(MediaType.TEXT_XML)
     @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
     public ArrayList<demo_pojo> register1() {
     // String response[] = null;

     ArrayList<demo_pojo> arrayList = new ArrayList<demo_pojo>();
     demo_pojo obj = null;
     try {

     Class.forName("org.apache.derby.jdbc.ClientDriver");
     Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
     //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
     //String str1="select * from restdb_insertion where registration=?";
     PreparedStatement pst = con.prepareStatement("select * from restdb_insertion   ");
     ResultSet rs = pst.executeQuery();
     ResultSetMetaData rsmd = rs.getMetaData();
     int cols = rsmd.getColumnCount();
     while (rs.next()) {
     obj = new demo_pojo(rs.getString("id"), rs.getString("company"));

     arrayList.add(obj);
     System.out.println(rs.getString("id"));
     }

     } catch (Exception e) {
     e.printStackTrace();
     }
     return arrayList;

     //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
     }
     */

    /**
     * PUT method for updating or creating an instance of sample
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    //@POST
    @GET
    @Path("addtocontact")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register2(@QueryParam("name1") String name1) {
        String response2 = null;
        String response3 = null;
        String response1 = null;
        String response4 = null;
        String response5 = null;
        String response6 = null;
        String response7 = null;

        try {
            System.out.println(name1);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            //PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where id=" + name1);
            PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where bankaccno=" + name1);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            System.out.print("<html> <body>");
            System.out.print("");

            System.out.print("");
            System.out.print("");

            //System.out.print("\n");
            System.out.print("</tr>");

            while (rs.next()) {
// String id = rs.getString(2);
                //String id2 = rs.getString(1);
                //String id1 = rs.getString(5);
                String id = rs.getString(2);
                String id1 = rs.getString(6);
                String id2 = rs.getString(3);
                String id3 = rs.getString(5);
                String id4 = rs.getString(8);
                String id5 = rs.getString(10);

                System.out.print("<tr>");
                response1 = id;
                response2 = id1;
                response3 = id2;
                response4 = id3;
                response5 = id4;
                response6 = id5;
                System.out.print("id5" + id5);

            }

            //response = name1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response1 + " " + response2 + " " + response3 + " " + response4 + " " + response5 + " " + response6;

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @GET
    @Path("myrecipient")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register3(@QueryParam("name1") String name1) {
        String response2 = null;
        String response3 = null;
        String response1 = null;
        String response4 = null;
        String response5 = null;
        String response6 = null;
        String response7 = null;

        try {
            System.out.println(name1);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where id=" + name1);

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            System.out.print("<html> <body>");
            System.out.print("");

            System.out.print("");
            System.out.print("");

            //System.out.print("\n");
            System.out.print("</tr>");

            while (rs.next()) {
// String id = rs.getString(2);
                //String id2 = rs.getString(1);
                //String id1 = rs.getString(5);
                String id = rs.getString(2);
                String id1 = rs.getString(6);
                String id2 = rs.getString(3);
                String id3 = rs.getString(5);
                String id4 = rs.getString(8);
                String id5 = rs.getString(10);

                System.out.print("<tr>");
                response1 = id;
                response2 = id1;
                response3 = id2;
                response4 = id3;
                response5 = id4;
                response6 = id5;
                System.out.print("id5" + id5);

            }

            //response = name1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response1 + " " + response2 + " " + response3 + " " + response4 + " " + response5 + " " + response6;

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @POST
    @Path("insertionadd_contact")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register45(@FormParam("passhash") String passhash, @FormParam("email") String email, @FormParam("$pswdhash") String pwd, @FormParam("phno") String phno) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            PreparedStatement pst = con.prepareStatement("insert  into  SENT_DATA(c_id,acno,c_name,phno) values(?,?,?,?)");
            pst.setString(1, passhash);
            pst.setString(2, email);
            pst.setString(3, pwd);
            pst.setString(4, phno);

            int result = pst.executeUpdate();
            System.out.println(result);

            /*Customer cust = new Customer();
             cust.setName(na);
             cust.setMail(email);
            
             custMap.put(na, cust);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
        //return "listform.html";
    }

    @GET
    @Path("query31")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register21(@QueryParam("rname") String name1) {
        String response2 = null;
        String response3 = null;
        //String a[] = null;

        try {
            System.out.println(name1);

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where name='" + name1 + "'");
            System.out.println("select * from MMX_REGISTRATION where name='" + name1 + "'");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            System.out.print("<html> <body>");
            System.out.print("");

            System.out.print("");
            System.out.print("");

            //System.out.print("\n");
            System.out.print("</tr>");

            while (rs.next()) {

                String id = rs.getString(2);
                String id2 = rs.getString(3);
                System.out.print("<tr>");
                response2 = id;
                response3 = id2;

                System.out.print("</tr>");

            }

            //response = name1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    /*
     @POST
     @Path("/employees11")

     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.APPLICATION_JSON)
     public String putHtml(final String input) {

     return "{\"result\": \"Hello world sample text\"}";

     } // end of switch
    
    
     */
    @GET
    @Path("recipients")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register1(@QueryParam("cid") int name1) {
        //System.out.println("INside");
        String response = null;
       // ArrayList<demo_pojo> arrayList = new ArrayList<demo_pojo>();
        // demo_pojo obj = null;
        try {
            System.out.println(name1);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from SENT_DATA where c_id=" + name1);
            System.out.println("select * from SENT_DATA where c_id='" + name1 + "'");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while (rs.next()) {

                //response+= rs.getString(1)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(2)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(3)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(4)+"<br>\t";
//response+= "Recipient Name :<a href=\"Deposit_details.html\" onclick=\"location.href=this.href+'?name='+"+rs.getString(3)+";return false;\" >&nbsp;&nbsp;"+rs.getString(4)+"<hr>\t</a>";
//response+= "<center><i><b>Recipient Name</b></i> &nbsp;<a  href=\"Deposit_details.html\" onclick=\"location.href=this.href+'?country='+"+rs.getString(4)+"+'&id='+p;return false;\">"+rs.getString(4)+"</a></center>&nbsp;&nbsp;<br><b><i>Phone Number:&nbsp;"+rs.getString(5)+"&nbsp;&nbsp;<br>Recipients Account Number:&nbsp;"+rs.getString(3)+" <hr><img src=\"dollar.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">&nbsp;&nbsp;&nbsp;&nbsp;Bank details <center> Bank Deposite:&nbsp;"+rs.getString(6)+"</center><br><center>Date of deposite:&nbsp;"+rs.getString(7)+"</center><hr><img src=\"done.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">  Transaction State:&nbsp;"+rs.getString(8)+"</i></b><hr><hr>\t</a>";
                response += "<center><i><b>Recipient Name</b></i> &nbsp;<a  href=\"Recipientsbankinfo.html\" onclick=\"location.href=this.href+'?id='+" + rs.getString(1) + ";return false;\">" + rs.getString(4) + "</a></center>&nbsp;&nbsp;<br><b><i>Phone Number:&nbsp;" + rs.getString(5) + "&nbsp;&nbsp;<br>Recipients Account Number:&nbsp;" + rs.getString(3) + " <hr><img src=\"dollar.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">&nbsp;&nbsp;&nbsp;&nbsp;Bank details <center> Bank Deposite: Indian National Bank&nbsp;</center><br><center></center><hr><img src=\"done.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">  Transaction State</i></b><hr>\t</a>";
  //response+= "<center><i><b>Recipient Name</b></i> &nbsp;<a  href=\"Recipientsbankinfo.html\" onclick=\"location.href=this.href+'?id='+"+rs.getString(1) +";return false;\">"+rs.getString(4)+"</a></center>&nbsp;&nbsp;<br><b><i>Phone Number:&nbsp;"+rs.getString(5)+"&nbsp;&nbsp;<br>Recipients Account Number:&nbsp;"+rs.getString(3)+" <hr><img src=\"dollar.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">&nbsp;&nbsp;&nbsp;&nbsp;Bank details <center> Bank Deposite: Indian National Bank&nbsp;"+rs.getString(6)+"</center><br><center>Date of deposite:&nbsp;"+rs.getString(7)+"</center><hr><img src=\"done.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">  Transaction State:&nbsp;"+rs.getString(8)+"</i></b><hr><hr>\t</a>";

             //   response+= "<center><b></b><i><b>Recipient Name &nbsp;</b></i>: <a href=\"Deposit_details.html\" onclick=\"location.href=this.href+'?name='+"+rs.getString(4)+"</center>&nbsp;&nbsp;<br><b><i>Phone Number:&nbsp;"+rs.getString(5)+"&nbsp;&nbsp;<br>Recipients Account Number:&nbsp;"+rs.getString(3)+" <hr><img src=\"dollar.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">&nbsp;&nbsp;&nbsp;&nbsp;Bank details <center> Bank Deposite:&nbsp;"+rs.getString(6)+"</center><br><center>Date of deposite:&nbsp;"+rs.getString(7)+"</center><hr><img src=\"done.png\" class=\"img-circle\" alt=\"Cinque Terre\" width=\"50\" height=\"50\">  Transaction State:&nbsp;"+rs.getString(8)+"</i></b><hr><hr>\t</a>";
                //System.out.println(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @GET
    @Path("states")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register111(@QueryParam("id1") int name1) {
        System.out.println("INside");
        String response = null;
       // ArrayList<demo_pojo> arrayList = new ArrayList<demo_pojo>();
        // demo_pojo obj = null;
        try {
            System.out.println(name1);
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from MMX_STATES where c_id=" + name1);
            System.out.println("select * from MMX_STATES where c_id='" + name1 + "'");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();
            while (rs.next()) {

                //response+= rs.getString(1)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(2)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(3)+"&nbsp;&nbsp;&nbsp;\t"+rs.getString(4)+"<br>\t";
                response += "" + rs.getString(3) + ";return false;\" >&nbsp;&nbsp;" + rs.getString(2) + "<hr>\t</a>";

                //System.out.println(rs.getString(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @GET
    @Path("query313")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String register123(@QueryParam("lname") String name1) {
        String response2 = null;
       // String name11 = "kheerthi";

         //String a[] = null;
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from mss where username='" + name1 + "'");
            System.out.println("select * from mss where username='" + name1 + "'");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            while (rs.next()) {
                if (rs.getString(1) != "null") {
                    return "success";
                }
            }

            //response = name1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @Context
    private HttpServletRequest request;

    @GET
    @Path("session")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String session(@QueryParam("lname") String name1) {
        String response2 = null;
       //String name11 = "praveen";

         //String a[] = null;
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/employee", "app", "app");
            //PreparedStatement pst = con.prepareStatement("insert  into  restdb_insertion(id,company) values(?,?)");
            //String str1="select * from restdb_insertion where registration=?";
            PreparedStatement pst = con.prepareStatement("select * from MMX_REGISTRATION where name='" + name1 + "'");
            System.out.println("select * from MMX_REGISTRATION where name='" + name1 + "'");

            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int cols = rsmd.getColumnCount();

            while (rs.next()) {
                if (rs.getString(1) != "null") {
                    request.getSession(true);
                    HttpSession session = request.getSession();
                    session.setAttribute("name", "value");
                    session.setAttribute("UserName", rs.getString(2));
                    String username = (String) session.getAttribute("UserName");
                    System.out.println(username);
                   //  System.out.println(name);
                    //request.getSession(false);
                    //request.getSession().invalidate();
                    //String user = (String)session.getAttribute("UserName");
                    //System.out.println(user);
                    return "success" + " " + username + " " + rs.getString(1) + " " + rs.getString(8);
                }
            }

            //response = name1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail";

        //"<rss version='2.0'><channel><id>" + id + "</id><cmp>" +response.toArray()[0] + "</cmp></channel></rss>"
    }

    @GET
    @Path("sessiondestroy")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String sessiondestroy() {

        request.getSession(false);
        request.getSession().invalidate();
        String username = (String) request.getSession().getAttribute("UserName");
        System.out.println(username);
        if (username != null) {
            return "failure" + " " + username;
        } else {
            return "success" + " " + username;
        }

    }

}
