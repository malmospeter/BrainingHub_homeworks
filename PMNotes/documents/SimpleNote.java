package pmnotes.documents;


public class SimpleNote extends Notes {

    public SimpleNote(String name, String content) {
        super(name, content);
    }

    @Override
    public String toString() {
        return super.toString() + '}';
    }

}
