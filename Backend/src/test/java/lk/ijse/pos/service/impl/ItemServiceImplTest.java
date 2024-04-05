package lk.ijse.pos.service.impl;

import lk.ijse.pos.config.WebRootConfig;
import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.service.exception.ItemNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author : savindaJ
 * @date : 2024-04-05
 * @since : 0.1.0
 **/
@SpringJUnitConfig(WebRootConfig.class)
@WebAppConfiguration
@Transactional
class ItemServiceImplTest {

    @Autowired
    ItemService itemService;

    @Test
    void saveItem() {
        assertEquals(true, itemService.saveItem(new ItemDTO(
                "",
                "Item 1",
                100.0,
                10
        )));

        assertEquals(false, itemService.saveItem(new ItemDTO(
                "",
                "Item 2",
                200.0,
                20
        )));

        assertEquals(null, itemService.saveItem(new ItemDTO(
                "",
                "Item 3",
                300.0,
                30
        )));
    }

    @Test
    void getAllItems() {
        List<ItemDTO> allItems = itemService.getAllItems();
        System.out.println(allItems);
        assertAll(
                () -> assertNotNull(itemService.getAllItems()),
                () -> assertEquals(0, itemService.getAllItems().size())
        );

        assertArrayEquals(new ItemDTO[]{}, itemService.getAllItems().toArray());
    }

    @Test
    void deleteItem() {
        assertThrows(ItemNotFoundException.class, () -> itemService.deleteItem("I001"));
        assertEquals(true,itemService.deleteItem("ITM-a517d05a"));
    }

    @Test
    void updateItem() {
        assertThrows(ItemNotFoundException.class, () -> itemService.updateItem(new ItemDTO(
                "I001",
                "Item 1",
                100.0,
                10
        )));
    }

    @Test
    void getItemCount() {
        int itemCount = itemService.getItemCount();
        assertEquals(true, itemCount>0);
    }

    @Test
    void getItem() {
        assertThrows(ItemNotFoundException.class, () -> itemService.getItem("I001"));
        assertNotNull(itemService.getItem("ITM-a517d05a"));
    }
}