const nota1 = 8.5;
const nota2 = 7.0;
const nota3 = 9.0;


const media = (nota1 + nota2 + nota3) / 3;


if (media >= 7) {
    console.log(`Média: ${media.toFixed(2)} - Aluno Aprovado! 🚀`);
} else {
    console.log(`Média: ${media.toFixed(2)} - Aluno em Recuperação. 📚`);
}