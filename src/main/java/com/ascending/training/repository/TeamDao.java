package com.ascending.training.repository;
import com.ascending.training.model.Team;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeamDao {
    static final String DBURL = "jdbc:postgresql://localhost:521/sport";
    static final String USER = "wendy";
    static final String PASS = "password";
    private Logger logger = LoggerFactory.getLogger(getClass()); //crate a logger instance

    //CRUD

    public List<Team> getTeams(){
        List<Team> teams = new ArrayList();
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
            sql = "SELECT * FROM teams";
            rs = stmt.executeQuery(sql);

            //STEP 4: Extract data from result set
            while(rs.next()) {
                //Retrieve by column name
                Long id  = rs.getLong("id");
                String name = rs.getString("name");
                Integer formed_year = rs.getInt("formed_year");
                String abbreviation = rs.getString("abbreviation");

                //Fill the object
                Team team = new Team();
                team.setId(id);
                team.setName(name);
                team.setFormed_year(formed_year);
                team.setAbbreviation(abbreviation);
                teams.add(team);
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
        return teams;
    }

    public static void main(String[] args){
        TeamDao teamJDBCDao = new TeamDao();
        System.out.println(teamJDBCDao.getTeams());
    }
}
