const input = [
  "31,Site de investimentos,,",
  "33,Notícias,,31",
  "47,Nacionais,/noticias-nacionais,33",
  "49,Internacionais,/noticias-internacionais,33",
  "53,Economia,,31",
  "57,Bolsa de valores,,53",
  "61,Ações,/acoes,57",
  "65,Fundos imobiliários,/fii,57",
  "72,Indicadores,/indicadores,53",
  "75,Blog,/blog,53"
]

const input2 = [
  "722,Sistema de contabilidade,,",
  "812,Início,/,722",
  "825,Clientes,,722",
  "831,Cadastro,/clients,825",
  "835,Relatórios,/clients/reports,825",
  "903,Financeiro,,722",
  "912,Resumo,/fin/summary,903",
  "928,Relatórios,/fin/reports,903"
]

class MenuItem {
  constructor(text, route = null) {
    this.text = text
    this.route = route
  }

  toString() {
    return `${this.text} (${this.route})`
  }
}

class Node {
  #element
  #parent
  #children

  constructor(element, parent = null) {
    this.#element = element
    this.#parent = parent
    this.#children = []
  }

  element() {
    return this.#element
  }

  _setElement(element) {
    this.#element = element
  }

  _getParent() {
    return this.#parent
  }

  _setParent(parent) {
    this.#parent = parent
  }

  _getChildren() {
    return this.#children
  }

  _addChild(child) {
    this.#children.push(child)
    child._setParent(this)
  }

  _removeChild(child) {
    this.#children = this.#children.filter(c => c !== child)
    child._setParent(null)
  }

  _isLeaf() {
    return this.#children.length === 0
  }
}

class GenericTree {

  #root
  #size

  constructor() {
    this.#root = null
    this.#size = 0
  }

  add(element, parent = null) {
    if (!this.isEmpty() && !parent) {
      throw new Error("Parent position can't be null for a non-empty tree")
    }
    const parentNode = parent ? this.#validate(parent) : null
    const newNode = new Node(element, parentNode)
    if (!parentNode) {
      this.#root = newNode
    }
    else {
      parentNode._addChild(newNode)
    }
    this.#size++
    return newNode
  }

  #validate(node) {
    if (!(node instanceof Node)) {
      throw new Error("Invalid position type")
    }
    return node
  }

  #isLeaf(node) {
    return node._isLeaf()
  }

  isEmpty() {
    return this.#size === 0
  }

  size() {
    return this.#size
  }

  toStringFormat() {
    let sb = []
    this.toStringFormatHelper(this.#root, 0, sb)
    return sb.join("")
  }

  toStringFormatHelper(node, depth, sb) {
    if (!node) return
    let space = (depth > 0) ? "    ".repeat(depth) : ""
    sb.push(`${space}${node.element().toString()}\n`)
    for (const child of node._getChildren()) {
      this.toStringFormatHelper(child, depth + 1, sb)
    }
  }
}

function generateTree(input) {
  const itens = new Map()
  const menu = new GenericTree()

  for (const line of input) {
    const [id, text, route, parentId] = line.split(",")
    const parent = parentId ? itens.get(parentId) : null
    const menuItem = new MenuItem(text, route || null)
    const newNode = menu.add(menuItem, parent)
    itens.set(id, newNode)
  }

  console.log(menu.toStringFormat())
}

generateTree(input)
console.log(`\n`)
generateTree(input2)