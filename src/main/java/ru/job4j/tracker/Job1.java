package ru.job4j.tracker;

    public class Job1 implements Comparable<Job1> {
        private String name;

        private int priority;

        public Job1(String name, int priority) {
            this.name = name;
            this.priority = priority;
        }

        public String getName() {
            return name;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "Job1{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    '}';
        }

        @Override
        public int compareTo(Job1 another) {
            return Integer.compare(priority, another.priority);
        }
    }

