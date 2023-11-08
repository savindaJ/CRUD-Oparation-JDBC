

import DB.DBConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Launcher {

    static Connection connection;

    public static void main(String[] args) {
        try {

            connection = DBConnection.getInstance().getConnection();
            connection.setAutoCommit(false);

            String quary = "Insert into orders(order_id,cus_id,date)" +
                    "VALUES(?,?,?)";

            PreparedStatement pstm = connection.prepareStatement(quary);

            pstm.setString(1, "O003");
            pstm.setString(2, "2");
            pstm.setDate(3, Date.valueOf("2021-10-25"));


            boolean b = pstm.executeUpdate() > 0;


            if (b) {
                Connection connection1 = DBConnection.getInstance().getConnection();
                String quary1 = "Insert into order_detail(order_id,item_id)" +
                        "VALUES(?,?)";


                PreparedStatement pstm1 = connection1.prepareStatement(quary1);

                pstm1.setString(1, "O003");
                pstm1.setString(2, "04");

                int executed = pstm1.executeUpdate();

                if (executed > 0) {
                    Connection connection2 = DBConnection.getInstance().getConnection();
                    String quary2 = "Update item set qty  = ? where code = ?";

                    int onHand = 100;

                    int qty = 50;

                    onHand -= qty;


                    PreparedStatement pstm2 = connection2.prepareStatement(quary2);

                    pstm2.setInt(1, onHand);
                    pstm2.setString(2, "04");

                    int executed1 = pstm2.executeUpdate();

                    if (executed1 > 0) {
                        connection.commit();
                        System.out.println("Success !");
                    } else {
                        connection.rollback();
                        System.out.println("Fail !");
                    }


                } else {
                    connection.rollback();
                    System.out.println("Fail !");
                }


            } else {
                connection.rollback();
                System.out.println("Fail !");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
