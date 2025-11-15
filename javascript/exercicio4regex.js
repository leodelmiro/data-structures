function removeNonDigits(string) {
    const regex = /\D/g; // D todos não digitos e g para busca global
    return string.replace(regex, "");
}


console.log(removeNonDigits("94923784799"));
console.log(removeNonDigits("213.445.034-82"));

function extractEmailInformation(email) {
    const emailSplit = email.split("@")
    const user = emailSplit[0]
    const dominio = emailSplit[1]
    const regex = /.br$/g; // D todos não digitos e g para busca global
    const eBrasileiro = regex.test(email) ? 'sim' : 'nao';

    console.log(`Usuario: ${user}`)
    console.log(`Dominio: ${dominio}`)
    console.log(`Brasileiro: ${eBrasileiro}\n`)
}


extractEmailInformation("maria123@gmail.com");
extractEmailInformation("joao.silva23@yahoo.com.br");


function extractDateData(date) {
    const dateSplit = date.split('/')
    const dia = dateSplit[0]
    const mes = dateSplit[1]
    const ano = dateSplit[2]

    return { dia, mes, ano }
}

const dateFormatted = extractDateData('21/07/2010')
console.log(`Dia: ${dateFormatted.dia}`)
console.log(`Mês: ${dateFormatted.mes}`)
console.log(`Ano: ${dateFormatted.ano}\n`)

function formatDate(day, month, year) {
    return `${day}/${month}/${year}`
}

console.log(formatDate(dateFormatted.dia, dateFormatted.mes, dateFormatted.ano))