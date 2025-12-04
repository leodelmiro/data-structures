val cursosAlunos = arrayOf(arrayOf(15, 21, 80, 42), arrayOf(21, 80, 47), arrayOf(12, 21, 47, 35))

fun alunosUnicos(alunosMatriculados: Array<Array<Int>>): Int {
    val alunosUnicos = hashSetOf<Int>()

    for(cursos in alunosMatriculados) {
        for (aluno in cursos) {
            alunosUnicos.add(aluno)
        }
    }

    return alunosUnicos.size
}

println(alunosUnicos(cursosAlunos))