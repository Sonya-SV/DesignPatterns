interface Touchpad {
    void track(int deltaX, int deltaY);
}

class RuTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {

        System.out.println("Передвинулись на "
                + (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))
                + " пикселей.");
    }
}

class EnTouchpad implements Touchpad {

    @Override
    public void track(int deltaX, int deltaY) {

        System.out.println("Moved on "
                + (int)Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2))
                + " pixels.");
    }
}