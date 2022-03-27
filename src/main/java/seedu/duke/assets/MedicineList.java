package seedu.duke.assets;


import seedu.duke.exception.DuplicateEntryException;
import seedu.duke.exception.NotFoundException;
import seedu.duke.helper.UI;
import seedu.duke.helper.command.CommandLineTable;
import seedu.duke.helper.finder.MedicineFinder;

import java.time.LocalDate;
import java.util.ArrayList;

public class MedicineList extends List {

    private ArrayList<Medicine> medicines = new ArrayList<>();
    private ArrayList<Medicine> expiredMedicines = new ArrayList<>();
    private ArrayList<Medicine> returnedFinderArray = new ArrayList<>();

    public int getSize() {
        return medicines.size();
    }

    public Medicine getMedicine(String medicineId) {
        for (Medicine medicine : medicines) {
            if (medicine.getMedicineId().equals(medicineId)) {
                return medicine;
            }
        }
        return null;
    }

    public Medicine search(String medicineId) {
        for (Medicine medicine : medicines) {
            if (medicine.getMedicineId().equals(medicineId)) {
                return medicine;
            }
        }
        return null;
    }

    public void add(String[] parameterArray) throws DuplicateEntryException {
        if (search(parameterArray[0]) != null) {
            throw new DuplicateEntryException("Medicine with given Batch ID already exists!");
        }
        Medicine newMedicine = new Medicine(parameterArray[0], parameterArray[1],
                Integer.parseInt(parameterArray[2]), parameterArray[3], parameterArray[4],
                Integer.parseInt(parameterArray[5]));
        medicines.add(newMedicine);
    }

    public void find(String[] command) {
    }

    public String getMedicineInfo(Medicine medicine) {
        return (medicine.getMedicineId() + ": "
                + medicine.getMedicineName() + ", "
                + Integer.toString(medicine.getDosage()) + ", " + medicine.getExpiry() + ", "
                + medicine.getSideEffects() + ", " + Integer.toString(medicine.getQuantity()));
    }


    //view particular medicine
    public void view(String medicineId) {
        Medicine medicine = getMedicine(medicineId);
        if (medicine == null) {
            UI.printParagraph("Medicine doesn't exist please try again!");
            return;
        }
        CommandLineTable medicineTable = new CommandLineTable();
        medicineTable.setShowVerticalLines(true);
        medicineTable.setHeaders("MedicineId", "MedicineName", "Dosage", "Expiry", "SideEffects", "Quantity");
        medicineTable.addRow(medicine.getMedicineId(), medicine.getMedicineName(),
                String.valueOf(medicine.getDosage()),
                medicine.getExpiry(), medicine.getSideEffects(), String.valueOf(medicine.getQuantity()));
        medicineTable.print();
    }

    public void view() {
        CommandLineTable medicineTable = new CommandLineTable();
        //st.setRightAlign(true);//if true then cell text is right aligned
        medicineTable.setShowVerticalLines(true);
        medicineTable.setHeaders("MedicineId", "MedicineName", "Dosage", "Expiry", "SideEffects", "Quantity");

        for (Medicine medicine : medicines) {
            medicineTable.addRow(medicine.getMedicineId(), medicine.getMedicineName(),
                    String.valueOf(medicine.getDosage()),
                    medicine.getExpiry(), medicine.getSideEffects(),
                    String.valueOf(medicine.getQuantity()));
        }
        medicineTable.print();
    }


    public void remove(String medicineId) throws NotFoundException {
        for (int i = 0; i < getSize(); i++) {
            if (medicines.get(i).getMedicineId().equals(medicineId)) {
                medicines.remove(i);
                return;
            }
        }
        throw new NotFoundException("There are no medicines with given Batch ID!");
    }

    public void edit(String[] parameterArray) throws NotFoundException {
        if (search(parameterArray[0]) != null) {
            Medicine medicine = search(parameterArray[0]);
            medicine.edit(parameterArray[1], Integer.parseInt(parameterArray[2]), parameterArray[3], parameterArray[4],
                    Integer.parseInt(parameterArray[5]));
            return;
        }
        throw new NotFoundException("There are no medicines with given Batch ID!");
    }

    public void viewExpired() {
        CommandLineTable medicineTable = new CommandLineTable();
        //st.setRightAlign(true);//if true then cell text is right aligned
        medicineTable.setShowVerticalLines(true);
        medicineTable.setHeaders("MedicineId", "MedicineName", "Dosage", "Expiry", "SideEffects", "Quantity");

        for (Medicine medicine : expiredMedicines) {
            medicineTable.addRow(medicine.getMedicineId(), medicine.getMedicineName(),
                    String.valueOf(medicine.getDosage()),
                    medicine.getExpiry(), medicine.getSideEffects(),
                    String.valueOf(medicine.getQuantity()));
        }
        medicineTable.print();
    }

    public void updateStock() {
        for (int i = 0; i < medicines.size(); i++) {
            LocalDate date = LocalDate.parse(medicines.get(i).getExpiry());
            LocalDate today = LocalDate.now();
            if (date.isBefore(today)) {
                expiredMedicines.add(medicines.get(i));
                medicines.remove(i);
            }
        }
        viewExpired();
    }

    public void clearStock() {
        if (expiredMedicines.size() == 0) {
            UI.printParagraph("There are no expired medicines in the expired list!");
            return;
        }
        expiredMedicines.clear();
        UI.printParagraph("Expired medicines in the expired list has been cleared!");
    }

    public ArrayList<Medicine> getList() {
        return medicines;
    }

    public void findById(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineById(medicines, parameters[1]);
    }

    public void findByDosage(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineByDosage(medicines, Integer.parseInt(parameters[1]));
    }

    public void findByExpiry(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineByExpiry(medicines, parameters[1]);
    }

    public void findBySideEffects(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineBySideEffects(medicines, parameters[1]);
    }

    public void findByQuantity(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineByQuantity(medicines, Integer.parseInt(parameters[1]));
    }

    public void findByName(String[] parameters) {
        this.returnedFinderArray = MedicineFinder.findMedicineByName(medicines, parameters[1]);
    }

}


