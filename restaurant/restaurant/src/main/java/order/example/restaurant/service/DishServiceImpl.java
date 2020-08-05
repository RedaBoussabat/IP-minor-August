/*
package order.example.restaurant.service;

import order.example.restaurant.domain.Client;
import order.example.restaurant.domain.Dish;
import order.example.restaurant.dto.ClientDTO;
import order.example.restaurant.dto.DishDTO;
import order.example.restaurant.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {
    private final DishRepository repository;

    public DishServiceImpl(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DishDTO> getDishes() {
        return repository.findAll().stream().map(this::convert).collect(Collectors.toList());
    }


    @Override
    public DishDTO addDish(DishDTO dishDTO){
        Dish dish = new Dish();
        dish.setDish(dishDTO.getDish());
        dish.setDescription(dishDTO.getDescription());
        this.repository.save(dish);
        return convert(dish);
    }

    private DishDTO convert(Dish dish){
        DishDTO dishDTO = new DishDTO();
        dishDTO.setId(dish.getId());
        dishDTO.setDish(dish.getDish());
        dishDTO.setDescription(dish.getDescription());
        return dishDTO;
    }
}
*/
