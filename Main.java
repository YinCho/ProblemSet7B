import java.util.ArrayList;

public class Main
{
    ArrayList<Integer> lst = new ArrayList();

    public ArrayList<Integer> Eratosthenes(int size) {
        for(int k = 2; k < size+1; k++) {
            lst.add(k);
        }
        for(int i = lst.size()-1 ; i >= 0; i--) {
            if (lst.get(i)/2 == 0 && lst.get(i) != 2 || lst.get(i) % 2 == 0 && lst.get(i) != 2|| lst.get(i) % 3 == 0 && lst.get(i) != 2|| lst.get(i) % 5 == 0 && lst.get(i) != 2|| lst.get(i) % 7 == 0 && lst.get(i) != 2) {
                lst.remove(i);
            }

        }
        return lst;
    }

    public void GolbachConjecture(int n) {
        ArrayList<Integer> nums = Eratosthenes(n);
        int x = 0;
        int y = 0;
        for (int i = 0; i< nums.size(); i++) {
            for(int k = 1; k < nums.size(); k++) {
                if (nums.get(i) + nums.get(k) == n) {
                    x = nums.get(i);
                    y = nums.get(k);

                }
            }
        }   
        System.out.print(n + " = " + x + " + " + y);
    }

    public void BigInts(int a, int b) {
        ArrayList<Integer> aList = new ArrayList();
        ArrayList<Integer> bList = new ArrayList();
        ArrayList<Integer> finalList = new ArrayList();
        int counta = 0;
        int countb = 0;
        int tempA = a;
        int tempB = b;
        while(tempA>0) {
            tempA/=10;
            counta++;
        }
        while(tempB>0) {
            tempB/=10;
            countb++;
        }
        for(int k = 0; k < counta; k++) {
            int temp = a %10;
            aList.add(0,temp);
            a/= 10;
        }
        for(int j = 0; j < countb; j++) {
            int temp = b %10;
            bList.add(0,temp);
            b/= 10;
        }   
        int size= 0;
        while (aList.size() > bList.size()) {
            bList.add(0,0);
        } 
        while(bList.size() >aList.size()) {
            aList.add(0,0);            
        }
        size = aList.size();
        for(int n = 0; n < size; n++) {
            finalList.add(0);
        }
        for(int i = size-1; i>=0; i--) {
            if(aList.get(i) + bList.get(i) + finalList.get(i) >= 10) {
                finalList.set(i, ((aList.get(i) + bList.get(i))%10) + finalList.get(i));
                finalList.set(i-1,finalList.get(i-1) + 1);
            }
            else finalList.set(i, aList.get(i) + bList.get(i) + finalList.get(i));
        }
        
        System.out.println(finalList);

    }

}
