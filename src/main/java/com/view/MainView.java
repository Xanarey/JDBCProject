package com.view;

import com.model.Specialty;
import com.model.Status;

import java.util.Objects;
import java.util.Scanner;

public class MainView {

    private final Scanner scanner = new Scanner(System.in);
    private final DeveloperView developerView = new DeveloperView();
    private final SpecialtyView specialtyView = new SpecialtyView();
    private final SkillView skillView = new SkillView();

    public MainView() {}

    public void start() {

        do {
            System.out.println(MENU);
            CHOICE_MENU = scanner.nextLong();

            if (CHOICE_MENU == 2) {
                developerView.getAllDeveloper();
            }
            if (CHOICE_MENU == 3) {
                System.out.println("Введите id разработчика: ");
                do {
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.getDeveloperById(ID);
            }

            if (CHOICE_MENU == 4) {
                do {
                    System.out.println("Введите id:");
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.getDeveloperById(ID);
                System.out.println("Внести изменения: ");
                System.out.println("Введите firstName:");
                do {
                    FIRST_NAME = scanner.nextLine();
                } while (FIRST_NAME.equals(""));
                do {
                    System.out.println("Введите lastName:");
                    LAST_NAME = scanner.nextLine();
                } while (LAST_NAME.equals(""));
                specialtyView.getAllSpecialty();
                System.out.println("Выберите специальность по id: ");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                Specialty specialty = new Specialty();
                specialty.setId(SPECIALTY_ID);
                developerView.updateDeveloper(ID, FIRST_NAME, LAST_NAME, Status.ACTIVE, specialty);
            }

            if (CHOICE_MENU == 5) {
                do {
                    System.out.println("Введите id: ");
                    ID = scanner.nextLong();
                } while (ID <= 0);
                developerView.deleteDeveloperById(ID);
            }

            if (CHOICE_MENU == 6) {
                System.out.println("Введите First_Name:");
                do {
                    FIRST_NAME = scanner.nextLine();
                } while (Objects.equals(FIRST_NAME, ""));

                System.out.println("Введите Last_Name:");
                do {
                    LAST_NAME = scanner.nextLine();
                } while (Objects.equals(LAST_NAME, ""));
                specialtyView.getAllSpecialty();
                System.out.println("Выберите специальность по id: ");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                Specialty specialty = new Specialty();
                specialty.setId(SPECIALTY_ID);
                developerView.insertDeveloper(FIRST_NAME, LAST_NAME, Status.ACTIVE, specialty);
                System.out.println("Разработчик успешно добавлен");
            }

            if (CHOICE_MENU == 7) {
                specialtyView.getAllSpecialty();
            }

            if (CHOICE_MENU == 8) {
                System.out.println("Введите id:");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                specialtyView.getSpecialtyById(SPECIALTY_ID);
            }

            if (CHOICE_MENU == 9) {
                specialtyView.getAllSpecialty();
                System.out.println("Выберите изменяемую специальность по id: ");
                do {
                    SPECIALTY_ID = scanner.nextLong();
                } while (SPECIALTY_ID <= 0);
                System.out.println("Введите новое название специальности: ");
                do {
                    SPECIALTY_NAME = scanner.nextLine();
                } while (SPECIALTY_NAME.equals(""));
                specialtyView.updateSpecialty(SPECIALTY_ID, SPECIALTY_NAME);
                System.out.println("Специальность успешно изменена");
            }

            if (CHOICE_MENU == 10) {
                specialtyView.getAllSpecialty();
                System.out.println("Выберите id удаляемой специальности: " + "\n");
                do {
                    ID = scanner.nextLong();
                } while (ID <= 0);
                specialtyView.deleteSpecialtyById(ID);
            }

            if (CHOICE_MENU == 11) {
                System.out.println("Введите имя новой специальности: ");
                do {
                    SPECIALTY_NAME = scanner.nextLine();
                } while (SPECIALTY_NAME.equals(""));
                specialtyView.insertSpecialty(SPECIALTY_NAME);
                System.out.println("Специальность успешно добавлена");
            }

            if (CHOICE_MENU == 12) {
                skillView.getAllSkills();
            }

            if (CHOICE_MENU == 13) {
                System.out.println("Введите id скилла: ");
                do {
                    SKILL_ID = scanner.nextLong();
                } while (SKILL_ID <= 0);
                skillView.getSkillById(SKILL_ID);
            }

            if (CHOICE_MENU == 14) {
                System.out.println("Введите id изменяемого скилла: ");
                do {
                    SKILL_ID = scanner.nextLong();
                } while (SKILL_ID <= 0);
                System.out.println("Введите новое название: ");
                do {
                    SKILL_NAME = scanner.nextLine();
                } while (SKILL_NAME.equals(""));
                skillView.updateSkill(SKILL_ID, SKILL_NAME);
            }

            if (CHOICE_MENU == 15) {
                System.out.println("Введите id удаляемого скилла: ");
                do {
                    SKILL_ID = scanner.nextLong();
                } while (SKILL_ID <= 0);
                skillView.deleteSkillById(SKILL_ID);
            }

            if (CHOICE_MENU == 16) {
                System.out.println("Введите имя нового скилла: ");
                do {
                    SKILL_NAME = scanner.nextLine();
                } while (SKILL_NAME.equals(""));
                skillView.insertSkill(SKILL_NAME);
                System.out.println("Скилл успешно добавлен");
            }

        } while (CHOICE_MENU != 1);

    }

    public static String MENU = """
            __________MENU__________
            1.  Выход
            ---Работа с БД DEVELOPERS---
            2.  Вывести всех разработчиков
            3.  Вывести разработчика
            4.  Изменить запись разработчика
            5.  Удалить разработчика (ПОМЕТИТЬ КАК 'DELETED')
            6.  Добавить разработчика
            ---Работа с БД SPECIALTY---
            7.  Вывести все специальности
            8.  Вывести специальность
            9.  Изменить специальность
           10.  Удалить специальность
           11.  Добавить специальность
           ---Работа с БД SKILLS---
           12.  Вывести все скиллы
           13.  Вывести скилл
           14.  Изменить скилл
           15.  Удалить скилл
           16.  Добавить скилл
            """;
    public static Long ID = 0L;
    public static Long SPECIALTY_ID = 0L;
    public static Long SKILL_ID = 0L;
    public static Long CHOICE_MENU;
    public static Long STATUS_ID;
    public static String FIRST_NAME;
    public static String LAST_NAME;
    public static String SKILL_NAME;
    public static String SPECIALTY_NAME;
}