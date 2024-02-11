package fireDrillThree;

import java.util.Scanner;
public class FireDrillThree {
    Scanner input = new Scanner(System.in);

    public void TaskOne() {
        int[] newArray = new int[10];
        for (int index = 0; index <= 10; index++) {
            System.out.println("Enter your scores: ");
            int scores = input.nextInt();
            newArray[index] = scores;
        }
    }

    public void TaskTwo(int[] elements) {
        for (int element : elements) {
            System.out.println(element);
        }
    }

    public void TaskThree(int[] elements) {
        for (int element : elements) {
            System.out.print(element + " ");
        }
    }

    public int[] TaskFour(int[] elements) {
        int[] newArray = new int[elements.length];
        for (int index = 0; index <= elements.length; index++)
            if (index % 2 == 0) {
                newArray[index] = elements[index];
            }

        return newArray;
    }


    public int[] TaskFive(int[] elements) {
        int[] newArray = new int[elements.length];
        for (int index = 1; index <= elements.length + 1; index++)
            if (index % 2 != 0) {
                newArray[index] = elements[index];
            }

        return newArray;
    }

    public int TaskSix(int[] newArray) {
        int sum = 0;
        for (int index = 0; index <= newArray.length; index++) {
            sum += newArray[index];
        }
        return sum;
    }

    public int TaskSeven(int[] newArray) {
        int sum = 0;
        for (int index = 0; index <= newArray.length; index++) {
            sum += newArray[index];
        }
        return sum;
    }

    public int TaskEight(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
        for (index = 0; index <= elements.length; index++)
            if (index % 2 == 0) {
                newArray[index] = elements[index];
            }
        int minimum = newArray[0];
        for (int element : newArray) {
            if (newArray[1] < minimum)
                minimum = newArray[element];
        }
        return minimum;
    }

    public int TaskNine(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
        for ( index = 1; index <= elements.length + 1; index++)
            if (index % 2 != 0) {
                newArray[index] = elements[index];
            }

        int minimum = newArray[0];
        for (int element : newArray) {
            if (newArray[1] < minimum)
                minimum = newArray[element];
        }
        return minimum;
    }

    public int TaskTen(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
        for (index = 0; index <= elements.length; index++)
            if (index % 2 == 0) {
                newArray[index] = elements[index];
            }
        int maximum = newArray[0];
        for (int element : newArray) {
            if (newArray[1] > maximum)
                maximum = newArray[element];
        }
        return maximum;
    }


    public int TaskEleven(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
        for ( index = 1; index <= elements.length + 1; index++)
            if (index % 2 != 0) {
                newArray[index] = elements[index];
            }
        int maximum = newArray[0];
        for (int element : newArray) {
            if (newArray[1] > maximum)
                maximum = newArray[element];
        }
        return maximum;
    }


    public int[] TaskTwelve(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
      for(index = 0; index < elements.length; index++) {
          for (int element : elements) {
              if (index % 2 == 0)
                  elements[index] = elements[index + 1];
              if (index % 2 != 0)
                  elements[index+1] = elements[index];

          }
          newArray[index] = elements[index];
          newArray[index+1] = elements[index+1];
      }
        return newArray;
    }


    public int[] TaskThirteen(int[] elements) {
        int index;
        int[] newArray = new int[elements.length];
        for(index = 0; index < elements.length; index++) {
            for (int element : elements) {
                if (element % 2 != 0)
                    elements[index] = elements[index + 1];
                if (index % 2 != 0)
                    elements[index+1] = elements[index];

            }
            newArray[index] = elements[index];
            newArray[index+1] = elements[index+1];
        }
        return newArray;
    }


}

