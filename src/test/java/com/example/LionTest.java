package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.List;

@RunWith(Parameterized.class)
public class LionTest {
    Lion lion;
    Feline feline;
    String sex;
    public LionTest(String sex) {
        this.sex = sex;
    }
    @Parameterized.Parameters
    public static Object[][] getLionParameters() {
        return new Object[][]{
                {"Самец"},
                {"Самка"},
        };
    }
    @Before
    public void init() throws Exception {
        MockitoAnnotations.initMocks(this);
        setup();
    }
    public void setup() throws Exception {
        feline = Mockito.mock(Feline.class);
        lion = new Lion(sex, feline);
    }
    @Test
    public void checkGetKittensReturnsOne() {
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedValue = 1;
        int actualValue = lion.getKittens();
        Assert.assertEquals(expectedValue, actualValue);
    }
    @Test
    public void checkGetFoodReturnCorrectList() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();
        Assert.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void checkCreateLionDifferentSex() {
        switch (sex) {
            case ("Самец"):
                Assert.assertTrue(lion.hasMane);
                break;
            case ("Самка"):
                Assert.assertFalse(lion.hasMane);
                break;
        }
    }
    @Test
    public void checkDoesHaveManeReturnCorrectValue() {
        Boolean expectedValue = lion.hasMane;
        Boolean actualValue = lion.doesHaveMane();
        Assert.assertEquals(expectedValue, actualValue);
    }
    @Test(expected = Exception.class)
    public void checkThrowExceptionInConstructorLion() throws Exception {
            new Lion("xxx", feline);
    }
}

