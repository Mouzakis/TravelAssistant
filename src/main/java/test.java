
import com.project.heracliontravelassistant.db.PointDB;
import com.project.heracliontravelassistant.model.Point;
import java.sql.SQLException;


/**
 *
 * @author papadako [this is a test]
 */
public class test {

    /**
     * An example of adding a new member in the database.Turing is a user of our
     * system
     *
     * @param args the command line arguments
     * @throws ClassNotFoundException
     * @throws java.lang.InterruptedException
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Point p = new Point("test", "sight", 2796413.241526294, 4209508.746699865, "malaka 1",
                "6939000874", "www.malakas.com", "12-2pm", "gtpkavala", "https://dearsam.com/img/600/744/resize/p/a/panoramic-landscape-70x50.jpg");

        System.out.println(p);

        PointDB.updatePoint("test1", p);
    }
}
