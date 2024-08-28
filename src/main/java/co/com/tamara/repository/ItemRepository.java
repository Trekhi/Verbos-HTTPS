package co.com.tamara.repository;

import co.com.tamara.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository <GroceryItem, String> {

}
