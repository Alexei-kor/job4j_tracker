package ru.job4j.collection;

import java.util.Comparator;

/**
 * Класс для реализации интерефейса {@link Comparator}
 * @author Alexei
 * @version 1.1
 */
public class LexSort implements Comparator<String> {

    /**
     * в методе переопределено сравнение строк, содержащих вначале строки 'N. описание задачи'.
     * При этом в поле N указан номер задачи в списке.
     * Сравнение выполняется по номеру задачи из списка
     * @param left первая сравниваемая строка
     * @param right вторая сравниваемая строка
     * @return результат сравнения по аналогии с обычным {@code compare}
     */
    @Override
    public int compare(String left, String right) {
        String[] arrL = left.split("\\.");
        String[] arrR = right.split("\\.");
        return Integer.compare(Integer.parseInt(arrL[0]), Integer.parseInt(arrR[0]));
    }
}
