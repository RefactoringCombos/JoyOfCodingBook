//
// Created by LLEWELLYN FALCO on 12/14/17.
//

#ifndef CATCHPLAYGROUND_YOURCODEGOESHERE_H
#define CATCHPLAYGROUND_YOURCODEGOESHERE_H


#include <string>
#include <sstream>


static std::string introduce_lambda()
{
    std::stringstream text;
    int cake = 50;
    {
        /* Introduce.Lambda.Example.1 */
        //Original
        int eat = cake - ((1.0/2)  * cake);
        /* end */
        text << eat << " ";
    }
    {
        /* Introduce.Lambda.Example.2 */
        // Introduce Lambda
        int eat = ([&] { return cake - ((1.0/2) * cake);})();
        /* end */
        text << eat << " ";
    }
    {
        /* Introduce.Lambda.Example.3 */
        // Introduce Lambda parameter
        int eat = ([&](int c) { return c - ((1.0/2) * c);})(cake);
        /* end */
        text << eat << " ";
    }
    return text.str();
}
#endif //CATCHPLAYGROUND_YOURCODEGOESHERE_H
