package br.inatel.C207;

public class Principal {
    public static void main(String[] args){

        AlunoDB alunoDB = new AlunoDB();
        CursoDB cursoDB = new CursoDB();

        Aluno aluno1 = new Aluno("Davi",2001,"M");
        Aluno aluno2 = new Aluno("Aline",1998,"F");
        Curso curso1 = new Curso("Eng.Software");
        Curso curso2 = new Curso("Psicologia");

        /*
        alunoDB.insertAluno(aluno1);
        alunoDB.insertAluno(aluno2);
        cursoDB.insertCurso(curso1);
        cursoDB.insertCurso(curso2);
        */
        alunoDB.researchAluno();
        cursoDB.researchCurso();

        alunoDB.updateFkAluno(1,1);
        alunoDB.updateFkAluno(2,2);

        alunoDB.researchAluno();
        cursoDB.researchCurso();
        //*/


        alunoDB.researchAluno();
    }
}
