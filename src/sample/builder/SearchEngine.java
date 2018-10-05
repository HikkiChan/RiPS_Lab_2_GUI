package sample.builder;

import sample.tariffs.Tariff;
import sample.tariffs.TariffPlus;

import java.util.List;

/**
 * The class that performs the search for the class {@link sample.tariffs.TariffPlus} for a particular parameter.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @see Tariff
 * @since 1.0
 */
public class SearchEngine {
    /**
     * The search method of the tariff plan by parameter "costMinuteInNW".
     *
     * @param tariff         - list of objects of class {@link sample.tariffs.Tariff} or {@link tariffs.TariffPlus}
     * @param costMinuteInNW - cost per minute in the mobile operator network.
     * @return Returns an object of class {@link sample.tariffs.TariffPlus}
     */
    public static Tariff searchTariffForCostMinuteInNW(List<Tariff> tariff, int costMinuteInNW) {
        TariffPlus tariffPlus = new TariffPlus();

        for (Tariff i : tariff) {
            if (i instanceof TariffPlus) {
                tariffPlus = (TariffPlus) i;
                if (tariffPlus.getCostMinuteInNW() == costMinuteInNW) {
                    return tariffPlus;
                }
            }
        }

        return tariffPlus;
    }
}
