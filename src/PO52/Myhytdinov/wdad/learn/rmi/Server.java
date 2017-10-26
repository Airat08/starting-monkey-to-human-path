package PO52.Myhytdinov.wdad.learn.rmi;

import PO52.Myhytdinov.wdad.data.managers.PreferencesManager;
import PO52.Myhytdinov.wdad.utils.PreferencesConstantManager;

import javax.naming.Context;
import javax.naming.InitialContext;

public class Server {
    public static void main(String[] args) throws Exception {
        PreferencesManager prefManager = PreferencesManager.getInstance();
        Context context = new InitialContext();
        context.bind("rmi://"+prefManager.getProperty(PreferencesConstantManager.REGISTRYADDRESS)+":"+
        prefManager.getProperty(PreferencesConstantManager.REGISTRYPORT+"Example"),null);
    }
}
