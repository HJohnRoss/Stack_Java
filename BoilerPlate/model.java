// ===== MODEL =====
@Entity
@Table(name="sqlTables")
public class AllPackages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
//  = ONE TO MANY =
//  Model with forein key
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY) // main model
    private List<Ninja> ninjas;

//  connecting the id to the forein key
    @ManyToOne(fetch = FetchType.LAZY) // joining to main model
    @JoinColumn(name="dojo_id")
    private Dojo dojo;


    // = MANY TO MANY =

    // First model
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable( // creating the join table
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "product_id"), 
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;


    // Second model
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "categories_products", 
        joinColumns = @JoinColumn(name = "category_id"), 
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;
}