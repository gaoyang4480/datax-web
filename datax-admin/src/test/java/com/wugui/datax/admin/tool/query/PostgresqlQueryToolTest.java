package com.wugui.datax.admin.tool.query;

import com.wugui.datax.admin.entity.JobJdbcDatasource;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PostgresqlQueryToolTest {

    private BaseQueryTool queryTool;
    private JobJdbcDatasource jdbcDatasource;

    @Before
    public void before() {
        genDs();
        queryTool = QueryToolFactory.getByDbType(jdbcDatasource);
    }

    private void genDs() {
        jdbcDatasource = new JobJdbcDatasource();
        jdbcDatasource.setDatasourceName("test");
        jdbcDatasource.setJdbcUsername("postgres");
        jdbcDatasource.setJdbcPassword("postgres");
        jdbcDatasource.setJdbcUrl("jdbc:postgresql://localhost:5432/data");
        jdbcDatasource.setJdbcDriverClass("org.postgresql.Driver");
    }

    @Test
    public void getTableNames() {
        List<String> tableNames = queryTool.getTableNames();
        tableNames.forEach(System.out::println);
    }

    @Test
    public void getTableColumns() {
        List<String> tableNames = queryTool.getColumnNames("BD_EMR_TYPE",jdbcDatasource.getJdbcDriverClass());
        tableNames.forEach(System.out::println);
    }

}