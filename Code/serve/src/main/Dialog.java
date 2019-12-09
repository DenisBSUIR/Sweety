package main;

import java.util.ArrayDeque;

public class Dialog {

    private ArrayDeque<String> dialog = new ArrayDeque<>();

    public ArrayDeque<String> getDialog() {
        return dialog;
    }

    public void setDialog(ArrayDeque<String> dialog) {
        this.dialog = dialog;
    }

    public synchronized void addMessageToDialog(String message){
        dialog.addFirst(message);
    }

}
