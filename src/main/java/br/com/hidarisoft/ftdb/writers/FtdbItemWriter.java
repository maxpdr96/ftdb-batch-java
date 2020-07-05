package br.com.hidarisoft.ftdb.writers;

import br.com.hidarisoft.ftdb.models.Basic;
import br.com.hidarisoft.ftdb.models.DAO.BasicDAO;
import br.com.hidarisoft.ftdb.models.Functions;
import br.com.hidarisoft.ftdb.utils.Constants;
import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

public class FtdbItemWriter implements ItemWriter<BasicDAO> {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Override
    public void write(List<? extends BasicDAO> list) throws Exception {
        dataSource = getJdbcTemplate().getDataSource();

        for(BasicDAO basicDAO: list){

            Basic basic = new Basic(basicDAO);

           if(basicDAO.getFunctionsDAO() != null){
               Functions functions = new Functions(basicDAO.getFunctionsDAO());

               Connection conn = null;
               PreparedStatement ps = null;
               try{
                   conn = dataSource.getConnection();
                   ps = conn.prepareStatement(Constants.INSERT_FUNCTIONS_QUERY);

                   ps.setString(1, functions.getVersion());
                   ps.setString(2, functions.getLanguage());
                   ps.setTimestamp(3, new Timestamp(format.parse(functions.getTimeStamp()).getTime()));

                   int affectedRows = ps.executeUpdate();

                   if(affectedRows == 0){
                       throw new SQLException("Failed to create Functions. No rows affected!");
                   }
               } catch (Exception e){
                   e.printStackTrace();
               } finally {
                   if(conn != null){
                       conn.close();
                   }
                   if(ps != null){
                       ps.close();
                   }
               }
           }

            Connection conn = null;
            PreparedStatement ps = null;
            try{
                conn = dataSource.getConnection();
                ps = conn.prepareStatement(Constants.INSERT_BASIC_QUERY);

                ps.setLong(1, basic.getId());
                ps.setString(2, basic.getName());

                int affectedRows = ps.executeUpdate();

                if(affectedRows == 0){
                    throw new SQLException("Failed to create Functions. No rows affected!");
                }
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if(conn != null){
                    conn.close();
                }
                if(ps != null){
                    ps.close();
                }
            }
        }

        }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }
}
