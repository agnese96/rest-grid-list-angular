/**
 * 
 */
package hello;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author afolli
 *
 */
public class GridItemMapper implements RowMapper<GridItem> {
    public GridItem mapRow(ResultSet rs, int rowNum) throws SQLException{
    	GridItem item= new GridItem();
    	item.title=rs.getString("title");
    	item.description=rs.getString("description");
    	item.background=rs.getString("background");
    	item.setID(rs.getInt("ID"));
    	return item;
    }
}
