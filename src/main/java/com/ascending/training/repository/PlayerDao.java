package com.ascending.training.repository;
import com.ascending.training.model.Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

public class PlayerDao {
    static final String DBURL = "jdbc:postgresql://localhost:521/sport";
    static final String USER = "wendy";
    static final String PASS = "password";
    private Logger logger = LoggerFactory.getLogger(getClass()); //创造一个logger instance，控制输出
    //CRUD

    public List<Player> getPlayers(){
        List<Player> players = new ArrayList();
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
            sql = "SELECT * FROM players";
            rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String name = rs.getString("name");
                String role_type = rs.getString("role_type");
                long salary = rs.getLong("salary");
                Date hired_date = rs.getDate("hired_date");
                long team_id = rs.getLong("team_id");


                //Fill the object
                Player player = new Player();
                player.setId(id);
                player.setName(name);
                player.setRole_type(role_type);
                player.setSalary(salary);
                player.setHired_date(hired_date);
                player.setTeam_id(team_id);
                players.add(player);
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
        return players;
    }

    public static void main(String[] args){
        PlayerDao playerJDBCDao = new PlayerDao();
        System.out.println(playerJDBCDao.getPlayers());
    }
}

