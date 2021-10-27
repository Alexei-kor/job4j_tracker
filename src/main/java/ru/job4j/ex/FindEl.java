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
        process(new String[]{"Раз", "Два", "Три"}, "Два", new String[]{"Плохое слово"});
    }

    public static boolean sent(String value, String[] abuses) throws ElementNotFoundException {
        if (FindEl.indexOf(abuses, value) != -1) {
            throw new ElementAbuseException("Используются запрещенные слова");
        } else {
            return true;
        }
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
