package data;

/**
 * Created by mariam.javed on 20/05/16.
 */
public class Category {

    private String name;
    private int categoryImage;
    private int id;

    public Category(String name, int categoryImage, int id) {
        this.name = name;
        this.categoryImage = categoryImage;
        this.id = id;
    }

    public Category() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(int categoryImage) {
        this.categoryImage = categoryImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
