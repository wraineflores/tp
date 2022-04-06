package seedu.duke.helper;

import seedu.duke.assets.DoctorList;
import seedu.duke.assets.MedicineList;
import seedu.duke.assets.Patient;
import seedu.duke.assets.PatientList;
import seedu.duke.status.Status;

import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private String userInput;
    private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner reader = new Scanner(System.in);
    private Parser parser = new Parser();

    private void readInput() {
        this.userInput = reader.nextLine();
    }

    public String readCommand() {
        readInput();
        return parser.commandParser(userInput)[0].trim();
    }


    public String readParameters() {
        String[] userInputArray = parser.commandParser(userInput);
        if (userInputArray.length == 1) {
            return null;
        }
        return parser.commandParser(userInput)[1].trim();
    }

    public static void printNewLineSeparator() {
        System.out.println("--------------------------------------------------");
    }

    public void printGreeting() {
        printNewLineSeparator();
        printParagraph("Welcome! This is the Hospital Management System.\n"
                + "Please type in your input");
    }

    public void printLogo() {
        String logo = "------------------------------\n"
                + "HALPMI";

        System.out.println(logo);
    }

    public static void printHelp() {
        printAddDoctorMessage();
        printAddPatientMessage();
        printAddMedicineMessage();
        printAddAppointmentMessage();
        printViewDoctorMessage();
        printViewPatientMessage();
        printViewMedicineMessage();
        printViewAppointmentMessage();
        printDeleteDoctorMessage();
        printDeletePatientMessage();
        printDeleteMedicineMessage();
        printDeleteAppointmentMessage();
        printEditDoctorMessage();
        printEditPatientMessage();
        printEditMedicineMessage();
        printEditAppointmentMessage();
        printFindDoctorMessage();
        printFindPatientMessage();
        printFindMedicineMessage();
        printUpdateMedicineMessage();
        printClearMedicineMessage();
        printByeMessage();
    }

    public static void printAddDoctorMessage() {
        printNewLineSeparator();
        printParagraph("Feature: ADD DOCTOR\n"
                + "Format: add doctor /info [nric],[name],[age],[gender],[address],[DOB],[Specialisation]\n"
                + "Example: add doctor /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, Urinology");
    }

    public static void printAddPatientMessage() {
        printNewLineSeparator();
        printParagraph("Feature: ADD PATIENT\n"
                + "Format: add patient /info [nric],[name],[age],[gender],[address],[DOB],[DOA]\n"
                + "Example: add patient /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, 2021-02-15");
    }

    public static void printAddMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Feature: ADD MEDICINE\n"
                + "Format: add medicine /info [batch id],[name],[dosage],[expiry date],[side effects],[quantity]\n"
                + "Example: add medicine /info A123,Paracetamol, 500, 2023-06-11, Slight headache, 10");
    }

    public static void printAddAppointmentMessage() {
        printNewLineSeparator();
        printParagraph("Feature: ADD APPOINTMENT\n"
                + "Format: add appointment /info [appointment id],[patient nric],[patient name],[doctor nric],"
                + "[doctor name],[appointment date],[appointment details]\n"
                + "Example: add appointment /info A123,S1234567A,Don,S7654321A,John,2022-10-15,Regular knee checkup");
    }

    public static void printViewDoctorMessage() {
        printNewLineSeparator();
        printParagraph("Feature: VIEW DOCTOR\n"
                + "Format: view doctor\n"
                + "Example: view doctor");
    }

    public static void printViewPatientMessage() {
        printNewLineSeparator();
        printParagraph("Feature: VIEW PATIENT\n"
                + "Format: view patient\n"
                + "Example: view patient");
    }

    public static void printViewMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Feature: VIEW MEDICINE\n"
                + "Format: view medicine\n"
                + "Example: view medicine");
    }

    public static void printViewAppointmentMessage() {
        printNewLineSeparator();
        printParagraph("Feature: VIEW APPOINTMENT\n"
                + "Format: view appointment or view appointment /info [criteria],[input value]\n"
                + "Accepted Criteria: appointment id, patient nric, patient name, doctor name, doctor nric, date\n"
                + "Example 1: view appointment /info appointment id, A123\n"
                + "Example 2: view appointment /info patient nric, S1234567A\n"
                + "Example 3: view appointment /info doctor name, John\n"
                + "Example 4: view appointment /info patient date, 2023-01-01\n");
    }

    public static void printDeleteDoctorMessage() {
        printNewLineSeparator();
        printParagraph("Feature: DELETE DOCTOR\n"
                + "Format: delete doctor /info [nric]\n"
                + "Example: delete doctor /info S1234567A");
    }

    public static void printDeletePatientMessage() {
        printNewLineSeparator();
        printParagraph("Feature: DELETE PATIENT\n"
                + "Format: delete patient /info [nric]\n"
                + "Example: delete patient /info S1234567A");
    }

    public static void printDeleteMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Feature: DELETE MEDICINE\n"
                + "Format: delete medicine /info [batch id]\n"
                + "Example: delete medicine /info S234");
    }

    public static void printDeleteAppointmentMessage() {
        printNewLineSeparator();
        printParagraph("Feature: DELETE APPOINTMENT\n"
                + "Format: delete appointment /info [appointment id]\n"
                + "Example: delete appointment /info S234");
    }

    public static void printEditDoctorMessage() {
        printNewLineSeparator();
        printParagraph("Feature: EDIT DOCTOR\n"
                + "Format: edit doctor /info [nric],[name],[age],[gender],[address],[DOB],[Specialisation]\n"
                + "Example: edit doctor /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, Urinology");
    }

    public static void printEditPatientMessage() {
        printNewLineSeparator();
        printParagraph("Feature: EDIT PATIENT\n"
                + "Format: edit patient /info [nric],[name],[age],[gender],[address],[DOB],[DOA]\n"
                + "Example: edit patient /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, 2021-02-15");
    }

    public static void printEditMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Feature: EDIT MEDICINE\n"
                + "Format: edit medicine /info [batch id],[name],[dosage],[expiry date],[side effects],[quantity]\n"
                + "Example: edit medicine /info A123,Paracetamol, 500, 2023-06-11, Slight headache, 10");
    }

    public static void printEditAppointmentMessage() {
        printNewLineSeparator();
        printParagraph("Feature: EDIT APPOINTMENT\n"
                + "Format: edit appointment /info [appointment id], [patient nric], [patient name],"
                + "[doctor nric], [doctor name], [appointment date], [appointment details]\n"
                + "Example: edit appointment /info A123,S1234567A,Don,S7654321A,John,2022-10-15,Regular knee checkup");
    }

    public static void printFindDoctorMessage() {
        printNewLineSeparator();
        printParagraph("Feature: FIND DOCTOR\n"
                + "Format: find doctor /info [parameter], [keyword to find]\n"
                + "Example 1: find doctor /info name, Bruce Lee\n"
                + "Example 2: find doctor /info nric, S1234567X\n"
                + "Example 3: find doctor /info age, 23\n"
                + "Example 4: find doctor /info gender, M\n"
                + "Example 5: find doctor /info address, 15 King's Avenue\n"
                + "Example 6: find doctor /info dob, 1999-12-31\n"
                + "Example 7: find doctor /info specialization, Dermatology\n");
    }

    public static void printFindPatientMessage() {
        printNewLineSeparator();
        printParagraph("Feature: FIND PATIENT\n"
                + "Format: find patient /info [parameter], [keyword to find]\n"
                + "Example 1: find patient /info name, Bruce Lee\n"
                + "Example 2: find patient /info nric, S1234567X\n"
                + "Example 3: find patient /info age, 23\n"
                + "Example 4: find patient /info gender, M\n"
                + "Example 5: find patient /info address, 15 King's Avenue\n"
                + "Example 6: find patient /info dob, 1999-12-31\n"
                + "Example 7: find patient /info admissiondate, 2021-02-15\n");
    }

    public static void printFindMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Feature: FIND DOCTOR\n"
                + "Format: find medicine /info [parameter], [keyword to find]\n"
                + "Example 1: find medicine /info id, S123\n"
                + "Example 2: find medicine /info name, Paracetamol\n"
                + "Example 3: find medicine /info dosage, 500\n"
                + "Example 4: find medicine /info expiry, 2023-06-11\n"
                + "Example 5: find medicine /info sideeffects, headache\n"
                + "Example 6: find medicine /info quantity, 10\n");
    }

    public static void printUpdateMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Additional feature: UPDATE MEDICINE\n"
                + "Format: update medicines\n"
                + "Example: update medicines");
    }

    public static void printClearMedicineMessage() {
        printNewLineSeparator();
        printParagraph("Additional feature: CLEAR MEDICINE\n"
                + "Format: clear medicines\n"
                + "Example: clear medicines");
    }

    public static void printByeMessage() {
        printNewLineSeparator();
        printParagraph("Feature: BYE (to exit the programme)\n"
                + "Format: bye\n"
                + "Example: bye");
    }

    public int getSize() {
        return patients.size();
    }

    public void printWrongInput() {
        printNewLineSeparator();
        printParagraph("Sorry. Input was invalid.");
        printHelp();
    }

    public void printBye() {
        printNewLineSeparator();
        printParagraph("Goodbye! Exiting the programme.");
    }

    public void printAddPatientExampleMessage() {
        printParagraph("Please note the error(s) mentioned above and try again!\n"
                + "Here are two examples. Please follow the input order:\n"
                + "add patient /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, 2021-02-15\n"
                + "add patient /info T4867591Z, Mary Douglas Owen, 25, F, 15 King's Avenue, 1997-08-26, 2020-03-30");
    }

    public void printAddDoctorExampleMessage() {
        printParagraph("Please note the error(s) mentioned above and try again!\n"
                + "Here are two examples. Please follow the input order:\n"
                + "add doctor /info S1234567A, John Doe, 23, M, 10 Baker Street, 1999-12-31, Urinology\n"
                + "add doctor /info T4867591Z, Mary Douglas Owen, 25, F, 15 King's Avenue, 1997-08-26, Optometry");
    }

    public void printDeletePatientExampleMessage(PatientList patientList) {
        printParagraph("Please input a positive number up to " + patientList.getSize() + " only.\n"
                + "Here is an example:\ndelete patient /info 1");
    }

    public void printDeleteDoctorErrorMessage(DoctorList doctorList) {
        printParagraph("Please input a positive number up to " + doctorList.getSize() + " only.\n"
                + "Here is an example:\ndelete doctor /info 1");
    }

    public void printAddAppointmentExampleMessage() {
        printParagraph("Please note the error(s) mentioned above and try again!\n"
                + "Here is an example. Please follow the input order:\n"
                + "add appointment /info S1234567A, Thomas, S1234567A, Ben, 2023-01-01, Knee checkup");
    }

    public void printNullParametersMessage() {
        UI.printParagraph("Parameters missing or not detected. Please use /info for parameters.");
    }

    public void printAddMedicineExampleMessage() {
        printParagraph("Invalid format. Please follow the below example and try again.\n"
                + "add medicine /info s231, Paracetamol,500,2023-12-12,Headaches,10");
    }

    public void printEditMedicineExampleMessage() {
        printParagraph("Invalid format. Please follow the below example and try again.\n"
                + "edit medicine /info s231, Paracetamol,500,2023-12-12,Headaches,10");
    }

    public static void printPrompt() {
        System.out.print("You: ");
    }

    public static void printParagraph(String paragraph) {
        String[] arrayOfSentences = paragraph.split("\n");
        System.out.println("HalpMi: " + arrayOfSentences[0]);
        for (int i = 1; i < arrayOfSentences.length; i++) {
            System.out.print("        ");
            System.out.println(arrayOfSentences[i]);
        }
    }

    public static void printCont(String sentence) {
        System.out.print("        ");
        System.out.println(sentence);
    }

    public void printDeleteMedicineExampleMessage(MedicineList medicineList) {
        printParagraph("Please input a positive number up to " + medicineList.getSize() + " only.\n"
                + "Here is an example:\ndelete patient /info 1");
    }

    public void print(Status status) {
        switch (status) {
        case ADD_PATIENT_SUCCESS:
            printParagraph("Patient has been added successfully!");
            break;
        case ADD_DOCTOR_SUCCESS:
            printParagraph("Doctor has been added successfully!");
            break;
        case ADD_MEDICINE_SUCCESS:
            printParagraph("Medicine has been added successfully!");
            break;
        case ADD_APPOINTMENT_SUCCESS:
            printParagraph("Appointment has been added successfully!");
            break;
        case DELETE_PATIENT_SUCCESS:
            printParagraph("Patient has been deleted successfully!");
            break;
        case DELETE_DOCTOR_SUCCESS:
            printParagraph("Doctor has been deleted successfully!");
            break;
        case DELETE_MEDICINE_SUCCESS:
            printParagraph("Medicine has been deleted successfully!");
            break;
        case DELETE_APPOINTMENT_SUCCESS:
            printParagraph("Appointment has been deleted successfully!");
            break;
        case EDIT_DOCTOR_SUCCESS:
            printParagraph("Doctor has been edited successfully!");
            break;
        case EDIT_PATIENT_SUCCESS:
            printParagraph("Patient has been edited successfully!");
            break;
        case EDIT_MEDICINE_SUCCESS:
            printParagraph("Medicine has been edited successfully!");
            break;
        case EDIT_APPOINTMENT_SUCCESS:
            printParagraph("Appointment has been edited successfully!");
            break;
        case PRINT_HELP:
            UI.printHelp();
            break;
        default:
            break;
        }
    }
}
