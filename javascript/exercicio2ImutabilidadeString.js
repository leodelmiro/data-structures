// Assim como em outras linguagens de programação, as strings em JavaScript são imutáveis. Isso significa que uma vez criada, uma string não pode ser alterada diretamente.
// Qualquer operação que pareça modificar uma string na verdade cria uma nova string.
let str = "hello, World!";
str[0] = "H"; // Tentativa de modificar o primeiro caractere
console.log(str); // Ainda será "Hello, World!"

let arr = str.split(""); // Converte a string em um array de caracteres
arr[0] = "H"; // Modifica o primeiro caractere no array
str = arr.join("");
console.log(str); // Agora será "Hello, World!"
