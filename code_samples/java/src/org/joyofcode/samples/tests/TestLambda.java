package org.joyofcode.samples.tests;

import org.junit.Test;
import org.lambda.functions.Function0;
import org.lambda.functions.Function1;

public class TestLambda
{
  @Test
  public void test()
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
      int eat = ((Function0<Integer>) () -> cake - (1 / 2) * cake).call();
      /* end */
    }
    {
      /* Introduce.Lambda.Example.3  */
      // Introduce Lambda parameter
      int eat = ((Function1<Integer, Integer>) (c) -> c - (1 / 2) * c).call(cake);
      /* end */
    }
  }
}
