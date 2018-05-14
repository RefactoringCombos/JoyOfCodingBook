# Introduce Lambda
    
    <codeblock Introduce.Lambda.Example.1 />
    <codeblock Introduce.Lambda.Example.2 />
    <codeblock Introduce.Lambda.Example.3 />


## Decription 

Introduce lambda is a common ingredient in many other dishes.
Is a variation on Extract Method, smaller and more suited for 
times where the automated refactoring is missing, or when you are looking
to extract a operation as a variable or parameter.


## Recipe  (How)
 
Identify the section of code that you want to enlambdafy. 
Surround it with the characters for lambda begin, lambda end, * and call the lambda.  

Afterwards, you may want to introduce parameters to your lambda.
Add these one at a time, leaning on your compiler to verify each step.

#Local Flavors:
```
C++  
([&]() {return n + 2})()
 
C#
(() => n + 2)()
 
Java
((Function0<Integer>) () -> n + 2 )()
 
Javascript
(function(){return n+2;}())
 
ES6
(() => n + 2)()
 
Python
 (lambda(): n + 2)()
 

```

## Advantages

Allows you to separate when the code is defined from when it is evaluated.
Allowing you to move them independently.  

Either:  
Maintain when it is **evaluated**, but change where it is **defined**.  
or   
Maintain where it is **defined**, but change when it is **evaluated**.

## Opportunities 

Keep and eye out for when:

* Duplication varies by operation preformed.
* Tooling doesn't have extract method automated refactoring.
* You have a desire to pass in or abstract the operation.
* An other recipe requires this as a step.

## Pairs well with...

* [Replace supplier with func]()
* [Encaplusate logic]()
* [remove duplication]()
* [synchronous to async]()
* [Async to synchronous]()
* [Switching to event driven]()
* [Switching to lazy evaluation]()


#Reviews
"Anytime I have a bit of calculation I want to abstract, introduce lambda is my goto recipe! " 

#Video?


