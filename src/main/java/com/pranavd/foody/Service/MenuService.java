package com.pranavd.foody.Service;

import com.pranavd.foody.Model.MenuItem;
import com.pranavd.foody.Repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuItemRepository menuItemRepository;

    public List<MenuItem> getAllMenuItems(){
        return menuItemRepository.findByIsAvailableTrue();
    }

    public MenuItem createMenuItem(MenuItem menuItem){
        return menuItemRepository.save(menuItem);
    }

    public MenuItem itemAvailability(Long itemId){
        MenuItem item = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        item.setAvailable(!item.isAvailable());
        return menuItemRepository.save(item);
    }

    public MenuItem deleteItem(Long itemId){
        MenuItem item = menuItemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        menuItemRepository.deleteById(itemId);
        return menuItemRepository.save(item);
    }

}
