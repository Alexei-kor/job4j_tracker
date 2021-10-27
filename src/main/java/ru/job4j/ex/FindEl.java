package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Искомый элемент не найден в массиве");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            int found = FindEl.indexOf(new String[]{"раз", "два", "три"}, "четыре");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
