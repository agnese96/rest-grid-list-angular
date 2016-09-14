package hello;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class createPostgreDataSource {
	private final String driverClassName="org.postgresql.Driver";
	private String url;
	private String username;
	private String password;
	private DataSource ds;
	
	public createPostgreDataSource() throws URISyntaxException{
		URI dbUri = new URI(System.getenv("DATABASE_URL"));
		this.username=dbUri.getUserInfo().split(":")[0];
		this.password=dbUri.getUserInfo().split(":")[1];
		this.url="jdbc:postgresql://"+dbUri.getHost() + dbUri.getPath();
		
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
