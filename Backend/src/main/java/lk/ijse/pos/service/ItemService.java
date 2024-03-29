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
    /**
     * @param itemDTO itemDTO
     * @return boolean
     */
    boolean saveItem(ItemDTO itemDTO);

    /**
     * @return List<ItemDTO>
     */
    List<ItemDTO> getAllItems();

    /**
     * @param itemCode itemCode
     * @return boolean
     */
    boolean deleteItem(String itemCode);

    /**
     * @param itemDTO itemDTO
     * @return boolean
     */
    boolean updateItem(ItemDTO itemDTO);

    /**
     * @return int
     */
    int getItemCount();

    /**
     * @param itemCode itemCode
     * @return Item
     */
    Item getItem(String itemCode);
}
