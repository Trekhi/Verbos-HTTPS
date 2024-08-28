package co.com.tamara.service;

import co.com.tamara.model.GroceryItem;
import co.com.tamara.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {


    private ItemRepository itemRepository;

    private List<GroceryItem> groceryItems;

    boolean started=false;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /*Inicializar clase para poder usar los metodos*/
    public void setGroceryItems(){
        if (this.started==false){
            this.groceryItems = new ArrayList();
            this.started=true;
        }
    }

    //Funciona
    public String getAll(){
        try{
            List<GroceryItem> groceryItem = itemRepository.findAll();
            return groceryItem.toString();
        }catch (Exception e){
            System.err.println("errr");
            return String.valueOf(new ArrayList<>());
        }
    }
    //Funciona
    public String insert(GroceryItem groceryItem){
        setGroceryItems(); //Esto lo inicializa para poder enviar la información y contruirlo
        groceryItems.add(new GroceryItem(groceryItem.getId(), groceryItem.getName(), groceryItem.getQuantity(), groceryItem.getCategory()));
        itemRepository.save(groceryItem);
        return "---ITEM INSERTADO---\n"+groceryItem.toString();
    }

    public String update(GroceryItem groceryItem) {
        Optional<GroceryItem> existingItem = itemRepository.findById(groceryItem.getId());

        if (existingItem.isPresent()) {
            // Actualiza los campos del ítem existente con los datos del ítem proporcionado
            GroceryItem itemToUpdate = existingItem.get();
            itemToUpdate.setName(groceryItem.getName());
            itemToUpdate.setQuantity(groceryItem.getQuantity());
            itemToUpdate.setCategory(groceryItem.getCategory());

            // Guarda los cambios en la base de datos
            itemRepository.save(itemToUpdate);

            return "---ITEM ACTUALIZADO---\n" + itemToUpdate.toString();
        } else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    //LISTO
    public String delete(String id) {
        //setGroceryItems();
        Optional<GroceryItem> deleteItem = itemRepository.findById(id);
        if (deleteItem.isPresent()) {
            itemRepository.deleteById(id);
            return "---ITEM ELIMINADO---\n" + deleteItem.toString();
        } else {
            return "---ITEM NO ENCONTRADO---";
        }
    }

    //LISTO
    public String updateData(String id, GroceryItem groceryItem){

        Optional<GroceryItem> optionalGroceryItem = itemRepository.findById(id);

        if(optionalGroceryItem.isPresent()){
            GroceryItem item = optionalGroceryItem.get();

            if (groceryItem.getName() != null) {
                item.setName(groceryItem.getName());
            }
            if (groceryItem.getCategory() != null) {
                item.setCategory(groceryItem.getCategory());
            }
            if(groceryItem.getQuantity() >= 0 ){
                item.setQuantity(groceryItem.getQuantity());
            }
            itemRepository.save(item);

            return "---ITEM ACTUALIZADO---\n" + item.toString();
        }
        return "---ITEM NO ENCONTRADO---";
        }

    public String optionsUpdate(){
        return "OPTIONS: It insert a new grosery item, if the grosery item doesn't exist, it will create automatically";
    }

}
