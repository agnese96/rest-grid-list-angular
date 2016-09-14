package hello;

import java.net.URISyntaxException;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author afolli
 * Data Access Object for GridList
 */
public class GridListDAO {
	
	private DataSource dataSource;
	private JdbcTemplate templateObj;
	
	public GridListDAO(){
		try {
			setDataSource();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql="CREATE TABLE IF NOT EXISTS GridList("
				+ "ID SERIAL NOT NULL PRIMARY KEY,"
				+ "title char(50) NOT NULL, "
				+ "description TEXT NOT NULL,"
				+ "background TEXT NOT NULL);";
		
		templateObj.execute(sql);
	}
	
	/**
	 * Method to initialize database resources(connection)
	 * @throws URISyntaxException 
	 */
	public void setDataSource() throws URISyntaxException{
		DataSource ds= (new createPostgreDataSource()).getDataSource();
		this.dataSource = ds;
	    this.templateObj = new JdbcTemplate(this.dataSource);
	}
	/**
	 * Insert new item to the GridList table
	 * @param item type GridList
	 */
	public void insertListItem(GridItem item){
		
		String sql="INSERT INTO GridList (title, description, background) values(?, ?, ?)";
		templateObj.update(sql, item.title, item.description, item.background);
	}
	public List<GridItem> getList(){
		String sql="SELECT * FROM GridList";
		List<GridItem> gridList= this.templateObj.query(sql, new GridItemMapper());
		return gridList;
	}
	public GridItem getGridItem(Integer id){
		String sql="SELECT * FROM GridList WHERE ID=?";
		GridItem item=templateObj.queryForObject(sql, new Object[]{id}, new GridItemMapper());
		return item;
	}
	//TODO Add search, update & delete
}
