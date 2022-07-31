package com.view;

import com.controller.DeveloperController;
import com.model.Developer;
import com.model.Specialty;
import com.model.Status;

public class DeveloperView {

    DeveloperController developerController = new DeveloperController();

    public void getDeveloperById(Long id) {
        System.out.println("ID:           " + developerController.getDeveloperById(id).getId());
        System.out.println("FirstName:    " + developerController.getDeveloperById(id).getFirstName());
        System.out.println("LastName:     " + developerController.getDeveloperById(id).getLastName());
        System.out.println("Status:       " + developerController.getDeveloperById(id).getStatus());
        System.out.println("Specialty_id: " + developerController.getDeveloperById(id).getSpecialty().getId());
        System.out.println("==============================================");
    }

    public void getAllDeveloper() {
        for (Developer d: developerController.getAllDeveloper()) {
            System.out.println("ID:           " + d.getId());
            System.out.println("FirstName:    " + d.getFirstName());
            System.out.println("LastName:     " + d.getLastName());
            System.out.println("Status:       " + d.getStatus());
            System.out.println("Specialty_id: " + d.getSpecialty().getId());
            System.out.println("==============================================");
        }
    }

    public void deleteDeveloperById(Long id) {
        developerController.deleteDeveloperById(id);
        System.out.println("Разработчик помечен как 'DELETED' : ");
    }

    public void updateDeveloper(Long id, String firstName, String lastName, Status status, Specialty specialty) {
        developerController.updateDeveloper(id, firstName, lastName, status, specialty);
        System.out.println("Данные успешно изменены на : ");
        System.out.println("ID:           " + id);
        System.out.println("FirstName:    " + firstName);
        System.out.println("LastName:     " + lastName);
        System.out.println("Status:       " + status.name());
        System.out.println("Specialty_id: " + specialty.getId());
        System.out.println("==============================================");
    }

    public void insertDeveloper(String firstName, String lastName, Status status, Specialty specialty) {
        developerController.insertDeveloper(firstName, lastName, status, specialty);
    }
}
