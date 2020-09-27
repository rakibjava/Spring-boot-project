package guru.spsringframework.mrhpetclcinic.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexRestCotroller {

    @GetMapping("/rest")
    public String index(){
        return "Index Page";
    }
}
