package com.pranavd.foody.Controller;

import com.pranavd.foody.Model.MenuItem;
import com.pranavd.foody.Service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/get")
    public List<MenuItem> getAllMenuItems(){
        return  menuService.getAllMenuItems();
    }

    @PostMapping("/add")
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuService.createMenuItem(menuItem);
    }

    @PutMapping("/availability/{itemId}")
    public MenuItem updateItem(@PathVariable Long itemId){
        return menuService.itemAvailability(itemId);
    }

    @DeleteMapping("/delete/{itemId}")
    public MenuItem deleteMenuItem(@PathVariable Long itemId){
        return menuService.deleteMenuItem(itemId);
    }
}
