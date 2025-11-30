package com.library;

import java.sql.*;

public class Member {

    public void addMember(String name, String phone) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement("INSERT INTO member(name, phone) VALUES(?,?)");
        ps.setString(1, name);
        ps.setString(2, phone);
        ps.executeUpdate();
        con.close();
        System.out.println("Member added!");
    }

    public void viewMembers() throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement().executeQuery("SELECT * FROM member");

        System.out.println("\n--- Members List ---");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | " + rs.getString(3));
        }
        con.close();
    }
}
