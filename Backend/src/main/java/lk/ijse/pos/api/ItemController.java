package lk.ijse.pos.api;

import jakarta.validation.Valid;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.util.Generator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author : savindaJ
 * @date : 2024-03-28
 * @since : 0.1.0
 **/
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * @param itemService ItemService
     */
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    /**
     * @return List<ItemDTO>
     */
    @GetMapping
    public List<ItemDTO> getAll(){
        return itemService.getAllItems();
    }

    /**
     * @param itemDTO ItemDTO
     * @return ResponseEntity<?>
     */
    @PostMapping
    public ResponseEntity<?> saveItem(@RequestBody @Valid ItemDTO itemDTO) {
        itemDTO.setItemCode(Generator.generateItemID());
        if (!itemService.saveItem(itemDTO)) throw new RuntimeException("Failed to save the item");
        Map<String,String> response = new LinkedHashMap<>();
        response.put("message","Item saved successfully");
        logger.info(response.toString());
        return ResponseEntity.created(null).body(response);
    }

    /**
     * @param itemCode String
     * @return ResponseEntity<?>
     */
    @DeleteMapping
    public ResponseEntity<?> deleteItem(@RequestParam("itemCode") String itemCode) {
        if (!itemService.deleteItem(itemCode)) throw new RuntimeException("Failed to delete the item");
        Map<String,String> response = new LinkedHashMap<>();
        response.put("message","Item deleted successfully");
        logger.info(response.toString());
        return ResponseEntity.ok(response);
    }

    /**
     * @param itemDTO ItemDTO
     * @return ResponseEntity<?>
     */
    @PutMapping
    public ResponseEntity<?> updateItem(@RequestBody @Valid ItemDTO itemDTO) {
        if (!itemService.updateItem(itemDTO)) throw new RuntimeException("Failed to update the item");
        Map<String,String> response = new LinkedHashMap<>();
        response.put("message","Item updated successfully");
        logger.info(response.toString());
        return ResponseEntity.ok(response);
    }
}
