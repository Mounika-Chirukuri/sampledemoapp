/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import comm.restfull.*;

public class Project 
{
/*public ArrayList<demo_pojo> GetFeeds(Connection connection,,String User_ID) throws Exception
{
ArrayList<feedobjects> feedData = new ArrayList<feedobjects>();
try
{
PreparedStatement ps = connection.prepareStatement("SELECT msg_id,message,user_id_fk FROM messages WHERE user_id_fk=? ORDER BY msg_id DESC");
ps.setString(1,User_ID);
ResultSet rs = ps.executeQuery();
while(rs.next())
{
FeedObjects feedObject = new FeedObjects();
feedObject.setTitle(rs.getString("msg_id"));
feedObject.setDescription(rs.getString("message"));
feedObject.setUrl(rs.getString("user_id_fk"));
feedData.add(feedObject);
}
return feedData;
}
catch(Exception e)
{
throw e;
}
}
*/
}