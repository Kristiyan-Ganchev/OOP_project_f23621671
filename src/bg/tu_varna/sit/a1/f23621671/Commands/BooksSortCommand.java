package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

import java.util.Arrays;

public class BooksSortCommand implements Command{
    private static int compareBy;
    private static boolean ascOrder;
    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser==null){
            System.out.println("Not logged in");
            return;
        }
        String[] bookArray=new String[CommandProcessor.books.size()];
        int i=0;
        for (Book book:CommandProcessor.books
             ) {
            bookArray[i]=book.toWrite();
            i++;
        }
        String[] tokens=input.split(" ");

        if(tokens[0].equals("title")){
            compareBy=1;
        }
        else if(tokens[0].equals("author")){
            compareBy=0;
        }
        else if(tokens[0].equals("year")){
            compareBy=5;
        }
        else if(tokens[0].equals("rating")){
            compareBy=7;
        }
        else {
            System.out.println("No such criteria for comparison!");
            return;
        }

        if(tokens.length>1){
            if(tokens[1].equals("asc")){
                ascOrder=true;
            }
            else if(tokens[1].equals("desc")){
                ascOrder=false;
            }
            else {
                System.out.println("No such order!");
                return;
            }
        }
        else ascOrder=true;
        sort(bookArray,0, bookArray.length-1);
        CommandProcessor.books.clear();
        for (String bookString : bookArray) {
            String[] bookData = bookString.split(";");
            CommandProcessor.books.add(new Book.BookBuilder(bookData[0],bookData[1],bookData[2],bookData[3])
                    .withBookDescription(bookData[4])
                    .withBookYear((Integer.parseInt(bookData[5])))
                    .witTags(bookData[6])
                    .withRating(Float.parseFloat(bookData[7]))
                    .build());
        }
        System.out.println("Books sorted!");
    }
static void merge(String arr[], int l, int m, int r)
{
    int n1 = m - l + 1;
    int n2 = r - m;

    String L[] = new String[n1];
    String R[] = new String[n2];

    for (int i = 0; i < n1; ++i)
        L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
        R[j] = arr[m + 1 + j];

    int i = 0, j = 0;
    int k = l;

    while (i < n1 && j < n2) {
        String Lsub=L[i].split(";")[compareBy];
        String Rsub=R[j].split(";")[compareBy];
        if(ascOrder ? Lsub.compareTo(Rsub) <= 0 : Lsub.compareTo(Rsub) > 0) {
            arr[k] = L[i];
            i++;
        } else {
            arr[k] = R[j];
            j++;
        }
            k++;
    }
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}
    static void sort(String arr[], int l, int r)
    {
        if (l < r) {

            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
    @Override
    public void description() {
        System.out.println("books sort");
    }
}
