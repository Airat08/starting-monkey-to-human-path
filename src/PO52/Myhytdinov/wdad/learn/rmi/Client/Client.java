package PO52.Myhytdinov.wdad.learn.rmi.Client;

import PO52.Myhytdinov.wdad.data.managers.PreferencesManager;
import PO52.Myhytdinov.wdad.PreferencesConstantManager;
import PO52.Myhytdinov.wdad.learn.rmi.XmlDataManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception    {


        PreferencesManager prefManager = PreferencesManager.getInstance();

        Registry reg= LocateRegistry.getRegistry(Integer.parseInt(prefManager.getProperty(PreferencesConstantManager.REGISTRYPORT)));
        XmlDataManager x=(XmlDataManager)reg.lookup("XmlDataManager");

        System.out.println(x.negligentReaders().get(0).getFirstName());
    }
}
