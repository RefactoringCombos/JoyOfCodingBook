package org.joyofcode.samples.tests;

public class EarlyReturnExampleArlo
{
  private int version1(String something)
  {
    if (something.equals("hello"))
    {
      /**
       *  big code here
       */
      return 1;
    }
    if (something.equals("world"))
    {
      /**
       *  big code here
       */
      for (int i = 0; i < 10; i++)
      {
        if (i < 5)
        {
          continue;
        }
        if (i % 2 == 0) { return i; }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      /**
       *  big code here
       */
      if (something.equals("math"))
      {
        /**
         *  big code here
         */
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  public static class Returns<T>
  {
    public boolean shouldReturn, shouldContinue, shouldBreak;
    public T       value;
    public void setReturn(T value)
    {
      shouldReturn = true;
      this.value = value;
    }
    public static <T> Returns<T> Continue()
    {
      Returns<T> r = new Returns<>();
      r.shouldContinue = true;
      return r;
    }
    public static <T> Returns<T> Return(T value)
    {
      Returns<T> r = new Returns<>();
      r.setReturn(value);
      return r;
    }
    public boolean returnOrBreak()
    {
      return shouldBreak || shouldReturn;
    }
  }
  private int version2(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        // Create type
        Returns<Integer> returnValue = new Returns<>();
        if (i < 5)
        {
          continue;
        }
        if (i % 2 == 0) { return i; }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private int version3(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        Returns<Integer> returnValue = new Returns<>();
        if (i < 5)
        {
          returnValue.shouldContinue = true;
          continue;
        }
        if (i % 2 == 0)
        {
          returnValue.setReturn(i);
          return i;
        }
        // set values
        if (returnValue.shouldReturn) { return returnValue.value; }
        if (returnValue.shouldContinue)
        {
          continue;
        }
        if (returnValue.shouldBreak)
        {
          break;
        }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private int version4(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        Returns<Integer> returnValue = new Returns<>();
        // Containing loop 
        for (int j = 0; j < 1; j++)
        {
          if (i < 5)
          {
            returnValue.shouldContinue = true;
            continue;
          }
          if (i % 2 == 0)
          {
            returnValue.setReturn(i);
            return i;
          }
        }
        if (returnValue.shouldReturn) { return returnValue.value; }
        if (returnValue.shouldContinue)
        {
          continue;
        }
        if (returnValue.shouldBreak)
        {
          break;
        }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private int version5(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        Returns<Integer> returnValue = new Returns<>();
        for (int j = 0; j < 1; j++)
        {
          if (i < 5)
          {
            returnValue.shouldContinue = true;
            // add breaks;
            break;
            continue;
          }
          if (i % 2 == 0)
          {
            returnValue.setReturn(i);
            break;
            return i;
          }
        }
        if (returnValue.shouldReturn) { return returnValue.value; }
        if (returnValue.shouldContinue)
        {
          continue;
        }
        if (returnValue.shouldBreak)
        {
          break;
        }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private int version6(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        Returns<Integer> returnValue = whateverMyInnerParagraphDid1(i);
        if (returnValue.shouldReturn) { return returnValue.value; }
        if (returnValue.shouldContinue)
        {
          continue;
        }
        if (returnValue.shouldBreak)
        {
          break;
        }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private int version7(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      for (int i = 0; i < 10; i++)
      {
        Returns<Integer> returnValue = whateverMyInnerParagraphDid1(i);
        if (returnValue.shouldReturn) { return returnValue.value; }
        if (returnValue.shouldContinue)
        {
          continue;
        }
        if (returnValue.shouldBreak)
        {
          break;
        }
      }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
  private Returns<Integer> whateverMyInnerParagraphDid1(int i)
  {
    Returns<Integer> returnValue = new Returns<>();
    for (int j = 0; j < 1; j++)
    {
      if (i < 5)
      {
        returnValue.shouldContinue = true;
        // Extract Method
        break;
      }
      if (i % 2 == 0)
      {
        returnValue.setReturn(i);
        break;
      }
    }
    return returnValue;
  }
  private Returns<Integer> whateverMyInnerParagraphDid2(int i)
  {
    Returns<Integer> returnValue = new Returns<>();
    for (int j = 0; j < 1; j++)
    {
      if (i < 5) { return Returns.Continue(); }
      if (i % 2 == 0) { return Returns.Return(1); }
    }
    return returnValue;
  }
  private Returns<Integer> whateverMyInnerParagraphDid3(int i)
  {
    if (i < 5) { return Returns.Continue(); }
    if (i % 2 == 0) { return Returns.Return(1); }
    return new Returns<>();
  }
  private int version8(String something)
  {
    if (something.equals("hello")) { return 1; }
    if (something.equals("world"))
    {
      Returns<Integer> returnValue = null;
      for (int i = 0; i < 10; i++)
      {
        returnValue = whateverMyInnerParagraphDid1(i);
        if (returnValue.returnOrBreak())
        {
          break;
        }
      }
      if (returnValue.shouldReturn) { return returnValue.value; }
      return 2;
    }
    if (something.equals("folding"))
    {
      if (something.equals("math"))
      {
        return 3;
      }
      else
      {
        return 4;
      }
    }
    return 0;
  }
}
