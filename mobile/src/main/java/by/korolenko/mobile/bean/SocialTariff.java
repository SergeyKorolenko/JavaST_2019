package by.korolenko.mobile.bean;

import by.korolenko.mobile.bean.enums.Messenger;

/**
 * @author Sergei Korolenko
 * @version 1.0
 * @since 18.09.2019
 */
public class SocialTariff extends Tariff {

    /**
     * This is the kind of messenger.
     */
    private Messenger messenger;

    /**
     * This is the constructor with parameters.
     *
     * @param name         tariff name
     * @param price        tariff rate
     * @param freeMinute   number of free minutes
     * @param traffic      number of free traffic
     * @param newMessenger messenger type
     */
    public SocialTariff(final String name, final double price,
                        final int freeMinute, final int traffic,
                        final Messenger newMessenger) {
        super(name, price, freeMinute, traffic);
        this.messenger = newMessenger;
    }

    /**
     * Getter for messenger.
     *
     * @return messenger
     */
    public Messenger getMessenger() {
        return messenger;
    }

    /**
     * Setter for messenger.
     *
     * @param newMessenger kind of messenger
     */
    public void setMessenger(final Messenger newMessenger) {
        this.messenger = newMessenger;
    }

    /**
     * This is the override toString method.
     *
     * @return string
     */
    @Override
    public String toString() {
        return "SOCIAL,"
                + super.toString()
                + ',' + messenger;
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
        result = prime * result
                + ((messenger == null) ? 0 : messenger.hashCode());
        return result;
    }

    /**
     * This is the override equals methos.
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
        SocialTariff other = (SocialTariff) obj;
        return messenger == other.messenger;
    }
}
