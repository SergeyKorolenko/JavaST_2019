package by.korolenko.mobile.bean;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class HomeTariff extends Tariff {

    /**
     * This is the number of channels.
     */
    private int channel;

    /**
     * This is the constructor with parameters.
     *
     * @param name       tariff name
     * @param price      tariff rate
     * @param freeMinute number of free minutes
     * @param traffic    number of free traffic
     * @param newChannel number of channels
     */
    public HomeTariff(final String name, final double price,
                      final int freeMinute, final int traffic,
                      final int newChannel) {
        super(name, price, freeMinute, traffic);
        this.channel = newChannel;
    }

    /**
     * Getter for channel.
     *
     * @return channel
     */
    public int getChannel() {
        return channel;
    }

    /**
     * Setter for channel.
     *
     * @param newChannel number of channels
     */
    public void setChannel(final int newChannel) {
        this.channel = newChannel;
    }

    /**
     * This is the override toString method.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "HOME,"
                + super.toString()
                + ',' + channel;
    }

    /**
     * This is the override hashCode method.
     *
     * @return int number
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + channel;
        return result;
    }

    /**
     * This is the override equals method.
     *
     * @param obj the object to be compared
     * @return comparison result
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HomeTariff other = (HomeTariff) obj;
        return channel == other.channel;
    }
}
