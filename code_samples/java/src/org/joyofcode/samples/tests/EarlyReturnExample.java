package org.joyofcode.samples.tests;

public class EarlyReturnExample
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
  private int version2(String something)
  {
    // Introduce return item;
    Integer returnValue = null;
    if (something.equals("hello")) { return 1; }
    if (something.equals("world")) { return 2; }
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
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      // Capture Value;
      returnValue = 1;
      return returnValue;
    }
    if (something.equals("world")) { return 2; }
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
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      // Check Value;
      returnValue = 1;
      if (returnValue != null) { return returnValue; }
    }
    if (something.equals("world")) { return 2; }
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
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    // move if
    if (returnValue != null) { return returnValue; }
    if (something.equals("world")) { return 2; }
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
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    // add else
    if (returnValue != null)
    {
      return returnValue;
    }
    else
    {
    }
    if (something.equals("world")) { return 2; }
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
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    // expand else
    if (returnValue != null)
    {
      return returnValue;
    }
    else
    {
      if (something.equals("world")) { return 2; }
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
  private int version8(String something)
  {
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    // Flip if/else
    if (returnValue == null)
    {
      if (something.equals("world")) { return 2; }
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
    else
    {
      return returnValue;
    }
  }
  private int version9(String something)
  {
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    // Repeat until last statements are all:
    // return returnValue;
    if (returnValue == null)
    {
      if (something.equals("world"))
      {
        returnValue = 2;
      }
      if (returnValue == null)
      {
        if (something.equals("folding"))
        {
          if (something.equals("math"))
          {
            returnValue = 3;
          }
          else
          {
            returnValue = 4;
          }
        }
        if (returnValue == null)
        {
          returnValue = 0;
        }
        else
        {
          return returnValue;
        }
        if (returnValue != null) { return returnValue; }
      }
      else
      {
        return returnValue;
      }
    }
    else
    {
      return returnValue;
    }
  }
  private int version10(String something)
  {
    Integer returnValue = null;
    if (something.equals("hello"))
    {
      returnValue = 1;
    }
    if (returnValue == null)
    {
      if (something.equals("world"))
      {
        returnValue = 2;
      }
      if (returnValue == null)
      {
        if (something.equals("folding"))
        {
          if (something.equals("math"))
          {
            returnValue = 3;
          }
          else
          {
            returnValue = 4;
          }
        }
        // Collapse redundancies
        if (returnValue == null)
        {
          returnValue = 0;
        }
      }
    }
    return returnValue;
  }
}
