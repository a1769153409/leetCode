package com.study.iterator;

/**
 * @author huang.lehao@hand-china.com
 * @Description:
 * @date 2020/6/30 7:18
 */
public class DesignWithIterator {

    public interface Aggregate {

        public static Iterator iterator() {
            return null;
        }

    }


    public interface Iterator {

        public abstract boolean hasNext();
        public abstract Object next();

    }



    public static class Student {

        private String name;

        public Student(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public  class Classroom implements Aggregate {

        private Student[] students;
        private int last = 0;

        public Classroom(int size) {
            this.students = new Student[size];
        }

        public Student getStudent(int index) {
            return students[index];
        }

        public void addStudent(Student student) {
            this.students[last] = student;
            last++;
        }

        public int getLength() {
            return last;
        }

        public  Iterator iterator() {
            return new ClassroomIterator(this);
        }

    }


    public class ClassroomIterator implements Iterator {

        private Classroom classroom;
        private int index;

        public ClassroomIterator(Classroom classroom) {
            this.classroom = classroom;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            if(index < classroom.getLength()) {
                return true;
            } else {
                return false;
            }
        }

        @Override
        public Object next() {
            Student student = classroom.getStudent(index);
            index++;
            return student;
        }

    }
    public static abstract class AbstractDiscountCalculator {

        public void calculate() {
            // 完成通用的计算逻辑
            commonCalculate();
            // 完成特殊的计算逻辑
            specificCalculate();
        }

        private void commonCalculate() {
            System.out.println("通用的计算逻辑，修改了一下");
        }

        protected abstract void specificCalculate();

    }

}

