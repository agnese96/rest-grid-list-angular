package hello;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerInsert {
	@CrossOrigin(origins = "/insert")
	@ResponseBody
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String insert(@RequestBody GridItem item){
		
		GridListDAO dao = new GridListDAO();
		dao.insertListItem(item);
		return "all went well supposedly";
	}
}
