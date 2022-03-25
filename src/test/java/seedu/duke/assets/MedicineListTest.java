package seedu.duke.assets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MedicineListTest {
    @Test
    void checkSize_arrayOfMedicines_expectedNumber() {
        MedicineList medicineList = new MedicineList();
        int currentNumber = 0;
        assertEquals(currentNumber, medicineList.getSize());
    }

    @Test
    void demoTestMethod() {
        assertTrue(true);
    }

    @Test
    void getmedicine_medicineInput_returnedmedicine() {
        MedicineList medicineList = new MedicineList();
        Medicine newMedicine = new Medicine("1", "Paracetamol", 50, "2022-10-12", "Headaches", 10);
        String expectedMedicine = "1: Paracetamol, 50, 2022-10-12, Headaches, 10";
        assertEquals(expectedMedicine, medicineList.getMedicineInfo(newMedicine));
    }
}
