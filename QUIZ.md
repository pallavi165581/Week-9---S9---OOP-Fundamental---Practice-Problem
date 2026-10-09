# Week 9 Quiz & Concept Answers

## Quiz (MCQ)

1. **C** — abstraction = show *what* an object does, hide *how* it does it.
2. **C** — an abstract class cannot be instantiated directly.
3. **B** — the class must be declared abstract, or it won't compile.
4. **C** — `private` is not allowed on an abstract method.
5. **C** — interface fields are implicitly `public static final`.
6. **C** — a class can implement any number of interfaces.
7. **D** — interface methods are implicitly public, so implementations must be
   `public` (you can't reduce visibility when overriding).
8. **C** — interfaces carry no instance state, so there's no conflicting data
   to inherit — that's what sidesteps the diamond problem.
9. **D** — two same-signature default methods collide → compile error until the
   class overrides it itself.
10. **B** — abstract classes can have constructors; they run via `super()` when
    a subclass object is created.

## Concept Questions

1. **Abstraction** = exposing only the essential operations of something while
   hiding the internal machinery. Real-life: an ATM — you press "withdraw" and
   get cash; you never see balance checks, note counting, or ledger updates.
   Shown: the menu of operations. Hidden: everything behind it.
2. **Abstraction vs encapsulation.** Abstraction hides *complexity* — what the
   user needs to know vs. how it works. Encapsulation hides *data* — private
   fields behind controlled methods. In one class they work together: `private
   double balance` (encapsulation) sits behind `withdraw(amount)` (abstraction)
   — the caller sees a simple operation, the class protects its state.
3. **Why abstract classes have constructors.** A subclass must initialize the
   inherited part of itself — the abstract parent's fields need values too.
   `new Car("KA01")` runs `Vehicle`'s constructor via `super(...)` first, then
   Car's. You can't `new` the abstract class itself, but its constructor still
   runs inside every concrete subclass construction.
4. **Why not private/static/final on abstract methods.**
   `private` — subclass can't even see it, so it could never be implemented.
   `static` — static methods resolve at compile time by class, not by object;
   there's no instance to dispatch the "implementation" to.
   `final` — final literally means "cannot be overridden," which directly
   contradicts abstract's "must be overridden."
5. **The diamond problem.** If B and C both extend A, and D extends both B and
   C, which copy of A's data/methods does D get? Ambiguous. Java avoids it:
   single class inheritance means only one source of state, while multiple
   interfaces are safe because they (traditionally) carried only method
   signatures — no state to conflict. For default-method clashes, Java forces
   an explicit override (compile error otherwise).
