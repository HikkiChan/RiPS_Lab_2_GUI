package sample.builder;

import sample.tariffs.Tariff;
import sample.tariffs.TariffPlus;

import java.util.Comparator;

/**
 * The class-comparator for objects of class {@link sample.tariffs.TariffPlus}.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @see TariffPlus
 * @since 1.0
 */
public class TariffComparator implements Comparator<Tariff> {
    /**
     * Comparable-method for object of class @link tariffs.TariffPlus}.
     *
     * @param o1 - object of class {@link sample.tariffs.Tariff} or {@link sample.tariffs.TariffPlus}.
     * @param o2 - object of class {@link sample.tariffs.Tariff} or {@link sample.tariffs.TariffPlus}.
     * @return Returns result of comparator.
     */
    @Override
    public int compare(Tariff o1, Tariff o2) {
        TariffPlus tariffPlus1 = new TariffPlus();
        TariffPlus tariffPlus2 = new TariffPlus();

        if (o1 instanceof TariffPlus) {
            tariffPlus1 = (TariffPlus) o1;
        }

        if (o2 instanceof TariffPlus) {
            tariffPlus2 = (TariffPlus) o2;
        }

        return tariffPlus1.getSpecies().compareTo(tariffPlus2.getSpecies());
    }
}
