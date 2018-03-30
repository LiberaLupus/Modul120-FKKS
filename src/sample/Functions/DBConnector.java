package sample.Functions;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    public static List<String> databaseselect(String select, String attribut) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(select);
            try {
                List<String> Liste01 = new ArrayList<String>();
                String name = null;
                while (rs.next()) {
                    name = rs.getString(attribut);
                    Liste01.add(name);
                    System.out.println("DBConnector "+name);
                }

                return Liste01;


            } catch (SQLException e1) {
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public static void databaseupdaterichtigfalsch(String update, Boolean value1) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            PreparedStatement stmt = con
                    .prepareStatement(update);
            try {
                stmt.setBoolean(1, value1);
                stmt.execute();
                System.out.println("Data is inserted 1");
                stmt.close();
            } catch (SQLException e1) {
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public static void databaseupdatebild(String update, String value1) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            PreparedStatement stmt = con
                    .prepareStatement(update);
            try {
                stmt.setString(1, value1);
                stmt.execute();
                System.out.println("Data is inserted 1");
                stmt.close();
            } catch (SQLException e1) {
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public static void databaseinsert1(String insert, String value1) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            PreparedStatement stmt = con
                    .prepareStatement(insert);
            try {
                stmt.setString(1, value1);
                stmt.execute();
                System.out.println("Data is inserted 1");
                stmt.close();
            } catch (SQLException e1) {
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public static void databaseinsert2(String insert, String value1, String value2) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            PreparedStatement stmt = con
                    //"INSERT INTO Highscore(Name, Highscore) VALUES(?, ?)"
                    .prepareStatement(insert);
            try {
                stmt.setString(1, value1);
                stmt.setString(2, value2);
                //stmt.setBlob(2, );
                stmt.execute();
                System.out.println("Data is inserted 1");
                stmt.close();
            } catch (SQLException e1) {
            }
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
    }

    public static List<String> databasedelete(String delete) {
        try {
            Class.forName("org.sqlite.JDBC").newInstance();
            Connection con = DriverManager.getConnection("jdbc:sqlite:FKKS.db");
            System.out.println("connection made...");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(delete);
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        }
        return null;
    }

}