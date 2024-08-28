# Verbos-HTTP
Definición de metodos HTTP

GET: Recupera información del servidor. Se usa para obtener recursos sin alterar su estado.
POST: Envía datos al servidor para crear un nuevo recurso. El recurso se procesa y se guarda.
DELETE: Elimina un recurso en el servidor.
PUT: Actualiza un recurso existente en el servidor. Si el recurso no existe, puede crearlo.
PATCH: Aplica modificaciones parciales a un recurso existente.
HEAD: Similar a GET, pero solo devuelve los encabezados de la respuesta sin el cuerpo.

Anotaciones Spring Boot

@Autowired: Inyecta automáticamente las dependencias necesarias en un componente.
@GetMapping: Maneja las solicitudes HTTP GET en un método específico del controlador.
@PostMapping: Maneja las solicitudes HTTP POST en un método específico del controlador.
@PutMapping: Maneja las solicitudes HTTP PUT en un método específico del controlador.
@DeleteMapping: Maneja las solicitudes HTTP DELETE en un método específico del controlador.
@PatchMapping: Maneja las solicitudes HTTP PATCH en un método específico del controlador.
@RequestMapping: Define una ruta base para un controlador o método, y puede manejar varios métodos HTTP.
@RestController: Combina @Controller y @ResponseBody, lo que hace que el controlador devuelva directamente los datos en lugar de una vista.
@Override: Indica que un método anula (override) un método en una superclase o interfaz.

@Document(collection = "prueba"): Esta anotación se usa en Spring Data MongoDB para indicar que la clase es un documento de MongoDB, y especifica la colección a la que pertenece, en este caso, "prueba".
@Repository: Marca una clase como un componente de repositorio, que interactúa directamente con la base de datos. Se usa principalmente para la lógica de persistencia.
@Service: Marca una clase como un servicio, que contiene la lógica de negocio de la aplicación. Es un componente de nivel de servicio.

Explicación del metodo

@Override
    public String toString() {
        return "GroceryItem{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}'+"\n";
    }

@Override: Indica que este método está anulando el método toString() heredado de la clase Object.
Devolver una representación en forma de cadena de los datos del objeto GroceryItem.




