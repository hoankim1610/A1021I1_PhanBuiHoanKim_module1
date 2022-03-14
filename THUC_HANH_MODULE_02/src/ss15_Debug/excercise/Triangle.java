package ss15_Debug.excercise;

public class Triangle {
    public Triangle(int side1, int side2, int side3) throws IllegalTriangleException {
        if(side1+side2<side3 || side1+side3<side2 || side2+side3<side1)
            throw new IllegalTriangleException("Not a triangle");
        else{

            throw new IllegalTriangleException("Is a right triangle ");

        }
    }
}

class IllegalTriangleException extends Exception {
    String errorMessage;
    public IllegalTriangleException(String inErrorMessage) {
        errorMessage = inErrorMessage;
    }

    public String getString(){
        return errorMessage;
    }
}


class Main {

    public static void main(String[] args) {

        String string = new String();

        String[] s = string.split(" ");
        int side[] = new int[s.length];
        int checkInt = 0;
        String errString = new String();
        if(s.length != 3)
            System.out.println("Please input 03 arguments");
        else {
            for(int i=0; i<s.length;i++) {
                try{
                    side[i] = Integer.parseInt(s[i]);
                } catch (NumberFormatException ex){
                    checkInt ++;
                    errString = errString + s[i] + " ";
                }
            }
        }
        if(checkInt == 1)
            System.out.println("Wrong input " + errString + " (not a number)");

        else {
            int tmp;
            for (int i=0 ; i<s.length ;i++) {
                for (int j=0;j<s.length-1;j++) {
                    if(side[i] < side[j]) {
                        tmp = side[i];
                        side[i] = side[j];
                        side[j] = tmp;
                    }
                }
            }
            for(int i=0;i<3;i++)
                System.out.print(side[i] + " ");
        }
        try {
            Triangle r = new Triangle(side[0], side[1], side[2]);
        } catch(IllegalTriangleException e) {
            System.out.println(e);
        }
    }
}
