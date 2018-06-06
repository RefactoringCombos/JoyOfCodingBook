using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace JoyOfCodeSamples
{
    [TestClass]
    public class TestLambda
    {
        [TestMethod]
        public void Test()
        {
            int cake = 50;
            {
                /* Introduce.Lambda.Example.1 */
                //Original
                int eat = cake - (1 / 2) * cake;
                /* end */
            }
            {
                /* Introduce.Lambda.Example.2 */
                // Introduce Lambda
                int eat = ((Func<int>) (() => cake - (1 / 2) * cake))();
                /* end */
            }
            {
                /* Introduce.Lambda.Example.3 */
                // Introduce Lambda parameter
                int eat = ((Func<int, int>) (c => c - (1 / 2) * c))(cake);
                /* end */
            }
        }
    }
}