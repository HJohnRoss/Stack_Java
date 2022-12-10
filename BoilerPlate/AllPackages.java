// ===== CONTROLLER =====
@Controller

	@Autowired // to connect to the service
	private ...Service ...Service; 

@GetMapping("/") // get info/show a page
public String index(
    @PathVariable("id") Long id, // getting a path variable
    Model model,
    BindingResult result,
    @Valid @ModelAttribute("id") Long id, // form:form
    // this is getting info from a regualar form
    @RequestParam(value = "category_name") String name
    ) {}


@PostMapping // creating a object
@PutMapping // updating a object
@RequestMapping


// ===== REPOSITORY =====
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();

    // add more queries to acess them in your service
}

// ===== SERVICE =====
@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}

    //  WHERE YOU CAN ACCESS YOUR QUERIES
}