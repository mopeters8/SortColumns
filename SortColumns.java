import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*MY TASKS
    Return the indices of the columns in A that are not in sorted order.
    Return an empty set of indices {} if all columns are in order.
    Return {-1} if there are any errors.
 */

public class SortColumns
{
    public static void main(String args[])
    {
        //HERE ARE ALL EXAMPLES USED FOR THE LAB. IVE CHECKED ALL AND THEY ALL RUN ACCORDINGLY.

        //String aList[] = {"zyw", "wvu", "tsr"};
        //String aList[] = {"a", "b"};
        //String aList[] = {"cba", "daf", "ghi"};
        String aList[] = {"He", "Was", "Cool"};

        System.out.print("INPUT A = ");
        for (int i = 0; i < aList.length; i++) {
            if (i == 0)
            {
                System.out.print("{");
            }
            System.out.print("'"+aList[i]+"',");
            if(i+1 == aList.length)
            {
                System.out.print("}\n");
            }
        }
        boolean fits = false;
        int firstNum = aList[0].length();
        for (int i = 0; i < aList.length; i++) {
            if (aList[i].length() == firstNum)
            {
                fits = true;
            }
            else
            {
                fits = false;
                i = aList.length;
            }
        }


        if(fits == true ) {
            List<Integer> lastList = minDeletionSize(aList);
        //OUTPUT FOR NOTHING WRONG
            System.out.print("OUTPUT: ");
            if (lastList.size() == 0){
                System.out.println("{ }");
            }

        //OUTPUT FOR FOUND SOMETHING WRONG

            for (int q = 0; q < lastList.size(); q++) {
                if (q == 0) {
                    System.out.print("{");
                }
                System.out.print(lastList.get(q) + ",");
                if (q + 1 == lastList.size()) {
                    System.out.println("}");
                }
            }
        }
        else
        {
            System.out.println("OUTPUT: {-1}");
        }
    }

    public static List<Integer> minDeletionSize(String [] A)
    {
        List<Integer> dList = new ArrayList<Integer>();  //its gonna be array of integers because its returning the 0, -1, or indices.
        int roundAmount = 0; //I am using this as well as the roundAMount in the if statement, so if it sees that a string is only size of one, it wont go again and get an index error.
        for (int j = 0; j < A.length ; j++)
        {
            char[] templist = new char[A.length]; //here i am creating a templist and adding the letters of position j into the list of each string in Alist.
            if (j < A.length && roundAmount == 0){ //THIS IS TO STOP IT FROM GOING FURTHER, WHEN ITS JUST 1 CHAR FOR EACH.  //USE HAS NEXT FUNCTION?
                for (int i = 0; i < A.length; i++){
                    if (A[i].length() == 1)
                    {
                        roundAmount++;
                    }
                    templist[i]=A[i].charAt(j);//here i am adding the chars from the strings at position j.
                }
                for (int l = 0; l < templist.length; l++) {
                    if (l < templist.length)
                    {
                        /*if ((l+1) == templist.length) {                                           //WAS USING THIS TO TEST IF IT WAS READING THE CHARS CORRECTLY.
                            System.out.println(templist[l]+" Is the last!");
                        }

                        else if (templist[l] < templist[l + 1]) {
                            System.out.println("Checking: "+templist[l]+" & "+templist[l+1]);
                        }*/

                        if ((l+1) != templist.length && templist[l] > templist[l + 1])              //I NOTICED AT VERY END THAT I DONT NEED THE 'IF' AND 'IFELSE', I CAN JUST USE ONE IF AND USE THE INVERSE OF THE OTHERS.
                        {
                            dList.add(j);
                            l = templist.length;

                        }
                    }
                }
            }
            //System.out.println("___ "+roundAmount+" ___");  //used for checking

        }

        return dList;
    }
}