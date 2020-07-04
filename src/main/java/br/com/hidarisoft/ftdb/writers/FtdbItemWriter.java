package br.com.hidarisoft.ftdb.writers;

import org.springframework.batch.item.ItemWriter;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class FtdbItemWriter implements ItemWriter {

    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;


    @Override
    public void write(List list) throws Exception {
        dataSource = getJdbcTemplate().getDataSource();


    }

    public DataSource getDataSource() {
        return dataSource;
    }



    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

}
