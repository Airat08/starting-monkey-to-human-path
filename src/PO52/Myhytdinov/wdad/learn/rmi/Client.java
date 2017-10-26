package PO52.Myhytdinov.wdad.learn.rmi;

import PO52.Myhytdinov.wdad.data.managers.PreferencesManager;
import PO52.Myhytdinov.wdad.utils.PreferencesConstantManager;

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
        XmlDataManager x=(XmlDataManager)reg.lookup("rmi://"+prefManager.getProperty(PreferencesConstantManager.REGISTRYADDRESS)+":"+
        prefManager.getProperty(PreferencesConstantManager.REGISTRYPORT)+"/XmlDataManager");

        System.out.println(x.negligentReaders().get(0).getFirstName());
    }
}
