package seedu.duke.assets;

import seedu.duke.exception.DuplicateEntryException;
import seedu.duke.exception.NotFoundException;
import seedu.duke.helper.UI;
import seedu.duke.helper.command.CommandLineTable;
import seedu.duke.helper.finder.PatientFinder;

import java.util.ArrayList;


public class PatientList extends List {

    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Patient> returnedFinderArray = new ArrayList<>();

    public Patient getPatient(String nric) {
        for (Patient patient : patients) {
            if (patient.getNric().equals(nric)) {
                return patient;
            }
        }
        return null;
    }

    public void find(String[] command) {
    }


    public Patient search(String nric) {
        for (Patient patient : patients) {
            if (patient.getPatientNric().equals(nric)) {
                return patient;
            }
        }
        return null;
    }

    public void add(String[] addPatientParameters) throws DuplicateEntryException {
        int numberOfPatientsBefore = patients.size();
        if (getPatient(addPatientParameters[0]) != null) {
            throw new DuplicateEntryException("Patient with given NRIC already exists!");
        }
        Patient newPatient = new Patient(addPatientParameters[0], addPatientParameters[1],
                Integer.parseInt(addPatientParameters[2]),
                addPatientParameters[3].charAt(0), addPatientParameters[4], addPatientParameters[5],
                addPatientParameters[6]);
        patients.add(newPatient);
        assert patients.size() == numberOfPatientsBefore + 1;
    }

    public String getPatientInfo(Patient patient) {
        return (patient.getPatientNric() + ": "
                + patient.getPatientName() + ", "
                + Integer.toString(patient.getPatientAge()) + ", " + patient.getPatientAddress()
                + ", " + patient.getPatientGender() + ", " + patient.getPatientDob()
                + ", " + patient.getDateOfAdmission());
    }

    public int getSize() {
        return patients.size();
    }

    //view particular patient
    public void view(String nric) {
        Patient patient = getPatient(nric);
        if (patient == null) {
            UI.printParagraph("Patient doesn't exist please try again!");
            return;
        }
        CommandLineTable patientTable = new CommandLineTable();
        patientTable.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        patientTable.setHeaders("Nric", "FullName", "Age", "Address", "Gender", "Dob",
                "DateAdmission");
        patientTable.addRow(patient.getPatientNric(), patient.getPatientName(),
                String.valueOf(patient.getPatientAge()),
                patient.getPatientAddress(), String.valueOf(patient.getPatientGender()),
                patient.getPatientDob(),
                patient.getDateOfAdmission());
        patientTable.print();
    }


    //view all patients
    public void view() {
        CommandLineTable patientTable = new CommandLineTable();
        //st.setRightAlign(true);//if true then cell text is right aligned
        patientTable.setShowVerticalLines(true);//if false (default) then no vertical lines are shown
        patientTable.setHeaders("Nric", "FullName", "Age", "Address", "Gender", "Dob",
                "DateAdmission");
        for (Patient patient : patients) {
            patientTable.addRow(patient.getPatientNric(), patient.getPatientName(),
                    String.valueOf(patient.getPatientAge()),
                    patient.getPatientAddress(), String.valueOf(patient.getPatientGender()),
                    patient.getPatientDob(),
                    patient.getDateOfAdmission());
        }
        patientTable.print();
    }

    public void remove(String nric) throws NotFoundException {
        int numberOfPatientsBefore = patients.size();
        for (int i = 0; i < getSize(); i++) {
            if (patients.get(i).getNric().equals(nric)) {
                patients.remove(i);
                assert patients.size() == numberOfPatientsBefore - 1;
                return;
            }
        }
        throw new NotFoundException("There are no patients with given NRIC!");
    }

    public void edit(String[] parameterArray) throws NotFoundException {
        if (search(parameterArray[0]) != null) {
            Patient patient = search(parameterArray[0]);
            patient.edit(parameterArray[1], Integer.parseInt(parameterArray[2]), parameterArray[3],
                    (parameterArray[4].charAt(0)), parameterArray[5], parameterArray[6]);
            return;
        }
        throw new NotFoundException("There are no patients with given NRIC!");
    }

    public ArrayList<Patient> getList() {
        return patients;
    }

    @Override
    public String toString() {
        if (getSize() == 0) {
            return "There are no patients currently.";
        }
        String output = "";
        int number = 1;
        for (Patient patient : this.patients) {
            output += String.format("%d. %s", number, patient.toString());
            if (number != this.getSize()) {
                output += "\n";
            }
            number++;
        }
        assert !output.isEmpty();
        return output;
    }

    public void findByNric(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByNric(patients, parameters[1]);
        createArrayOfFoundPatients();
    }

    public void findByName(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByName(patients, parameters[1]);
        createArrayOfFoundPatients();
    }

    public void findByAge(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByAge(patients, Integer.parseInt(parameters[1]));
        createArrayOfFoundPatients();
    }

    public void findByGender(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByGender(patients, parameters[1].charAt(0));
        createArrayOfFoundPatients();
    }

    public void findByAddress(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByAddress(patients, parameters[1]);
        createArrayOfFoundPatients();
    }

    public void findByDob(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByDob(patients, parameters[1]);
        createArrayOfFoundPatients();
    }

    public void findBySpecialization(String[] parameters) {
        // Intentionally left blank
    }

    public void findByDateAdmission(String[] parameters) {
        this.returnedFinderArray = PatientFinder.findPatientByDateAdmission(patients, parameters[1]);
        createArrayOfFoundPatients();
    }

    private void createArrayOfFoundPatients() {
        if (returnedFinderArray.isEmpty()) {
            UI.printParagraph("Patient doesn't exist please try again!");
        } else {
            ArrayList<String> stringArrayLists = new ArrayList<>();
            for (int i = 0; i < returnedFinderArray.size(); i++) {
                String outputString = "";
                outputString += String.valueOf(i) + ": ";
                outputString += returnedFinderArray.get(i).getNric() + "\n";
                outputString += returnedFinderArray.get(i).getFullName() + "\n";
                outputString += returnedFinderArray.get(i).getAge() + "\n";
                outputString += returnedFinderArray.get(i).getGender() + "\n";
                outputString += returnedFinderArray.get(i).getAddress() + "\n";
                outputString += returnedFinderArray.get(i).getDateAdmission() + "\n";
                stringArrayLists.add(outputString);
            }
            for (String stringArrayList : stringArrayLists) {
                UI.printParagraph(stringArrayList);
            }
        }
    }

}

