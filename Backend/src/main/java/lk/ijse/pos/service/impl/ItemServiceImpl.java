package lk.ijse.pos.service.impl;

import lk.ijse.pos.dto.ItemDTO;
import lk.ijse.pos.entity.Item;
import lk.ijse.pos.repo.ItemRepo;
import lk.ijse.pos.service.ItemService;
import lk.ijse.pos.service.exception.ItemNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : savindaJ
 * @date : 2024-03-29
 * @since : 0.1.0
 **/
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepo itemRepo;

    private final ModelMapper modelMapper;

    /**
     * @param itemRepo    ItemRepo
     * @param modelMapper ModelMapper
     */
    public ItemServiceImpl(ItemRepo itemRepo, ModelMapper modelMapper) {
        this.itemRepo = itemRepo;
        this.modelMapper = modelMapper;
    }

    /**
     * @param itemDTO ItemDTO
     * @return boolean
     */
    @Override
    public boolean saveItem(ItemDTO itemDTO) {
        Item save = itemRepo.save(modelMapper.map(itemDTO, Item.class));
        return save != null;
    }

    /**
     * @return List<ItemDTO>
     */
    @Override
    public List<ItemDTO> getAllItems() {
        List<Item> all = itemRepo.findAll();
        return modelMapper.map(all, List.class);
    }

    /**
     * @param itemCode String
     * @return boolean
     */
    @Override
    public boolean deleteItem(String itemCode) {
        if (!itemRepo.existsById(itemCode)) throw new ItemNotFoundException("Item not found");
        itemRepo.deleteById(itemCode);
        return true;
    }

    /**
     * @param itemDTO ItemDTO
     * @return boolean
     */
    @Override
    public boolean updateItem(ItemDTO itemDTO) {
        if (!itemRepo.existsById(itemDTO.getItemCode())) throw new ItemNotFoundException("Item not found");
        Item save = itemRepo.save(modelMapper.map(itemDTO, Item.class));
        return save != null;
    }

    /**
     * @return int
     */
    @Override
    public int getItemCount() {
        return itemRepo.getItemCount();
    }

    /**
     * @param itemCode String
     * @return Item
     */
    @Override
    public Item getItem(String itemCode) {
        return itemRepo.findById(itemCode).get();
    }
}
