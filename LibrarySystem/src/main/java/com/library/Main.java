package com.library;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        BookDAO bdao = new BookDAO();
        Member mdao = new Member();
        Rental rdao = new Rental();

        while (true) {
            System.out.println("\n==== LIBRARY SYSTEM ====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View Issued Books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Copies: ");
                    int copies = sc.nextInt();
                    bdao.addBook(title, author, genre, copies);
                    break;

                case 2:
                    bdao.viewBooks();
                    break;

                case 3:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Phone: ");
                    String phone = sc.nextLine();
                    mdao.addMember(name, phone);
                    break;

                case 4:
                    mdao.viewMembers();
                    break;

                case 5:
                    System.out.print("Member ID: ");
                    int mid = sc.nextInt();
                    System.out.print("Book ID: ");
                    int bid = sc.nextInt();
                    if (bdao.updateCopies(bid, -1)) {
                        rdao.issueBook(mid, bid);
                    }
                    break;

                case 6:
                    System.out.print("Rental ID: ");
                    int rid = sc.nextInt();
                    rdao.returnBook(rid);
                    break;

                case 7:
                    rdao.viewIssuedBooks();
                    break;

                case 0:
                    System.exit(0);
            }
        }
    }
}
