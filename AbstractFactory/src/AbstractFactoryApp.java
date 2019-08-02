
public class AbstractFactoryApp {

    public static DeviceFactory getFactoryByCountry(String language){
        switch (language){
            case "EN": {
                return new EnDeviceFactory();
            }
            case "RU": {
                return new RuDeviceFactory();
            }
            default:{
                throw new RuntimeException("Unsupported country: " + language);
            }
        }
    }

    public static void main(String[] args) {
        DeviceFactory deviceFactory = getFactoryByCountry("RU");
        Mouse mouse = deviceFactory.getMouse();
        Keyboard keyboard = deviceFactory.getKeyboard();
        Touchpad touchpad = deviceFactory.getTouchpad();

        mouse.click();
        keyboard.print();
        keyboard.println();
        touchpad.track(3,4);
    }

}


