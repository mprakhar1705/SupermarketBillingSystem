import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Intro {


   public void introMsg()
   {
       System.out.println("WELCOME TO THE SUPERMARKET");

   }

   public void displayMenu()
   { Scanner in = new Scanner(System.in);
     char ch;
   do
       {
           //system("cls");
           System.out.println("\n\n\n\tMAIN MENU");
           System.out.println("\n\n\t01. CUSTOMER");
           System.out.println("\n\n\t02. ADMINISTRATOR");
           System.out.println("\n\n\t03. EXIT");
           System.out.println("\n\n\tPlease Select Your Option (1-3) ");
           ch = in.next().charAt(0);
//           switch(ch)
//           {
//               case '1': system("cls");
//                   place_order(l);
//                   getch();
//                   break;
//               case '2': admin_menu(l);
//                   break;
//               case '3':exit(0);
//               default :printf("Wrong Choice");
//           }
       }while(ch!='3');
   }



    public static void main(String args[])
    {
            Intro i = new Intro() ;
             i.introMsg();
             i.displayMenu();
    }
}
