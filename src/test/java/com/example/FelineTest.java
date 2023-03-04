package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {
    Feline feline;

    @Before
    public void setup() {
        feline = new Feline();
    }

    @Test
    public void checkEatMeatReturnCorrectValue() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkGetFamilyReturnCorrectValue() {
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkGetKittensWOParamReturnCorrectValue() {
        int expectedResult = 1;
        int actualResult = feline.getKittens();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkGetKittensWithParamReturnCorrectValue() {
        int expectedResult = 1;
        int actualResult = feline.getKittens(1);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
