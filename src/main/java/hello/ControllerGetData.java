package hello;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerGetData {
	@GetMapping("/get-data")
	public List<GridItem> getGridList(){
		GridListDAO dao= new GridListDAO();
		GridItem test= new GridItem();
		test.title="prova";
		test.background="http://lh3.googleusercontent.com/-kqYyvKLHkcY/Vb-b6o560hI/AAAAAAAAQdU/ULOSJRDPg-E/clip_image001_thumb.png?imgmax=800";
		test.description="This is merely a test!";
		dao.insertListItem(test);
		List<GridItem> items=dao.getList();
		return items;
	}
}
