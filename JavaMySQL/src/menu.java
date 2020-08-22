import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class menu implements MenuInterface{

    @Override
    public void addMember(Student student) {
        String query1 = "INSERT INTO member (id,name,age,subject,fees)" +
                "VALUES (?,?,?,?,?)";

        try {


            PreparedStatement mtx = connect.connectme().prepareStatement(query1);

            mtx.setInt(1,student.getId());
            mtx.setString(2,student.getName());
            mtx.setInt(3,student.getAge());
            mtx.setString(4,student.getSubject());
            mtx.setInt(5,student.getFees());
            mtx.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteMember(int var_1) {
        Connection conn = connect.connectme();
        String query2 = "delete from member where id = ?";
        try {
            PreparedStatement preparedStmt = conn.prepareStatement(query2);
            preparedStmt.setInt(1, var_1);
            preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printMember() {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        System.out.println("printing member list ...");


        try {
            Connection conn = connect.connectme();
            ps = conn.prepareStatement("select * from member");

            rs = ps.executeQuery();
            System.out.println();

            while (rs.next()){
                System.out.printf("%-16s : %s%n", "id ",rs.getString(1));
                System.out.printf("%-16s : %s%n", "name ",rs.getString(2));
                System.out.printf("%-16s : %s%n", "age ",rs.getString(3));
                System.out.printf("%-16s : %s%n", "subject",rs.getString(4));
                System.out.printf("%-16s : %s%n", "Fees",rs.getString(5));
                System.out.println();
            }
        } catch (SQLException e) {

            System.out.println("Error in getting Data"+e);
        }

    }

    @Override
    public void editMember(Student student) {

        String query3  = "UPDATE member SET name=?,age=?,subject=?,fees=? WHERE id=?";
        try {
            Connection conn = connect.connectme();
            PreparedStatement mtx = conn.prepareStatement(query3 ,Statement.RETURN_GENERATED_KEYS);


            mtx.setString(1,student.getName());
            mtx.setInt(2,student.getAge());
            mtx.setString(3,student.getSubject());
            mtx.setInt(4,student.getFees());
            mtx.setInt(5,student.getId());
            mtx.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean Menu() throws IOException, SQLException {
        Scanner s = new Scanner(System.in);
        System.out.println("to add a new member 1");
        System.out.println("to read all member 2");
        System.out.println("to update member 3");
        System.out.println("to delete member 4");

        int myinput14 = s.nextInt();


        switch (myinput14){
            case 1:
                System.out.println("Enter id");
                int id = s.nextInt();

                System.out.println("Enter name");
                String name = s.next();

                System.out.println("Enter Age");
                int age = s.nextInt();

                System.out.println("Enter Subject");
                String subject = s.next();

                System.out.println("Enter Fees");
                int Fees = s.nextInt();

                Student member = new Student(id,name,age,subject,Fees);
                addMember(member);

                System.out.println(" \n");
                System.out.println("data inserted succesfully");
                break;

            case 2:
                printMember();
                break;

            case 3:

                System.out.println("Enter id");
                 id = s.nextInt();

                System.out.println("Enter name");
                 name = s.next();

                System.out.println("Enter Age");
                 age = s.nextInt();

                System.out.println("Enter Subject");
                 subject = s.next();

                System.out.println("Enter Fees");
                Fees = s.nextInt();


                Student mem1 = new Student(id,name,age,subject,Fees);
                editMember(mem1);
                System.out.println("Successfully Updated\n");
                break;

            case 4:
                System.out.println("Enter id : ");
                int id1 = s.nextInt();
                Student stundent1 = new Student();
                deleteMember(id1);
                System.out.println("Member successfully deleted");
                break;

        }




        return false;
    }

    public static void main(String[] args) throws IOException, SQLException{
        MenuInterface runrun = new menu();
        boolean end = false;
        while (!end) {
            end = runrun.Menu();
        }
    }
}
