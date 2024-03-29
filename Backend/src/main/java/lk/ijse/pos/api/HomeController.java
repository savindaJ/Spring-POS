package lk.ijse.pos.api;

import lk.ijse.pos.service.HomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class HomeController {

    private final HomeService homeService;

    /**
     * @param homeService HomeService
     */
    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    /**
     * @return ResponseEntity<Map<String,Number>>
     */
    @GetMapping
    public ResponseEntity<Map<String,Number>> getStatus(){
        return ResponseEntity.ok(homeService.getStatus());
    }
}
