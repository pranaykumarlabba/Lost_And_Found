package com.highpeak.service;

import com.highpeak.springproject.Item;
import com.highpeak.springproject.ItemModel;
import com.highpeak.user.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item addLostItem(ItemModel itemModel){

        Item item = new Item();
        item.setName(itemModel.getName());
        item.setBrand(itemModel.getBrand());
        item.setColor((itemModel.getColor()));
        item.setSize(itemModel.getSize());
        item.setDeleted(false);
        item.setFound(itemModel.isFound());
        return itemRepository.save(item);
    }

    @Transactional // persisting and deleting objects requires a transaction in JPA.

    public String removeItemById(int item_id){

        itemRepository.removeItemById(item_id);

        return "deletedSuccessfully";

    }

    public List<Item> findAllItems(boolean isDeleted){
        return itemRepository.getAllLostItemByIsDeleted(isDeleted);
    }

    @Transactional
    public String updateLostAndFoundItem(String brand){

        itemRepository.updateItemByIsFound(brand);

        return "Updated...";
    }

}
