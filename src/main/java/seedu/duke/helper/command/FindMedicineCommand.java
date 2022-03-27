package seedu.duke.helper.command;

import seedu.duke.assets.List;
import seedu.duke.assets.MedicineList;
import seedu.duke.exception.HalpmiException;
import seedu.duke.exception.NotFoundException;
import seedu.duke.status.Status;

public class FindMedicineCommand extends Command {

    public FindMedicineCommand(String[] parameterArray) {
        super(parameterArray);
    }

    public Status execute(List medicineList) throws HalpmiException, NotFoundException {
        if (medicineList instanceof MedicineList) {
            MedicineList downcastedMedicineList = (MedicineList) medicineList;
            switch (parameterArray[0]) {
            case "id":
                downcastedMedicineList.findById(parameterArray);
                break;
            case "name":
                downcastedMedicineList.findByName(parameterArray);
                break;
            case "dosage":
                downcastedMedicineList.findByDosage(parameterArray);
                break;
            case "expiry":
                downcastedMedicineList.findByExpiry(parameterArray);
                break;
            case "sideeffects":
                downcastedMedicineList.findBySideEffects(parameterArray);
                break;
            case "quantity":
                downcastedMedicineList.findByQuantity(parameterArray);
                break;
            default:
                throw new HalpmiException("Input must be an attribute of Medicine");
            }
            return Status.FIND_MEDICINE_SUCCESS;
        }
        throw new NotFoundException("Error in code, approach developer!");
    }
}
