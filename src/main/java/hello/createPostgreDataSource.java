package hello;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class createPostgreDataSource {
	private static final String driverClassName="org.postgresql.Driver";
	private static final String url="jdbc:postgresql://localhost:5432/GridLists";
	private static final String username="postgres";
	private static final String password="agnese96";
	private static DataSource ds;
	
	public createPostgreDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		ds=dataSource;
	}

	public DataSource getDataSource() {
		
		return ds;
	}
}
