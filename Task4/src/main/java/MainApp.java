import java.io.IOException;

public class MainApp {
    public static void main(String[] args) {

        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };

        String[][] array2 = {
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"}
        };

        try{
            System.out.printf("Сумма эллементов равна %d\n", sumStringArray(array1, 4));
            System.out.printf("Сумма эллементов равна %d\n", sumStringArray(array1, 5));
            System.out.printf("Сумма эллементов равна %d\n", sumStringArray(array2, 5));
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }


    }

    public static int sumStringArray(String [][] array, int checkSize) throws MyArraySizeException {
        if (array.length != checkSize) {
            throw new MyArraySizeException("Длинна не равна " + checkSize);
        } else {
            for (int i = 0; i < array.length; i++) {
                if (array[i].length != checkSize){
                    throw new MyArraySizeException("Длинна не равна " + checkSize);
                }
            }
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(String.format("Ксяк в %d %d", i, j));
                }
            }
        }
        return sum;
    }
}
