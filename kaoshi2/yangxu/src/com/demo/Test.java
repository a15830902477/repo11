package com.demo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @PackageName: com.demo
 * @ClassName: Test
 * @Description: TODO
 * @Author: yangxu
 * @DateTime: 2020/7/12 23:52
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner  sc=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<>();

        while(1>0){
            System.out.println("--------欢迎来到学生管理系统-------");
            System.out.println("1 添加学生");
            System.out.println("2 删除学生");
            System.out.println("3 修改学生");
            System.out.println("4 查看学生");
            System.out.println("5 退出");
            System.out.println("请输入你的选择");
            String choice = sc.next();
            switch (choice){
                case "1":
                    addStudent(sc, list);
                    break;
                case "2":
                    System.out.println("删除学生");
                    System.out.println("请输入你要删除的学号");
                    String id = sc.next();
                    int index = queryId(list, id);
                    deleteStudent(list, index);
                    break;
                case "3":
                    System.out.println("修改学生");
                    System.out.println("请输入要修改的学号");
                    String id2 = sc.next();
                    int queryId = queryId(list, id2);
                    updateStudent(sc, list, id2, queryId);
                    break;
                case "4":
                    queryAllStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    System.exit(1);
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }

    private static void updateStudent(Scanner sc, ArrayList<Student> list, String id2, int queryId) {
        if(queryId==-1){
            System.out.println("学生不存在");
        }else{
            System.out.println("请输入新的姓名");
            String name = sc.next();
            System.out.println("请输入新的年龄");
            int age = sc.nextInt();
            System.out.println("请输入新的生日");
            String bir = sc.next();
            Student s=new Student(id2,name,age,bir);
            list.set(queryId,s);
            System.out.println("修改成功");
        }
    }

    private static void deleteStudent(ArrayList<Student> list, int index) {
        if(index==-1){
            System.out.println("学号不存在");
        }else{
            list.remove(index);
            System.out.println("删除ok");
        }
    }

    private static int queryId(ArrayList<Student> list, String id) {
        int index=-1;
        for (int i = 0; i < list.size(); i++) {
            Student student = list.get(i);
            if(student.getSid().equals(id)){
                    index=i;
            }
        }
        return index;
    }

    private static void queryAllStudent(ArrayList<Student> list) {
        System.out.println("查看学生");
        if(!list.isEmpty()){
            System.out.println("学号\t\t姓名\t\t年龄\t\t生日");
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getSid()+"\t\t"+list.get(i).getName()
                +"\t\t"+list.get(i).getAge()+"\t\t"+list.get(i).getBirthday());
            }
        }else System.out.println("无信息");
    }

    private static void addStudent(Scanner sc, ArrayList<Student> list) {
        System.out.println("添加学生");
        String sid=null;
        while (true){
            System.out.println("请输入学号");
            sid = sc.next();
            int queryId = queryId(list, sid);
            if(queryId==-1){
                //不存在
                break;
            }else{
                System.out.println("学号存在从新输入");
            }
        }
        System.out.println("请输入姓名");
        String name = sc.next();
        System.out.println("请输入年龄");
        int age = sc.nextInt();
        System.out.println("请输入生日");
        String birthday = sc.next();
        Student student=new Student(sid,name,age,birthday);
        list.add(student);
        System.out.println("添加成功");
    }
}
