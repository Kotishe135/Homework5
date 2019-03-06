package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static String array = "{}";

    public static void window() {
        JFrame wind = new JFrame("Работа с массивом");
        wind.setBounds((int) ((Toolkit.getDefaultToolkit().getScreenSize().width - 250) / 2), (int) ((Toolkit.getDefaultToolkit().getScreenSize().height - 120) / 2), 250, 120);
        wind.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wind.setResizable(false);
        wind.setLayout(null);

        JPanel butDel = new JPanel();
        butDel.setLayout(null);
        butDel.setBounds(0, wind.getHeight() - 56, (int) wind.getWidth() / 2, 40);

        JPanel addElemPanel = new JPanel();
        addElemPanel.setLayout(null);
        addElemPanel.setBounds(0, 0, (int) wind.getWidth() / 2, 25);

        JPanel changeSort = new JPanel();
        changeSort.setLayout(null);
        changeSort.setBounds(addElemPanel.getWidth(), 0, (int) wind.getWidth() / 2, 25);

        JPanel panel = new JPanel();
        //panel.setBounds(0, 0, wind.getWidth(), 25);

        JScrollPane scroll = new JScrollPane(panel);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scroll.setBounds(0, changeSort.getHeight(), wind.getWidth(), 40);

        JLabel strArr = new JLabel(array);
        strArr.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        panel.add(strArr);

        String[] types = {
                "Целочисленный",
                "Вещественный",
                "Символьный",
                "Строковый"
        };
        JComboBox type = new JComboBox(types);
        type.setBounds(0, 0, changeSort.getWidth(), changeSort.getHeight());
        changeSort.add(type);

        JTextField elem = new JTextField();
        elem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String el = elem.getText();
                switch (types[type.getSelectedIndex()]) {
                    case "Целочисленный":
                        try {
                            int x = Integer.parseInt(el);
                        } catch (NumberFormatException NF) {
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                    case "Вещественный":
                        try {
                            Double x = Double.parseDouble(el);
                        } catch (NumberFormatException NF) {
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                    case "Строковый":
                        el = "\"" + el + "\"";
                        break;
                    case "Символьный":
                        if (el.length() > 1){
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                }


                if (!array.equals("{}")) {
                    array = array.substring(0, array.length() - 1) + ", }";
                }

                array = array.substring(0, array.length() - 1) + el + "}";
                strArr.setText(array);
                elem.setText("");
                type.disable();
            }
        });
        elem.setBounds(0, 0, addElemPanel.getWidth() - 50, addElemPanel.getHeight());
        addElemPanel.add(elem);

        JButton add = new JButton("Добавить");
        add.setMargin(new Insets(0, 0, 0, 0));
        add.setFont(new Font("Times New Roman", 0, 10));
        add.setBounds(elem.getWidth(), 0, 50, addElemPanel.getHeight());
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String el = elem.getText();
                switch (types[type.getSelectedIndex()]) {
                    case "Целочисленный":
                        try {
                            int x = Integer.parseInt(el);
                        } catch (NumberFormatException NF) {
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                    case "Вещественный":
                        try {
                            Double x = Double.parseDouble(el);
                        } catch (NumberFormatException NF) {
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                    case "Строковый":
                        el = "\"" + el + "\"";
                        break;
                    case "Символьный":
                        if (el.length() > 1){
                            JOptionPane.showMessageDialog(null, "Введите целое число в выбранном формате");
                            return;
                        }
                        break;
                }


                if (!array.equals("{}")) {
                    array = array.substring(0, array.length() - 1) + ", }";
                }

                array = array.substring(0, array.length() - 1) + el + "}";
                strArr.setText(array);
                elem.setText("");
                type.disable();
            }
        });
        addElemPanel.add(add);

        JButton del = new JButton("Удалить");
        del.setMargin(new Insets(0, 0, 0, 0));
        del.setFont(new Font("Times New Roman", 0, 10));
        del.setBounds(0, 0, butDel.getWidth() / 2, 30);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] sp = array.split(", ");
                array = sp[0];
                for (int i = 1; i < sp.length - 1; i++) {
                    array += ", " + sp[i];
                }
                if (sp.length > 1) {
                    array += "}";
                } else {
                    array = "{}";
                }
                strArr.setText(array);
                if (array.equals("{}")) {
                    type.enable();
                }
            }
        });
        butDel.add(del);

        JButton delAll = new JButton("Очистить");
        delAll.setMargin(new Insets(0, 0, 0, 0));
        delAll.setFont(new Font("Times New Roman", 0, 10));
        delAll.setBounds((int) butDel.getWidth() / 2, 0, butDel.getWidth() / 2, 30);
        delAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                array = "{}";
                strArr.setText(array);
                type.enable();
            }
        });
        butDel.add(delAll);

        JButton useReverce = new JButton("Перевернуть");
        useReverce.setMargin(new Insets(0, 0, 0, 0));
        useReverce.setFont(new Font("Times New Roman", 0, 10));
        useReverce.setBounds(wind.getWidth() / 2, wind.getHeight() - 56, wind.getWidth() / 4, 30);
        useReverce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!array.equals("{}")) {
                    array = array.substring(1, array.length() - 1);
                    String[] split = array.split(", ");

                    switch (types[type.getSelectedIndex()]){
                        case "Целочисленный":
                            Arr<Integer> mass = new Arr<>();
                            Integer[] arr = new Integer[split.length];
                            for (int i = 0; i < arr.length; i++) {
                                arr[i] = Integer.parseInt(split[i]);
                            }
                            mass.setArr(arr);
                            mass.setArr(arr = mass.reverce());
                            split = mass.toArrayString();
                            break;
                        case "Вещественный":
                            Arr<Double> massP = new Arr<>();
                            Double[] arrP = new Double[split.length];
                            for (int i = 0; i < arrP.length; i++) {
                                arrP[i] = Double.parseDouble(split[i]);
                            }
                            massP.setArr(arrP);
                            massP.setArr(arrP = massP.reverce());
                            split = massP.toArrayString();
                            break;
                        case "Строковый":
                            Arr<String> massS = new Arr<>();
                            massS.setArr(split);
                            split = massS.reverce();
                            break;
                        case "Символьный":
                            Arr<Character> massC = new Arr<>();
                            Character[] arrC = new Character[split.length];
                            for (int i = 0; i < arrC.length; i++) {
                                arrC[i] = split[i].charAt(0);
                            }
                            massC.setArr(arrC);
                            massC.setArr(arrC = massC.reverce());
                            split = massC.toArrayString();
                            break;
                    }
                    array = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        array += split[i] + ", ";
                    }
                    array = "{" + array + split[split.length - 1] + "}";
                    strArr.setText(array);
                }
            }
        });

        JButton useChange = new JButton("Заменить");
        useChange.setMargin(new Insets(0, 0, 0, 0));
        useChange.setFont(new Font("Times New Roman", 0, 10));
        useChange.setBounds(wind.getWidth() - wind.getWidth() / 4, wind.getHeight() - 56, wind.getWidth() / 4, 30);
        useChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!array.equals("{}")) {
                    String[] split = array.substring(1, array.length() - 1).split(", ");

                    if (split.length < 2) {
                        JOptionPane.showMessageDialog(null, "Чтобы поменять два элемента местами, в массиве должно быть, хотя бы, 2 элемента");
                        return;
                    }

                    int num1, num2;
                    try {
                        num1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите номер 1 элемента"));
                        num2 = Integer.parseInt(JOptionPane.showInputDialog(null, "Введите номер 2 элемента"));
                    } catch (NumberFormatException NFE) {
                        JOptionPane.showMessageDialog(null, "Введите номер числом");
                        return;
                    }

                    switch (types[type.getSelectedIndex()]) {
                        case "Целочисленный":
                            Arr<Integer> mass = new Arr<>();
                            Integer[] arr = new Integer[split.length];
                            for (int i = 0; i < arr.length; i++) {
                                arr[i] = Integer.parseInt(split[i]);
                            }
                            mass.setArr(arr);
                            mass.setArr(arr = mass.change(num1, num2));
                            split = mass.toArrayString();
                            break;
                        case "Вещественный":
                            Arr<Double> massP = new Arr<>();
                            Double[] arrP = new Double[split.length];
                            for (int i = 0; i < arrP.length; i++) {
                                arrP[i] = Double.parseDouble(split[i]);
                            }
                            massP.setArr(arrP);
                            massP.setArr(arrP = massP.change(num1, num2));
                            split = massP.toArrayString();
                            break;
                        case "Строковый":
                            Arr<String> massS = new Arr<>();
                            massS.setArr(split);
                            split = massS.change(num1, num2);
                            break;
                        case "Символьный":
                            Arr<Character> massC = new Arr<>();
                            Character[] arrC = new Character[split.length];
                            for (int i = 0; i < arrC.length; i++) {
                                arrC[i] = split[i].charAt(0);
                            }
                            massC.setArr(arrC);
                            massC.setArr(arrC = massC.change(num1, num2));
                            split = massC.toArrayString();
                            break;
                    }
                    array = "";
                    for (int i = 0; i < split.length - 1; i++) {
                        array += split[i] + ", ";
                    }
                    array = "{" + array + split[split.length - 1] + "}";
                    strArr.setText(array);
                }
            }
        });

        wind.getContentPane().add(addElemPanel);
        wind.getContentPane().add(changeSort);
        wind.getContentPane().add(scroll);
        wind.getContentPane().add(useReverce);
        wind.getContentPane().add(useChange);
        wind.getContentPane().add(butDel);
        wind.setVisible(true);
    }

    public static void main(String[] args) {
        window();
    }
}
