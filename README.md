##SWE 619 Assignment 8 Spring 2021
###Goal: Generics

Consider the BoundedQueue example from in-class exercise #8C.

Complete the generic part of the exercise: The result should be fully generic, and there should not be any compiler warnings. You should adopt Bloch's advice about lists vs. arrays; doing so will eliminate the need for many of the instance variables.

Keep the same methods, but update the behavior (and document with contracts!) to include exception handling for all cases not on the happy path.
Include the constructor in your considerations. In particular, consider whether you think a zero-sized buffer is a reasonable possibility. Document your reasoning. This is less about a right vs. wrong answer than a careful consideration of the consequences of the decision.
Add putAll() and getAll(). Define the method signatures carefully. Use exception-handling consistent with that for get() and put(). Use bounded wildcards as appropriate. Note that putAll() has a special case where there isn't sufficient space in the bounded queue. Adopt a solution you think Bloch and/or Liskov would approve of. In particular, Bloch prefers that when methods throw exceptions, there is no change to the state of the object.

As before, turn in a clear, concise story demonstrating completion of the assignment.