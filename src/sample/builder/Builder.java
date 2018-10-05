package sample.builder;

import sample.tariffs.TariffPlus;

/**
 * The interface of tariff plan design with properties of {@link sample.tariffs.Tariff} or {@link sample.tariffs.TariffPlus} class.
 *
 * @author Dzmitry Sokolenko
 * @version 1.0
 * @since 1.0
 */
public interface Builder {
    /**
     * Get-method for registration of the tariff plan "TariffPlus"
     *
     * @param subscriptionFee     - mobile tariff subscription fee.
     * @param costMinuteInNW      - cost per minute in the mobile operator network.
     * @param costMinuteInOtherNW - cost per minute in the network of another mobile operator.
     * @param costSms             - cost of one sms message.
     * @param costInternet        - the cost of one megabyte of Internet traffic.
     * @param packageInternet     - Internet tariff plan package.
     * @param packageMinute       - tariff minutes plan package.
     * @return Returns an object of class {@link sample.tariffs.TariffPlus}
     */
    TariffPlus getTariffPlus(int subscriptionFee,
                             int costMinuteInNW,
                             int costMinuteInOtherNW,
                             int costSms,
                             int costInternet,
                             int packageInternet,
                             int packageMinute);
}