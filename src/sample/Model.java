package sample;

import sample.builder.SearchEngine;
import sample.builder.TariffPlusBuilder;
import sample.builder.TariffComparator;
import sample.client.Client;
import sample.tariffs.Tariff;
import sample.tariffs.TariffPlus;

import java.util.ArrayList;
import java.util.List;

class Model {
    enum TypeText {TARIFFS, CLIENTS}

    private List<Tariff> listTariffs;
    private List<Client> listClients;

    Model() {
        listTariffs = new ArrayList<>();
        listClients = new ArrayList<>();

        TariffPlus lite = TariffPlusBuilder.getTariffPlus(25, 25, 25,
                25, 25, Tariff.Species.LITE, 512, 60);
        TariffPlus smart = TariffPlusBuilder.getTariffPlus(50, 15, 15,
                15, 15, Tariff.Species.SMART, 1024, 120);
        TariffPlus maximum = TariffPlusBuilder.getTariffPlus(100, 10, 10,
                10, 10, Tariff.Species.MAXIMUM, 2048, 180);

        listTariffs.add(maximum);
        listTariffs.add(smart);
        listTariffs.add(lite);
    }

    String searchWork(String inpText) {
        int i = Integer.parseInt(inpText);
        return SearchEngine.searchTariffForCostMinuteInNW(listTariffs, i).toString();
    }

    String buildLabelText(TypeText type) {
        StringBuilder builderStr = new StringBuilder();
        if(type == TypeText.TARIFFS) {
            for (Tariff tariffBonus : listTariffs) {
                builderStr.append(tariffBonus).append("\n");
            }
        } else {
            for (Client client : listClients) {
                builderStr.append(client).append("\n");
            }
        }
        return builderStr.toString();
    }

    String searchWork() {
        listTariffs.sort(new TariffComparator());
        return buildLabelText(TypeText.TARIFFS);
    }

    String addUser(String name, String number, String species) {
        Client client = new Client();
        switch (species){
            case "smart":
                client = new Client(name, number, Tariff.Species.SMART);
                listClients.add(client);
                break;
            case "lite":
                client = new Client(name, number, Tariff.Species.LITE);
                listClients.add(client);
                break;
            case "maximum":
                client = new Client(name, number, Tariff.Species.MAXIMUM);
                listClients.add(client);
                break;
        }

        return buildLabelText(TypeText.CLIENTS);
    }
}
