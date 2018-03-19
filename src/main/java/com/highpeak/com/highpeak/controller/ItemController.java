package com.highpeak.com.highpeak.controller;

import com.highpeak.service.ItemService;
import com.highpeak.springproject.Item;
import com.highpeak.springproject.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@EnableAutoConfiguration
@RestController
@RequestMapping( "/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/lostItem",method = RequestMethod.POST)
    public Item addLostItem(@RequestBody ItemModel itemModel){

        return itemService.addLostItem(itemModel);
    }

    @RequestMapping(value = "/{item_id}",method = RequestMethod.DELETE )
    public String removeItemById(@PathVariable int item_id){

        return itemService.removeItemById(item_id);
    }
    @RequestMapping(value = "/{isDeleted}",method = RequestMethod.GET)
    public List<Item> lostItems(@PathVariable boolean isDeleted){
        return itemService.findAllItems(isDeleted);
    }

    @RequestMapping(value = "/{brand}",method = RequestMethod.PUT)
    public String updateLostAndFoundItem(@PathVariable String brand){

        return  itemService.updateLostAndFoundItem(brand);
    }

}
