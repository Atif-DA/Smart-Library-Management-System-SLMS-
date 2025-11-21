
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Library lib=new Library();

        while(true){
            System.out.println("\n1.Add Book\n2.View\n3.Search\n4.Issue\n5.Return\n6.Undo\n7.Exit");
            int c=sc.nextInt();

            switch(c){
                case 1 -> {
                    System.out.print("ID: "); int id=sc.nextInt();
                    System.out.print("Title: "); String t=sc.next();
                    System.out.print("Author: "); String a=sc.next();
                    lib.addBook(new Book(id,t,a));
                }
                case 2 -> lib.viewBooks();
                case 3 -> {
                    System.out.print("ID: "); int id=sc.nextInt();
                    Book b=lib.search(id);
                    System.out.println(b!=null ? b : "Not found");
                }
                case 4 -> { System.out.print("ID: "); lib.issueBook(sc.nextInt()); }
                case 5 -> { System.out.print("ID: "); lib.returnBook(sc.nextInt()); }
                case 6 -> lib.undo();
                case 7 -> { return; }
            }
        }
    }
}
