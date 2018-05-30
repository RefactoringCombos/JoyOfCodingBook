class Lambda {
    a() {
        var cake = 50;
        /* Introduce.Lambda.Example.1 */
        //Original
        var eat = cake - (1 / 2) * cake;
        /* end */
        return eat;
    }

    b() {
        var cake = 50;
        /* Introduce.Lambda.Example.2 */
        // Introduce Lambda
        var eat = (()=>cake - (1 / 2) * cake)();
        /* end */
        return eat;
    }

    c() {
        var cake = 50;
        /* Introduce.Lambda.Example.3 */
        // Introduce Lambda parameter
        var eat = ((c)=>c - (1 / 2) * c)(cake);
        /* end */
        return eat;
    }
}


module.exports = {
    Lambda
}
