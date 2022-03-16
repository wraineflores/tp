package seedu.duke;

import seedu.duke.assets.DoctorList;
import seedu.duke.assets.MedicineList;
import seedu.duke.assets.PatientList;
import seedu.duke.helper.Command;
import seedu.duke.helper.UI;

/**
 * Manager class contains the main loop that runs until application is terminated.
 */
public class Manager {
    private UI ui = new UI();
    private Command command = new Command();
    private PatientList patientList = new PatientList();
    private MedicineList medicineList = new MedicineList();
    private DoctorList doctorList = new DoctorList();
    private boolean isTerminated = false;

    /**
     * Main application loop that holds switch case statement.
     */
    public void runLoop() {
        ui.printGreeting();
        while (!isTerminated) {
            ui.printPrompt();
            String commandWord = ui.readCommand();
            String parameters = ui.readParameters();
            switch (commandWord) {
            case "add patient":
                command.addPatient(patientList, parameters);
                break;
            case "delete patient":
                command.deletePatient(patientList, parameters);
                break;
            case "view patient":
                command.viewPatient(patientList, parameters);
                break;
            case "add doctor":
                command.addDoctor(doctorList, parameters);
                break;
            case "delete doctor":
                break;
            case "view doctor":
                break;
            case "add medicine":
                command.addMedicine(medicineList, parameters);
                break;
            case "delete medicine":
                command.deleteMedicine(medicineList, parameters);
                break;
            case "view medicine":
                command.viewMedicine(medicineList, parameters);
                break;
            case "help":
                ui.printHelp();
                break;
            case "bye":
                isTerminated = true;
                ui.printBye();
                break;
            default:
                System.out.println(commandWord);
                break;
            }
        }
    }
}
