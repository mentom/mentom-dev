import com.tinkerpop.blueprints.Vertex;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tinkerpop.blueprints.impls.orient.OrientGraph;


/**
 * Created by mentom on 07/03/16.
 */

@Controller
@EnableAutoConfiguration
public class OrientDBTestController {
    @RequestMapping("/")
    @ResponseBody
    String home() {


        OrientGraph graph = new OrientGraph("local:database/RubricaTelefonica","test","test");
        Vertex vertex = graph.getVertex("12:2");
        return (String) vertex.getProperty("Nome");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(OrientDBTestController.class, args);
    }
}
