package de.onsite.ood.factorymethod;

//tag::example[]
class Student {
    private final Teacher teacher;

    Student(Teacher teacher) {
        this.teacher = teacher;
    }

    void practice(){
        teacher.createProblem().solve();
    }
}
//end::example[]
