package com.ascending.training.jdbc;
import com.ascending.training.jdbc.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class GameDao {
    static final String DBURL = "jdbc:postgresql://localhost:521/sport";
    static final String USER = "wendy";
    static final String PASS = "password";
    private Logger logger = LoggerFactory.getLogger(getClass()); //创造一个logger instance

    //CRUD

    public List<Game> getGames(){
        List<Game> games = new ArrayList();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //STEP 2: Open a connection
            logger.debug("open connection..");
            conn = DriverManager.getConnection(DBURL, USER, PASS);

            //STEP 3: Execute a query
            logger.info("create statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM games";
            rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                Long team1 = rs.getLong("team1");
                Long team2 = rs.getLong("team2");


                //Fill the object
                Game game = new Game();
                game.setId(id);
                game.setName(name);
                game.setLocation(location);
                //game.setTeam1(team1);
                //game.setTeam2(team2);
                games.add(game);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally {
            //STEP 6: finally block used to close resources
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch(SQLException se) {
                se.printStackTrace();
            }
        }
        return games;
    }

    public static void main(String[] args){
        GameDao gameJDBCDao = new GameDao();
        System.out.println(gameJDBCDao.getGames());
    }
}

