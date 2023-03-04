package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class AnimalTest {
    Animal animal;
    String animalKind;
    List<String> listFood;

    public AnimalTest(String animalKind, List<String> listFood) {
        this.animalKind = animalKind;
        this.listFood = listFood;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalKindParam() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }

    @Before
    public void setup() {
        animal = new Animal();
    }

    @Test
    public void checkGetFoodByDifferentAnimalKind() throws Exception {
        List<String> expectedResult = listFood;
        List<String> actualResult = animal.getFood(animalKind);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test(expected = Exception.class)
    public void checkThrowExceptionInGetFood() throws Exception {
        animal.getFood("РыбаМоейМечты");
    }

    @Test
    public void checkGetFamilyReturnCorrectValue() {
        String expectedCorrectValue = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actualCorrectValue = animal.getFamily();
        Assert.assertEquals(expectedCorrectValue, actualCorrectValue);
    }
}
