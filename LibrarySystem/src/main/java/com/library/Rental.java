package com.library;

import java.sql.*;
import java.time.LocalDate;

public class Rental {

    public void issueBook(int memberId, int bookId) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO rental(member_id, book_id, issue_date) VALUES(?,?,?)");
        ps.setInt(1, memberId);
        ps.setInt(2, bookId);
        ps.setDate(3, Date.valueOf(LocalDate.now()));
        ps.executeUpdate();

        con.close();
        System.out.println("Book issued!");
    }

    public void returnBook(int rentalId) throws Exception {
        Connection con = DBConnection.getConnection();

        PreparedStatement ps = con.prepareStatement(
                "UPDATE rental SET return_date=? WHERE rental_id=?");
        ps.setDate(1, Date.valueOf(LocalDate.now()));
        ps.setInt(2, rentalId);
        ps.executeUpdate();

        con.close();
        System.out.println("Book returned!");
    }

    public void viewIssuedBooks() throws Exception {
        Connection con = DBConnection.getConnection();
        String q = "SELECT r.rental_id, m.name, b.title, r.issue_date, r.return_date " +
                "FROM rental r " +
                "JOIN member m ON r.member_id = m.member_id " +
                "JOIN book b ON r.book_id = b.book_id " +
                "ORDER BY r.rental_id DESC";


        ResultSet rs = con.createStatement().executeQuery(q);

        System.out.println("\n--- Issued Books ---");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getString(3) + " | Issue: " +
                    rs.getString(4) + " | Return: " +
                    rs.getString(5)
            );
        }
        con.close();
    }
}
