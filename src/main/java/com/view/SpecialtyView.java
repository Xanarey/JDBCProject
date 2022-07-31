package com.view;

import com.controller.SpecialtyController;
import com.model.Specialty;

public class SpecialtyView {

    SpecialtyController specialtyController = new SpecialtyController();

    public void getSpecialtyById(Long id) {
        System.out.println("ID:   " + specialtyController.getSpecialtyById(id).getId());
        System.out.println("Name: " + specialtyController.getSpecialtyById(id).getName());
        System.out.println("==========");
    }

    public void getAllSpecialty() {
        for (Specialty d: specialtyController.getAllSpecialty()) {
            System.out.println("ID:   " + d.getId());
            System.out.println("Name: " + d.getName());
            System.out.println("==========");
        }
    }

    public void deleteSpecialtyById(Long id) {
        specialtyController.getSpecialtyById(id);
        System.out.println("Специальность удалена");
        specialtyController.deleteSpecialtyById(id);
    }

    public void updateSpecialty(Long id, String name) {
        specialtyController.updateSpecialty(id, name);
    }

    public void insertSpecialty(String name) {
        specialtyController.insertSpecialty(name);
    }

}
