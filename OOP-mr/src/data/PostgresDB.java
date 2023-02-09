package data;

import data.interfaces.DB;

import java.sql.*;

public class PostgresDB implements DB {
    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/simpledb";
        String user_name = "postgres";
        String password = "1979";
        try {
          Class.forName("org.postgresql.Driver");

          Connection con = DriverManager.getConnection(url,user_name ,  password);

          return  con;
        }catch (Exception e){
            e.getMessage();
            return null;
        }
    }

    @Override
    public Connection createConnection() throws SQLException, ClassNotFoundException {
        String  url =  "jdbc:postgresql://localhost:5432/simpledb";
        String user  =  "postgres";
        String password =  "1979";

        try{
            Class.forName("org.postgresql.Driver");

            Connection con  = DriverManager.getConnection(url, user, password);
            Statement st =  con.createStatement();
            DatabaseMetaData dbm  =  con.getMetaData();
            ResultSet tables = dbm.getTables(null, null , "person", null);

            if (!tables.next()){
                String sql =  "CREATE TABLE person (id serial primary key, name text, surname text ,  email  text , income double precision, age integer);";
                st.execute(sql);
                System.out.println("Table  created successfully");

            }
            else {
                System.out.println("Table  exists.");
            }
            return con;
        }catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
       return  null;
    }
}
