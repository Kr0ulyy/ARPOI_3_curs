package lvl4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberStorage {

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> numbers;

    public NumberStorage() {
        this.numbers = new ArrayList<>();
    }

    public void CheckIfExist(int target) throws ValueExistException{
        for (int num : numbers){

        }
    }

    public void addNumber(int number) {
        numbers.add(number);
    }

    public void removeNumber(int number) throws ValueExistException{
        if (numbers.contains(number)){
            numbers.remove(Integer.valueOf(number));
        }
        else throw new ValueExistException("Такого значения нет");
    }

    public Integer findClosestNumber(int target) throws ValueExistException {
        if (numbers.isEmpty()) {
            throw new ValueExistException("Список пуст");
        }

        int closest = numbers.get(0);
        int minDifference = Math.abs(target - closest);

        for (int num : numbers) {
            int difference = Math.abs(target - num);
            if (difference < minDifference) {
                minDifference = difference;
                closest = num;
            }
        }

        return closest;
    }

    public int getSize() {
        return numbers.size();
    }
}
