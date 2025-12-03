class Browser {
    constructor() {
        this.currentPage = 'home'
        this.backStack = []
        this.forwardStack = []
    }

    getCurrentPage() {
        return this.currentPage
    }

    access(page) {
        this.backStack.push(this.currentPage)
        this.currentPage = page
        this.forwardStack = []
    }

    back() {
        if (this.isBackStackEmpty()) throw Error('Back error')

        this.forwardStack.push(this.currentPage)
        this.currentPage = this.backStack.pop()
    }

    isBackStackEmpty() {
        return this.backStack.length === 0
    }

    forward() {
        if (this.isForwardStackEmpty()) throw Error('Forward error')

        this.backStack.push(this.currentPage)
        this.currentPage = this.forwardStack.pop()
    }

    isForwardStackEmpty() {
        return this.forwardStack.length === 0
    }
}

function testNavigation(browser, commands) {
    const actions = {
        "get-current": () => browser.getCurrentPage(),
        "back": () => browser.back(),
        "forward": () => browser.forward(),
        "access": (url) => browser.access(url),
    }

    for (const line of commands) {
        const [cmd, arg] = line.split(",");

        const action = actions[cmd];
        if (!action) {
            console.log(`Unknown command: ${cmd}`);
            continue;
        }

        const result = action(arg);
        if (result !== undefined) {
            console.log(result);
        }
    }
}