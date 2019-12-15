package by.korolenko.adsdesk.bean;

/**
 * @author Sergei Korolenko
 */
public class Category extends Entity {

    /**
     * Category name.
     */
    private String categoryName;

    /**
     * Parent category.
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

    /**
     * Getter for parent category.
     *
     * @return parent category
     */
    public Category getParent() {
        return parent;
    }

    /**
     * Setter for parent category.
     * @param parent parent category
     */
    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Category [categoryName=" + categoryName + ", parent=" + parent + ", toString()=" + super.toString()
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((categoryName == null) ? 0 : categoryName.hashCode());
        result = prime * result + ((parent == null) ? 0 : parent.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Category other = (Category) obj;
        if (categoryName == null) {
            if (other.categoryName != null)
                return false;
        } else if (!categoryName.equals(other.categoryName))
            return false;
        if (parent == null) {
            if (other.parent != null)
                return false;
        } else if (!parent.equals(other.parent))
            return false;
        return true;
    }
}
