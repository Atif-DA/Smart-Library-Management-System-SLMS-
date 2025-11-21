
import java.util.*;

public class Library {
    private LinkedList<Book> books = new LinkedList<>();
    private Stack<String> actions = new Stack<>();

    public void addBook(Book b){
        books.add(b);
        actions.push("Added book " + b.getId());
    }

    public void viewBooks(){
        books.forEach(System.out::println);
    }

    public Book search(int id){
        for(Book b: books) if(b.getId()==id) return b;
        return null;
    }

    public void issueBook(int id){
        Book b=search(id);
        if(b!=null && !b.isIssued()){
            b.issue();
            actions.push("Issued book "+id);
            System.out.println("Issued!");
        } else System.out.println("Not available!");
    }

    public void returnBook(int id){
        Book b=search(id);
        if(b!=null && b.isIssued()){
            b.returnBook();
            actions.push("Returned book "+id);
            System.out.println("Returned!");
        } else System.out.println("Not issued!");
    }

    public void undo(){
        if(actions.isEmpty()) System.out.println("Nothing to undo!");
        else System.out.println("Undo: "+actions.pop());
    }
}
