interface Keyboard {
    void print();

    void println();
}

class EnKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("Print line");
    }

    @Override
    public void println() {
        System.out.println("Print line with newline");
    }
}

class RuKeyboard implements Keyboard {

    @Override
    public void print() {
        System.out.print("Печатаем строку");
    }

    @Override
    public void println() {
        System.out.println("Печатаем строку с переводом строки");
    }
}
