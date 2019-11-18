package by.korolenko.adsdesk.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 14.11.2019
 */
public class Category extends Entity {

    /**
     * Category name.
     */
    private String categoryName;

    /**
     * Subcategory id.
     */
    private Category parent;

    /**
     * Constructor without parameters.
     */
    public Category() {
    }

    /**
     * Getter for category name.
     *
     * @return category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Setter for category name.
     *
     * @param newCategoryName category name
     */
    public void setCategoryName(final String newCategoryName) {
        this.categoryName = newCategoryName;
    }

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}
