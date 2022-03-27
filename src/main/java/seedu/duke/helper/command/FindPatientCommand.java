package seedu.duke.helper.command;

import seedu.duke.assets.List;
import seedu.duke.assets.PatientList;
import seedu.duke.exception.HalpmiException;
import seedu.duke.exception.NotFoundException;
import seedu.duke.status.Status;

public class FindPatientCommand extends Command {

    public FindPatientCommand(String[] parameterArray) {
        super(parameterArray);
    }

    public Status execute(List patientList) throws HalpmiException, NotFoundException {
        if (patientList instanceof PatientList) {
            PatientList downcastedPatientList = (PatientList) patientList;
            switch (parameterArray[0]) {
            case "nric":
                downcastedPatientList.findByNric(parameterArray);
                break;
            case "name":
                downcastedPatientList.findByName(parameterArray);
                break;
            case "age":
                downcastedPatientList.findByAge(parameterArray);
                break;
            case "gender":
                downcastedPatientList.findByGender(parameterArray);
                break;
            case "address":
                downcastedPatientList.findByAddress(parameterArray);
                break;
            case "dob":
                downcastedPatientList.findByDob(parameterArray);
                break;
            case "admissiondate":
                downcastedPatientList.findByDateAdmission(parameterArray);
                break;
            default:
                throw new HalpmiException("Input must be an attribute of Doctor");
            }
            return Status.FIND_PATIENT_SUCCESS;
        }
        throw new NotFoundException("Error in code, approach developer!");
    }
}
