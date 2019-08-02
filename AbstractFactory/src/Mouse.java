interface Mouse {
    void click();

    void doubleclick();

    void scroll(int direction);
}


class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void doubleclick() {
        System.out.println("Double mouse click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Scroll up");
        else if (direction < 0)
            System.out.println("Scroll down");
        else
            System.out.println("No scrolling");
        ;
    }
}


class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Щелчок мышью");
    }

    @Override
    public void doubleclick() {
        System.out.println("Двойной щелчок мышью");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0)
            System.out.println("Скролл вверх");
        else if (direction < 0)
            System.out.println("Скролл вниз");
        else
            System.out.println("Не скроллим");
        ;
    }
}
