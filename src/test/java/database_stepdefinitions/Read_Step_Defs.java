package database_stepdefinitions;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.*;

public class Read_Step_Defs {
    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName= crystalkeyhotels2; user=Ahmet_User;password=Ahmet123!";
    String username="Ahmet_User";
    String password="Ahmet123!";

//    Connection, Statement, ResultSet comes from java.sql class
    Connection connection;//To connect to the database
    Statement statement;//To get the ResultSet
    ResultSet resultSet;//To write the queries to get tha data

    @Given("user connects to the database")
    public void user_connects_to_the_database() {
//        Call the appropriate method
      DBUtils.createConnection();
    }

    @Given("user gets {string} from {string} table")
    public void user_gets_from_table(String column, String table) {
//        String query = "SELECT Price FROM tHOTELROOM";
        String query = "SELECT " + column + " FROM " +table;
//        RUN THAT QUERY executeQuery method from DBUtils
        DBUtils.executeQuery(query);
//        NOW DRIVER IS ON THE PRICE COLUMN ON tHOTELROOM TABLE
    }

    @Given("user reads all rows in the {string} column")
    public void user_reads_all_rows_in_the_column(String column) throws SQLException {
//      We will use Result set to do actions
//        resultSet.next() -> takes us to the next row
//        resultSet -> DBUtils.getResultset()
        DBUtils.getResultset().absolute(3);//Takes me to 3rd row
        //Getting the data from the CURRENT POSITION
        Object thirdColumnObject=DBUtils.getResultset().getObject(column);//Getting 3rd column data on "Price" column
        System.out.println("THIRD : "+thirdColumnObject);

//        Go to the next row
        DBUtils.getResultset().next();
        Object next1=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("FOURTH : "+next1);//425

        DBUtils.getResultset().next();
        Object next2=DBUtils.getResultset().getObject(column);//Getting 5th column data on "Price" column
        System.out.println("FIFTH : "+next2);//425

        DBUtils.getResultset().next();//on the 3rd row
        Object next3=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("SIXTH : "+next3);//425
        DBUtils.getResultset().absolute(4);//Takes me to 4th row
        //Getting the data from the CURRENT POSITION
        Object fourthColumnObject=DBUtils.getResultset().getObject(column);//Getting 4th column data on "Price" column
        System.out.println("FOURTH : "+fourthColumnObject);//425

        //PRINT ALL ROWS
        while( DBUtils.getResultset().next()){// DBUtils.getResultset().next() TRUE IF NEXT EXIST
            Object data=DBUtils.getResultset().getObject(column);
            System.out.println(data);
        }

//        GO TO LAST COLUMN USING last() method. ------   first()->FIRST COLUMN
        DBUtils.getResultset().last();
//        I can get data as String using getString() method
        String lastData = DBUtils.getResultset().getString(column);
        System.out.println("LAST DATA " + lastData);
    }

    @Given("users gets the value in row {int} in {string} column and verifies the value is {string}")
    public void users_gets_the_value_in_row_in_column_and_verifies_the_value_is(Integer row, String column, String value) throws SQLException {
        DBUtils.getResultset().absolute(row);
        Object data = DBUtils.getResultset().getObject(column);
        String expectedData = value;
        String actualData = data.toString();

        System.out.println("The data in row " + row + ",column " + column +" : " + value);
        Assert.assertEquals(expectedData,actualData);
    }
}
