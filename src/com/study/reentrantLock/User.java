package com.study.reentrantLock;

public class User{
        private String name;
        private String name1;

    public User() {
    }

    public User(String name, String name1) {
            this.name = name;
            this.name1 = name1;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", name1='" + name1 + '\'' +
                    '}';
        }
    }