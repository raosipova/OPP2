package ru.netology;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    //тесты на номер радиостанции

    @Test
    public void currentStation() { //получить номер текущей радиостанции
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        int expected = 5;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void atAcceptableValues() { //переключает непосредственно при допустимых значениях
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.getCurrentStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetAboveMax() { //переключает непосредственно при значениях больше 9
        Radio radio = new Radio();
        radio.setCurrentStation(10);

        radio.getCurrentStation();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetBelowMin() { //переключает непосредственно при значениях меньше 0
        Radio radio = new Radio();
        radio.setCurrentStation(-1);

        radio.getCurrentStation();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetNext() { //переключение на следующую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(3);

        radio.next();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetPrevious() { //переключение на предыдущую радиостанцию
        Radio radio = new Radio();
        radio.setCurrentStation(5);

        radio.prev();

        int expected = 4;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroIfAboveMax() { //переключает на минимальное при нажатии next при максимальном значении
        Radio radio = new Radio();
        radio.setCurrentStation(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNineIfBelowMin() { //переключает на максимальное при нажатии prev при минимальном значении
        Radio radio = new Radio();
        radio.setCurrentStation(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStation();

        Assertions.assertEquals(expected, actual);
    }

    //тесты на уровень громкости

    @Test
    public void currentVolumeLevel() { //получить текущий уровень громкости
        Radio radio = new Radio();
        radio.setCurrentVolume(30);

        int expected = 30;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnUpTheVolume() { //прибавить громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(25);

        radio.increaseVolume();

        int expected = 26;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void turnDownTheVolume() { //убавить громкость
        Radio radio = new Radio();
        radio.setCurrentVolume(26);

        radio.reduceVolume();

        int expected = 25;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetAboveMax() { //выставление громкости больше максимального значения
        Radio radio = new Radio();
        radio.setCurrentVolume(100);

        radio.increaseVolume();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetBelowMin() { //выставление громкости меньше минимального значения
        Radio radio = new Radio();
        radio.setCurrentVolume(0);

        radio.reduceVolume();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}


