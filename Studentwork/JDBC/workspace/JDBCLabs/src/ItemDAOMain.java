import com.javatunes.util.ItemDAO;
import com.javatunes.util.MusicItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

public class ItemDAOMain {
    public static void main (String[] args) {
        MusicItem musicItem;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/JavaTunesDB", "GUEST", "a");
            ItemDAO itemDAO = new ItemDAO(conn);

            musicItem = itemDAO.searchById((long)10);
            System.out.println(musicItem.toString() + "\n");

            Collection musicCollection = itemDAO.searchByKeyword("of");
            System.out.println(musicCollection.toString());

            musicItem = new MusicItem((long)1, "Title", "Artist", "2019-04-23", new BigDecimal(10), new BigDecimal(100));
            itemDAO.create(musicItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
