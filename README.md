# Week 9 - S9 Practice Problems

Abstraction & interfaces — each problem uses an `abstract` base class holding
the shared state (owner / units / name), an abstract calculation method the
subclasses override, and one polymorphic loop for processing.

## Problems

1. `GardenPlotAreaReport` — Circle/Rectangle/Triangle plots, `area()` per shape
2. `WeeklyStaffPay` — FullTime/Hourly (overtime 1.5x)/Intern; `StaffMember` is
   abstract so a generic staffer can't be instantiated
3. `LibraryLateFineCounter` — Book 2/day, DVD 5/day capped at 50, Magazine 1/day
4. `ElectricityConnectionBilling` — Home slab rates / Shop +100 fixed / Factory min 1000
5. `TravelBookingFee` — booking fee exists **once** on the base class;
   `total()` = `baseFare()` + fee is concrete while `baseFare()` stays abstract

## Run

```bash
javac *.java
printf "3\nCIRCLE Asha 5\nRECTANGLE Ravi 4 6\nTRIANGLE Neha 10 3\n" | java GardenPlotAreaReport
```

Abstract classes rather than interfaces here because every problem carries
instance state, which interfaces can't hold. `QUIZ.md` covers the MCQ and
concept questions.
