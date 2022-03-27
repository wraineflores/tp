package seedu.duke.helper.command;

import seedu.duke.assets.DoctorList;
import seedu.duke.assets.List;
import seedu.duke.exception.HalpmiException;
import seedu.duke.status.Status;

public class FindDoctorCommand extends Command {

    public FindDoctorCommand(String[] parameterArray) {
        super(parameterArray);
    }

    public Status execute(List doctorList) throws HalpmiException {
        if (doctorList instanceof DoctorList) {
            DoctorList downcastedDoctorList = (DoctorList) doctorList;
            switch (parameterArray[0]) {
            case "nric":
                downcastedDoctorList.findByNric(parameterArray);
                break;
            case "name":
                downcastedDoctorList.findByName(parameterArray);
                break;
            case "age":
                downcastedDoctorList.findByAge(parameterArray);
                break;
            case "gender":
                downcastedDoctorList.findByGender(parameterArray);
                break;
            case "address":
                downcastedDoctorList.findByAddress(parameterArray);
                break;
            case "dob":
                downcastedDoctorList.findByDob(parameterArray);
                break;
            case "specialization":
                downcastedDoctorList.findBySpecialization(parameterArray);
                break;
            default:
                break;
            }
            return Status.FIND_DOCTOR_SUCCESS;
        }
        throw new HalpmiException("Error in code, approach developer!");
    }
}
