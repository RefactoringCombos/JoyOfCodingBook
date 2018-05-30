import unittest


def a():
    cake = 50
    # /* Introduce.Lambda.Example.1 */
    # Original
    eat = cake - (1 / 2) * cake
    # /* end */
    return eat


def b():
    cake = 50
    # /* Introduce.Lambda.Example.2 */
    # Introduce Lambda
    eat = (lambda: cake - (1 / 2) * cake)()
    # /* end */
    return eat


def c():
    cake = 50
    # /* Introduce.Lambda.Example.3 */
    # Introduce Lambda parameter
    eat = (lambda c: c - (1 / 2) * c)(cake)
    # /* end */
    return eat


class TestLambda(unittest.TestCase):

    def test(self):
        self.assertEqual(25, a())
        self.assertEqual(25, b())
        self.assertEqual(25, c())
