package test;
import java.lang.reflect.Field;
import java.util.*;

public class DocumentStore {
    private Collection<String> documents = new ArrayList<String>();
    private int capacity;

    public DocumentStore(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public Collection<String> getDocuments() {
//
//        List<String> fieldNames = new ArrayList<>();
//        Collection<Field> field=documents.add(item);
//        for (Field field : fields)
//            documents.add(field.getName());

        return documents;
    }

    public void addDocument(String document) {


        documents.add(document);
        if (this.documents.size() > capacity){

            throw new IllegalStateException();
        }
    }

    @Override
    public String toString() {
        return String.format("Document store: {%d}/{%d}", documents.size(), capacity);
    }

    public static void main(String[] args) {
        DocumentStore documentStore = new DocumentStore(2);
        documentStore.addDocument("item");
        documentStore.addDocument("item2");
//        documentStore.addDocument("item3");
        System.out.println(documentStore);
    }
}