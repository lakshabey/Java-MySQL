import java.io.IOException;
import java.sql.SQLException;

public interface MenuInterface {

    void addMember(Student DefaultMember);
    void deleteMember(int var_1);
    void printMember();
    void editMember(Student student);
    boolean Menu() throws IOException, SQLException;
}
