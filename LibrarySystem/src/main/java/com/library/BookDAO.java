package com.library;

import java.sql.*;

public class BookDAO {

    public void addBook(String title, String author, String genre, int copies) throws Exception {
        Connection con = DBConnection.getConnection();
        String q = "INSERT INTO book(title, author, genre, available_copies) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(q);
        ps.setString(1, title);
        ps.setString(2, author);
        ps.setString(3, genre);
        ps.setInt(4, copies);
        ps.executeUpdate();
        con.close();
        System.out.println("Book added!");
    }

    public void viewBooks() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM book");

        System.out.println("\n--- Books in Library ---");
        while (rs.next()) {
            System.out.println(
                rs.getInt("book_id") + " | " +
                rs.getString("title") + " | " +
                rs.getString("author") + " | " +
                rs.getString("genre") + " | Copies: " +
                rs.getInt("available_copies")
            );
        }
        con.close();
    }

    public boolean updateCopies(int bookId, int change) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "SELECT available_copies FROM book WHERE book_id=?");
        ps.setInt(1, bookId);
        ResultSet rs = ps.executeQuery();

        if (!rs.next()) return false;

        int current = rs.getInt(1);
        int updated = current + change;

        PreparedStatement ps2 = con.prepareStatement(
                "UPDATE book SET available_copies=? WHERE book_id=?");
        ps2.setInt(1, updated);
        ps2.setInt(2, bookId);
        ps2.executeUpdate();

        con.close();
        return true;
    }
}
