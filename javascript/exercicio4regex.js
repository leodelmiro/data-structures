function removeNonDigits(string) {
    const regex = /\D/g; // D todos não digitos e g para busca global
    return string.replace(regex, "");
}


console.log(removeNonDigits("94923784799"));
console.log(removeNonDigits("213.445.034-82"));