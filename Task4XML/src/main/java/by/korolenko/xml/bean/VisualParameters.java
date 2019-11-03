package by.korolenko.xml.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 29.10.2019
 */
public class VisualParameters {

    /**
     * Color of a stone.
     */
    private String color;
    /**
     * Transparency.
     */
    private int transparency;
    /**
     * Cut method.
     */
    private String cutMethod;
    /**
     * Number of faces.
     */
    private int faces;

    /**
     * Constructor.
     */
    public VisualParameters() {
    }

    /**
     * Constructor.
     *
     * @param newColor        color
     * @param newTransparency transparency
     * @param newCutMethod    cut method
     * @param newFaces        faces
     */
    public VisualParameters(final String newColor, final int newTransparency,
                            final String newCutMethod, final int newFaces) {
        this.color = newColor;
        this.transparency = newTransparency;
        this.cutMethod = newCutMethod;
        this.faces = newFaces;
    }


    /**
     * Getter for color.
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter for color.
     *
     * @param newColor color
     */
    public void setColor(final String newColor) {
        this.color = newColor;
    }

    /**
     * Getter for transparency.
     *
     * @return transparency
     */
    public int getTransparency() {
        return transparency;
    }

    /**
     * Setter for transparency.
     *
     * @param newTransparency transparency
     */
    public void setTransparency(final int newTransparency) {
        this.transparency = newTransparency;
    }

    /**
     * Getter for cut method.
     *
     * @return cut method
     */
    public String getCutMethod() {
        return cutMethod;
    }

    /**
     * Setter for cut method.
     *
     * @param newCutMethod cut method
     */
    public void setCutMethod(final String newCutMethod) {
        this.cutMethod = newCutMethod;
    }

    /**
     * Getter for faces.
     *
     * @return faces
     */
    public int getFaces() {
        return faces;
    }

    /**
     * Setter for faces.
     *
     * @param newFaces faces
     */
    public void setFaces(final int newFaces) {
        this.faces = newFaces;
    }

    /**
     * To string.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "VisualParameters{"
                + "color='" + color + '\''
                + ", transparency=" + transparency
                + ", cutMethod='" + cutMethod + '\''
                + ", faces=" + faces
                + '}';
    }
}
