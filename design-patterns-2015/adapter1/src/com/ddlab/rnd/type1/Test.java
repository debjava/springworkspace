package com.ddlab.rnd.type1;

/**
 * Created by dmishra on 11/16/2015.
 */
public class Test {

    public static void main(String[] args) {

        GermanPlugConnector plugConnector = new GermanPlugConnectorImpl(); //.. create a GermanPlugConnector
        UKElectricalSocket electricalSocket = new UKElectricalSocket();
        UKPlugConnector ukAdapter = new GermanToUKPlugConnectorAdapter(plugConnector);
        electricalSocket.plugIn(ukAdapter);

    }
}
