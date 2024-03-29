package lk.ijse.pos.service;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
public interface ItemService {
    boolean saveItem(ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    boolean deleteItem(String itemCode);

    boolean updateItem(ItemDTO itemDTO);

    int getItemCount();

    Item getItem(String itemCode);
}
