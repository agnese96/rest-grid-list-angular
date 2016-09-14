package hello;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerGetData {
	@CrossOrigin(origins = "http://localhost:8080/get-data")
	@GetMapping("/get-data")
	public List<GridItem> getGridList(){
		GridListDAO dao= new GridListDAO();
		List<GridItem> items=dao.getList();
		return items;
	}
}
