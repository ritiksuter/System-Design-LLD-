import java.util.Stack;

class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Creates a memento (snapshot) of the current state
    public Memento save() {
        return new Memento(text);
    }

    // Restores the state from the given memento
    public void restore(Memento memento) {
        this.text = memento.getText();
    }
}

class Memento {
    private final String text;

    public Memento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class EditorHistory {
    private Stack<Memento> history = new Stack<>();

    public void push(Memento memento) {
        history.push(memento);
    }

    public Memento pop() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}

public class MomentoDesignPattern {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.setText("Hello");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());

        editor.setText("Hello, World!");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());

        editor.setText("Hello, World! Welcome to Memento Pattern.");
        System.out.println("Current text: " + editor.getText());

        Memento previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After undo, text: " + editor.getText());

        previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After second undo, text: " + editor.getText());
    }
}