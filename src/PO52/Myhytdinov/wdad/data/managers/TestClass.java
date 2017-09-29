package PO52.Myhytdinov.wdad.data.managers;

public class TestClass {
    public static void main(String[] args) throws Exception {
        PreferencesManager preferencesManager = PreferencesManager.getInstance();
        preferencesManager.setClassprovider("Тест 1");
        preferencesManager.setCreateregistry("Тест 2");
        preferencesManager.setPolicypath("Тест 3");
        preferencesManager.setRegistryaddress("Тест 4");
        preferencesManager.setRegistryport(5);
        preferencesManager.setUsecodebaseonly("Тест 6");
        preferencesManager.saveTransformXml();


        System.out.println(preferencesManager.getClassprovider() + "\n" +
        preferencesManager.getCreateregistry() + "\n" +
        preferencesManager.getPolicypath() + "\n" +
        preferencesManager.getRegistryaddress()+ "\n" +
        preferencesManager.getRegistryport() + "\n" +
        preferencesManager.getUsecodebaseonly());
    }
}
