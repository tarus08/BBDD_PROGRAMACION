import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class _14_24_Swing extends JFrame implements ActionListener
    {
        private JTextField textField_dept_no, textField_dnombre, textField_loc;
        private JLabel label01, label02, label03;
        private JButton button01;

        ///// hacer un joptionpane para que elija entre delete y add depart, hacer una interfaz grafica para ambas, que funciones clarod
        protected  _14_24_Swing ()
        {
            setLayout(null);
            setTitle("Formulario");

            label01 = new JLabel("DEPT_NO");
            label01.setBounds(20,20,100,30);
            add(label01);

            label02 = new JLabel("DNOMBRE");
            label02.setBounds(20,60,100,30);
            add(label02);

            label03 = new JLabel("LOC");
            label03.setBounds(20,100,100,30);
            add(label03);

            textField_dept_no = new JTextField();
            textField_dept_no.setBounds(120, 20, 150, 20);
            add(textField_dept_no);

            textField_dnombre = new JTextField();
            textField_dnombre.setBounds(120, 60, 150, 20);
            add(textField_dnombre);

            textField_loc = new JTextField();
            textField_loc.setBounds(120, 100, 150, 20);
            add(textField_loc);

            button01 = new JButton("Add");
            button01.setBounds(10,150,100,30);
            add(button01);
            button01.addActionListener(this);
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            String url = "jdbc:oracle:thin:@localhost:1521";
            String username = "DAM";
            String password = "1234";

            if (e.getSource() == button01) {
                String str01 = textField_dept_no.getText();
                int dept_no = Integer.parseInt(str01);
                String name = textField_dnombre.getText();
                String loc = textField_loc.getText();

                System.out.println("Insert 1 to add a new department, 2 to delete a department.");
                int choice = new Scanner(System.in).nextInt();
                switch (choice)
                {
                    case 1 ->
                    {
                        try {
                            String sql = "INSERT INTO DEPART (DEPT_NO, DNOMBRE, LOC) " +
                                    "VALUES (?, ?, ?)";
                            Connection connection = DriverManager.getConnection(url, username, password);
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, dept_no);
                            preparedStatement.setString(2, name);
                            preparedStatement.setString(3, loc);
                            preparedStatement.executeUpdate();
                            connection.close();
                            System.out.println("Department added successfully.");
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                    case 2 ->
                    {
                        try {
                            String sql = "DELETE FROM DEPART WHERE DEPT_NO = ? AND DNOMBRE = ? AND LOC = ?";
                            Connection connection = DriverManager.getConnection(url, username, password);
                            PreparedStatement preparedStatement = connection.prepareStatement(sql);
                            preparedStatement.setInt(1, dept_no);
                            preparedStatement.setString(2, name);
                            preparedStatement.setString(3, loc);
                            preparedStatement.executeUpdate();
                            connection.close();
                            System.out.println("Department deleted successfully.");
                        }
                        catch (SQLException ex)
                        {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }
        public static void main(String[] args)
        {
            _14_24_Swing swing = new _14_24_Swing();
            swing.setBounds(0,0,350,170);
            swing.setVisible(true);
            swing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }

